#include <bits/stdc++.h>
using namespace std;
struct Edge
{
	int e, c, f, ri;
};
const int S = 5100, T = 5101, MAX_V = 5102, INF = 100000;
int n, in, level[MAX_V], work[MAX_V];
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
	scanf("%d", &n);
	for (int i = 0; i < n * n; i++)
		insertEdge(i * 2, i * 2 + 1, 0);
	int sum = 0;
	for (int i = 0; i < n; i++)
	{
		scanf("%d", &in);
		sum += in;
		int temp = 2 * n * n + i;
		insertEdge(S, temp, in);
		for (int j = 0; j < n; j++)
			insertEdge(temp, (i * n + j) * 2, in);
	}
	for (int i = 0; i < n; i++)
	{
		scanf("%d", &in);
		int temp = 2 * n * n + n + i;
		insertEdge(temp, T, in);
		for (int j = 0; j < n; j++)
			insertEdge((j * n + i) * 2 + 1, temp, in);
	}
	int s = 0, e = 10000, c;
	while (s < e)
	{
		c = (s + e) / 2;
		for (int i = 0; i < n * n; i++)
			adj[i * 2][0].c = c;
		for (int i = 0; i < MAX_V; i++)
			for (int j = 0; j < adj[i].size(); j++)
				adj[i][j].f = 0;
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
		if (ans == sum)
			e = c;
		else
			s = c + 1;
	}
	printf("%d\n", s);
	for (int i = 0; i < n * n; i++)
		adj[i * 2][0].c = s;
	for (int i = 0; i < MAX_V; i++)
		for (int j = 0; j < adj[i].size(); j++)
			adj[i][j].f = 0;
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
	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < n; j++)
			printf("%d ", adj[(i * n + j) * 2][0].f);
		printf("\n");
	}
	return 0;
}
