#include <bits/stdc++.h>
using namespace std;
const int S = 0, E = 501, MAX_V = 502;

bool isA[MAX_V];
int n, c[MAX_V][MAX_V], work[MAX_V], level[MAX_V];
vector<int> a, b;

int bfs()
{
	memset(level, 0, sizeof(level));
	level[S] = 1;
	queue<int> q;
	q.push(S);
	while (!q.empty())
	{
		int peak = q.front();
		q.pop();
		for (int i = 0; i < MAX_V; i++)
		{
			if (!level[i] && c[peak][i] > 0)
			{
				level[i] = level[peak] + 1;
				q.push(i);
			}
		}
	}
	return level[E];
}

int dfs(int node, int flow)
{
	if (node == E)
		return flow;
	while (work[node] < MAX_V)
	{
		int next = work[node]++;
		if (level[next] == level[node] + 1 && c[node][next] > 0)
		{
			int ret = dfs(next, min(c[node][next], flow));
			if (ret > 0)
			{
				c[node][next] -= ret;
				c[next][node] += ret;
				return ret;
			}
		}
	}
	return 0;
}

int main()
{
	scanf("%d", &n);
	memset(c, 0, sizeof(c));
	for (int i = 1; i <= n; i++)
	{
		int in;
		scanf("%d", &in);
		if (in == 1)
			c[S][i] = INT32_MAX;
		if (in == 2)
			c[i][E] = INT32_MAX;
	}
	for (int i = 1; i <= n; i++)
		for (int j = 1; j <= n; j++)
			scanf("%d", &c[i][j]);
	int ans = 0;
	while (bfs())
	{
		memset(work, 0, sizeof(work));
		while (true)
		{
			int flow = dfs(S, INT32_MAX);
			if (!flow)
				break;
			ans += flow;
		}
	}
	memset(isA, false, sizeof(isA));
	queue<int> q;
	q.push(S);
	while (!q.empty())
	{
		int node = q.front();
		q.pop();
		for (int i = 1; i <= n; i++)
		{
			if (!isA[i] && c[node][i] > 0)
			{
				isA[i] = true;
				q.push(i);
			}
		}
	}
	for (int i = 1; i <= n; i++)
	{
		if (isA[i])
			a.push_back(i);
		else
			b.push_back(i);
	}
	printf("%d\n", ans);
	for (int i : a)
		printf("%d ", i);
	printf("\n");
	for (int i : b)
		printf("%d ", i);
	printf("\n");
	return 0;
}
