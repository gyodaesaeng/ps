#include <bits/stdc++.h>
using namespace std;
const int INF = 100000;
const int MAX_V = 20000;
struct Edge
{
	int e, c, ri;
};
int n, m, s, t, work[MAX_V], level[MAX_V];
vector<Edge> adj[MAX_V];

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
		for (Edge e : adj[peak])
		{
			if (!level[e.e] && e.c > 0)
			{
				level[e.e] = level[peak] + 1;
				q.push(e.e);
			}
		}
	}
	return level[t];
}

int dfs(int node, int flow)
{
	if (node == t)
		return flow;
	while (work[node] < adj[node].size())
	{
		Edge &e = adj[node][work[node]++];
		if (level[e.e] == level[node] + 1 && e.c > 0)
		{
			int ret = dfs(e.e, min(e.c, flow));
			if (ret)
			{
				e.c -= ret;
				adj[e.e][e.ri].c += ret;
				return ret;
			}
		}
	}
	return 0;
}

void addEdge(int start, int end, int c)
{
	Edge e1, e2;
	e1.e = end;
	e1.c = c;
	e1.ri = adj[end].size();
	e2.e = start;
	e2.c = 0;
	e2.ri = adj[start].size();
	adj[start].push_back(e1);
	adj[end].push_back(e2);
}

int main()
{
	scanf("%d%d", &n, &m);
	char map[100][100];
	for (int i = 0; i < n; i++)
		scanf("%s", map[i]);
	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < m; j++)
		{
			addEdge((i * m + j) * 2, (i * m + j) * 2 + 1, 1);
			addEdge((i * m + j) * 2 + 1, (i * m + j) * 2, 1);
			switch (map[i][j])
			{
			case 'K':
				s = (i * m + j) * 2 + 1;
			case '.':
				if (i)
					addEdge((i * m + j) * 2 + 1, ((i - 1) * m + j) * 2, INF);
				if (j)
					addEdge((i * m + j) * 2 + 1, (i * m + j - 1) * 2, INF);
				if (i < n - 1)
					addEdge((i * m + j) * 2 + 1, ((i + 1) * m + j) * 2, INF);
				if (j < m - 1)
					addEdge((i * m + j) * 2 + 1, (i * m + j + 1) * 2, INF);
				break;
			case 'H':
				t = (i * m + j) * 2;
				break;
			}
		}
	}
	int ans = 0;
	while (bfs())
	{
		memset(work, 0, sizeof(work));
		while (true)
		{
			int flow = dfs(s, INF);
			if (flow == INF)
			{
				printf("-1");
				return 0;
			}
			if (!flow)
				break;
			ans += flow;
		}
	}
	printf("%d", ans);
	return 0;
}
