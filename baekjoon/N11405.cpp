#include <bits/stdc++.h>
using namespace std;
const int MAX_V = 202, S = 0, T = 201, INF = 100000;

int c[MAX_V][MAX_V], d[MAX_V][MAX_V], pre[MAX_V], dist[MAX_V];
vector<int> adj[MAX_V];

int main()
{
	int n, m;
	scanf("%d %d", &n, &m);
	memset(c, 0, sizeof(c));
	for (int i = 1; i <= n; i++)
	{
		scanf("%d", &c[i][T]);
		adj[i].push_back(T);
		adj[T].push_back(i);
		d[i][T] = d[T][i] = 0;
	}
	for (int i = 1; i <= m; i++)
	{
		scanf("%d", &c[S][n + i]);
		adj[S].push_back(n + i);
		adj[n + i].push_back(S);
		d[S][n + i] = d[n + i][S] = 0;
	}
	for (int i = 1; i <= m; i++)
	{
		for (int j = 1; j <= n; j++)
		{
			scanf("%d", &d[n + i][j]);
			d[j][n + i] = -d[n + i][j];
			c[n + i][j] = INF;
			adj[j].push_back(n + i);
			adj[n + i].push_back(j);
		}
	}
	int result = 0;
	while (true)
	{
		bool inQ[MAX_V];
		queue<int> q;
		memset(inQ, false, sizeof(inQ));
		fill(pre, pre + MAX_V, -1);
		fill(dist, dist + MAX_V, INF);
		dist[S] = 0;
		inQ[S] = true;
		q.push(S);
		while (!q.empty())
		{
			int here = q.front();
			q.pop();
			inQ[here] = false;
			for (int i : adj[here])
			{
				if (c[here][i] > 0 && dist[i] > dist[here] + d[here][i])
				{
					dist[i] = dist[here] + d[here][i];
					pre[i] = here;
					if (!inQ[i])
					{
						q.push(i);
						inQ[i] = true;
					}
				}
			}
		}
		if (pre[T] == -1)
			break;
		int flow = INF;
		for (int i = T; i != S; i = pre[i])
			flow = min(flow, c[pre[i]][i]);
		for (int i = T; i != S; i = pre[i])
		{
			result += flow * d[pre[i]][i];
			c[pre[i]][i] -= flow;
			c[i][pre[i]] += flow;
		}
	}
	printf("%d", result);
	return 0;
}
