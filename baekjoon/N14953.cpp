#include <bits/stdc++.h>
using namespace std;
int n, m, a, b, memo[100000];
vector<int> graph[100000];
int dp(int v)
{
	if (memo[v])
		return memo[v];
	int ret = 0;
	for (int i : graph[v])
	{
		if (graph[i].size() > graph[v].size())
			ret = max(ret, dp(i));
	}
	return memo[v] = ret + 1;
}
int main()
{
	scanf("%d%d", &n, &m);
	for (int i = 0; i < m; i++)
	{
		scanf("%d%d", &a, &b);
		graph[a].push_back(b);
		graph[b].push_back(a);
	}
	int ans = 0;
	memset(memo, 0, sizeof(memo));
	for (int i = 0; i < n; i++)
		ans = max(ans, dp(i));
	printf("%d", ans);
	return 0;
}
