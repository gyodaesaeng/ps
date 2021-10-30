#include <bits/stdc++.h>
using namespace std;
const int MAX_V = 802;
const int S = 0;
const int T = 801;

int c[MAX_V][MAX_V], d[MAX_V][MAX_V];
vector<int> adj[MAX_V];

int main()
{
	int n, m;
	scanf("%d %d", &n, &m);
	for (int i = 1; i <= n; i++)
	{
		c[S][i] = 1;
		adj[S].push_back(i);
		adj[i].push_back(S);
	}
	for (int i = 1; i <= m; i++)
	{
		c[i + n][T] = 1;
		adj[i + n].push_back(T);
		adj[T].push_back(i + n);
	}
	for (int i = 1; i <= n; i++)
	{
		int k;
		scanf("%d", &k);
		while (k--)
		{
			int a, b;
			scanf("%d %d", &a, &b);
			adj[i].push_back(a + n);
			adj[a + n].push_back(i);
			d[i][a + n] = b;
			d[a + n][i] = -b;
			c[i][a + n] = 1;
		}
	}
	int result = 0;
	int cnt = 0;
	while (true)
	{
		int prev[MAX_V], dist[MAX_V];
		bool inQ[MAX_V] = {0};
		queue<int> q;
		fill(prev, prev + MAX_V, -1);
		fill(dist, dist + MAX_V, INT32_MAX / 2);
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
					prev[i] = here;
					if (!inQ[i])
					{
						q.push(i);
						inQ[i] = true;
					}
				}
			}
		}
		if (prev[T] == -1)
			break;
		int flow = INT32_MAX;
		for (int i = T; i != S; i = prev[i])
			flow = min(flow, c[prev[i]][i]);
		for (int i = T; i != S; i = prev[i])
		{
			result += flow * d[prev[i]][i];
			c[prev[i]][i] -= flow;
			c[i][prev[i]] += flow;
		}
		cnt++;
	}
	printf("%d\n%d", cnt, result);
	return 0;
}
