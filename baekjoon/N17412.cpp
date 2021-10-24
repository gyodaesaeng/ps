#include <bits/stdc++.h>
using namespace std;

int n, c[401][401], f[401][401], work[401], level[401];

int bfs()
{
	memset(level, 0, sizeof(level));
	level[1] = 1;
	queue<int> q;
	q.push(1);
	while (!q.empty())
	{
		int peak = q.front();
		q.pop();
		for (int i = 1; i <= n; i++)
		{
			if (!level[i] && c[peak][i] - f[peak][i] > 0)
			{
				level[i] = level[peak] + 1;
				q.push(i);
			}
		}
	}
	return level[2];
}

int dfs(int node, int flow)
{
	if (node == 2)
		return flow;
	while (++work[node] <= n)
	{
		int next = work[node];
		if (level[next] == level[node] + 1 && c[node][next] - f[node][next] > 0)
		{
			int ret = dfs(next, min(c[node][next] - f[node][next], flow));
			if (ret > 0)
			{
				f[node][next] += ret;
				f[next][node] -= ret;
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
	while (p--)
	{
		int a, b;
		scanf("%d%d", &a, &b);
		c[a][b] = 1;
	}
	memset(f, 0, sizeof(f));
	int ans = 0;
	while (bfs())
	{
		memset(work, 0, sizeof(work));
		while (true)
		{
			int flow = dfs(1, INT32_MAX);
			if (!flow)
				break;
			ans += flow;
		}
	}
	printf("%d", ans);
	return 0;
}
