#include <bits/stdc++.h>
using namespace std;
struct Edge
{
	int e, c, ri;
};
const int MAX_V = 2003;
const int S = 0;
const int E = 2001;
int work[MAX_V], level[MAX_V];
vector<Edge> network[MAX_V];

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
		for (Edge &e : network[peak])
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
	while (work[node] < network[node].size())
	{
		Edge &edge = network[node][work[node]];
		if (level[edge.e] == level[node] + 1 && edge.c > 0)
		{
			int ret = dfs(edge.e, min(edge.c, flow));
			if (ret > 0)
			{
				edge.c -= ret;
				network[edge.e][edge.ri].c += ret;
				return ret;
			}
		}
		work[node]++;
	}
	return 0;
}

void insertEdge(int s, int e, int c)
{
	Edge edge, reverse;
	edge.c = c;
	edge.e = e;
	edge.ri = network[e].size();
	reverse.c = 0;
	reverse.e = s;
	reverse.ri = network[s].size();
	network[s].push_back(edge);
	network[e].push_back(reverse);
}

int main()
{
	int n, m, k;
	scanf("%d%d%d", &n, &m, &k);
	insertEdge(S, 2002, k);
	for (int i = 1; i <= n; i++)
	{
		insertEdge(S, i, 1);
		insertEdge(2002, i, k);
		int t;
		scanf("%d", &t);
		while (t--)
		{
			int e;
			scanf("%d", &e);
			insertEdge(i, e + n, 1);
		}
	}
	for (int i = 1; i <= m; i++)
		insertEdge(i + n, E, 1);
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
