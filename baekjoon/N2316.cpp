#include <bits/stdc++.h>
using namespace std;
const int s = 3, e = 4;
int n, c[802][802], work[802], level[802];

int bfs()
{
	memset(level, 0, sizeof(level));
	level[s] = 1;
	queue<int> q;
	q.push(s);
	while (!q.empty())
	{
		int peak = q.front();
		q.pop();
		for (int i = 1; i <= n; i++)
		{
			if (!level[i] && c[peak][i] > 0)
			{
				level[i] = level[peak] + 1;
				q.push(i);
			}
		}
	}
	return level[e];
}

int dfs(int node, int flow)
{
	if (node == e)
		return flow;
	while (++work[node] <= n)
	{
		int next = work[node];
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
	int p;
	scanf("%d%d", &n, &p);
	memset(c, 0, sizeof(c));
	for (int i = 1; i <= n; i++)
		c[i * 2][i * 2 + 1] = 1;
	n = n * 2 + 1;
	while (p--)
	{
		int a, b;
		scanf("%d%d", &a, &b);
		c[a * 2 + 1][b * 2] = 1;
		c[b * 2 + 1][a * 2] = 1;
	}
	int ans = 0;
	while (bfs())
	{
		memset(work, 0, sizeof(work));
		while (true)
		{
			int flow = dfs(s, INT32_MAX);
			if (!flow)
				break;
			ans += flow;
		}
	}
	printf("%d", ans);
	return 0;
}
