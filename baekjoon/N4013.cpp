#include <bits/stdc++.h>
using namespace std;
#define MAX_N 500001
int n, m, s, p, cnt, sccCnt;
bool res[MAX_N], sccRes[MAX_N];
int cash[MAX_N], visited[MAX_N], scc[MAX_N], sccCash[MAX_N], memo[MAX_N];
vector<int> graph[MAX_N], sccGraph[MAX_N];
stack<int> st;
int dfsScc(int v)
{
	int ret = visited[v] = ++cnt;
	st.push(v);
	for (int i : graph[v])
	{
		if (!visited[i])
			ret = min(ret, dfsScc(i));
		else if (scc[i] < 0)
			ret = min(ret, visited[i]);
	}
	if (ret == visited[v])
	{
		while (st.top() != v)
		{
			scc[st.top()] = sccCnt;
			st.pop();
		}
		scc[v] = sccCnt++;
		st.pop();
	}
	return ret;
}
int dp(int a)
{
	if (memo[a] >= 0)
		return memo[a];
	memo[a] = -1;
	for (int i : sccGraph[a])
		memo[a] = max(memo[a], dp(i));
	if (memo[a] >= 0)
		memo[a] += sccCash[a];
	else if (sccRes[a])
		memo[a] = sccCash[a];
	return memo[a];
}
int main()
{
	scanf("%d%d", &n, &m);
	for (int i = 0; i < m; i++)
	{
		int in[2];
		scanf("%d%d", &in[0], &in[1]);
		graph[in[0]].push_back(in[1]);
	}
	for (int i = 1; i <= n; i++)
		scanf("%d", &cash[i]);
	scanf("%d%d", &s, &p);
	memset(res, false, sizeof(res));
	for (int i = 0; i < p; i++)
	{
		int in;
		scanf("%d", &in);
		res[in] = true;
	}
	memset(visited, 0, sizeof(visited));
	memset(scc, -1, sizeof(scc));
	cnt = 0;
	sccCnt = 0;
	for (int i = 1; i <= n; i++)
	{
		if (!visited[i])
			dfsScc(i);
	}
	memset(sccRes, false, sizeof(sccRes));
	memset(sccCash, 0, sizeof(sccCash));
	for (int i = 1; i <= n; i++)
	{
		if (res[i])
			sccRes[scc[i]] = true;
		sccCash[scc[i]] += cash[i];
		for (int j : graph[i])
		{
			if (scc[i] != scc[j])
				sccGraph[scc[i]].push_back(scc[j]);
		}
	}
	memset(memo, -1, sizeof(memo));
	printf("%d", dp(scc[s]));
	return 0;
}
