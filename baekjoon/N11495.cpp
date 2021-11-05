#include <bits/stdc++.h>
using namespace std;
const int INF = 10000, MAX_V = 2502, S = 2500, T = 2501;
struct Edge
{
	int e, c, f, ri;
};
int t, n, m, in, level[MAX_V], work[MAX_V];
vector<Edge> adj[MAX_V];
void insertEdge(int s, int e, int c)
{
	Edge e1, e2;
	e1.e = e;
	e1.c = c;
	e1.f = 0;
	e1.ri = adj[e].size();
	e2.e = s;
	e2.c = 0;
	e2.f = 0;
	e2.ri = adj[s].size();
	adj[s].push_back(e1);
	adj[e].push_back(e2);
}
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
			if (!level[e.e] && e.c - e.f > 0)
			{
				level[e.e] = level[peak] + 1;
				q.push(e.e);
			}
		}
	}
	return level[T];
}

int dfs(int node, int flow)
{
	if (node == T)
		return flow;
	while (work[node] < adj[node].size())
	{
		Edge &e = adj[node][work[node]++];
		if (level[e.e] == level[node] + 1 && e.c - e.f > 0)
		{
			int ret = dfs(e.e, min(e.c - e.f, flow));
			if (ret)
			{
				e.f += ret;
				adj[e.e][e.ri].f -= ret;
				return ret;
			}
		}
	}
	return 0;
}

int main()
{
	scanf("%d", &t);
	while (t--)
	{
		for (int i = 0; i < MAX_V; i++)
			adj[i].clear();
		scanf("%d%d", &n, &m);
		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j < m; j++)
			{
				scanf("%d", &in);
				if ((i + j) % 2)
				{
					insertEdge(S, i * m + j, in);
					if (i)
						insertEdge(i * m + j, (i - 1) * m + j, INF);
					if (j)
						insertEdge(i * m + j, i * m + j - 1, INF);
					if (i < n - 1)
						insertEdge(i * m + j, (i + 1) * m + j, INF);
					if (j < m - 1)
						insertEdge(i * m + j, i * m + j + 1, INF);
				}
				else
					insertEdge(i * m + j, T, in);
			}
		}
		int ans = 0;
		while (bfs())
		{
			memset(work, 0, sizeof(work));
			while (true)
			{
				int flow = dfs(S, INF);
				if (!flow)
					break;
				ans += flow;
			}
		}
		for (Edge e : adj[S])
			if (e.c > 0 && e.c > e.f)
				ans += e.c - e.f;
		for (Edge e : adj[T])
		{
			Edge &re = adj[e.e][e.ri];
			if (re.c > 0 && re.c > re.f)
				ans += re.c - re.f;
		}
		printf("%d\n", ans);
	}
	return 0;
}
