#include <bits/stdc++.h>
using namespace std;
const int MAX_V = 2003, S = 2001, E = 2002, M = 0;
struct Edge
{
	int e, c, ri;
};
int n, m, k, l, in, work[MAX_V], level[MAX_V];
vector<Edge> adj[MAX_V];

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
		for (Edge e : adj[peak])
		{
			if (!level[e.e] && e.c > 0)
			{
				level[e.e] = level[peak] + 1;
				q.push(e.e);
			}
		}
	}
	return level[E];
}

int dfs(int node, int flow)
{
	if (node == E)
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
	scanf("%d%d%d", &n, &m, &k);
	addEdge(S, M, k);
	for (int i = 1; i <= n; i++)
	{
		addEdge(S, i, 1);
		addEdge(M, i, 1);
		scanf("%d", &l);
		for (int j = 0; j < l; j++)
		{
			scanf("%d", &in);
			addEdge(i, n + in, 1);
		}
	}
	for (int i = 1; i <= m; i++)
		addEdge(n + i, E, 1);
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
	printf("%d", ans);
	return 0;
}
