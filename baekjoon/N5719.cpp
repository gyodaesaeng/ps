#include <cstdio>
#include <vector>
#include <utility>
#include <queue>
#define INF 5000000
using namespace std;
int map[500][500];
int dis[500];
int m, n, s, d;
struct compare
{
	bool operator()(pair<int, int> &p1, pair<int, int> &p2)
	{
		return p1.second > p2.second;
	}
};

void dij()
{
	for (int i = 0; i < n; i++)
		dis[i] = INF;
	priority_queue<pair<int, int>, vector<pair<int, int> >, compare> pq;
	pq.push(make_pair(s, 0));
	while (!pq.empty())
	{
		pair<int, int> peak = pq.top();
		pq.pop();
		if (dis[peak.first] < peak.second)
			continue;
		dis[peak.first] = peak.second;
		for (int i = 0; i < n; i++)
		{
			if (dis[i] > peak.second + map[peak.first][i])
			{
				dis[i] = peak.second + map[peak.first][i];
				pq.push(make_pair(i, dis[i]));
			}
		}
	}
}
int main()
{
	while (1)
	{
		scanf("%d %d", &n, &m);
		if (!n && !m)
			break;
		scanf("%d %d", &s, &d);
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				map[i][j] = INF;
		for (int i = 0; i < m; i++)
		{
			int u, v, p;
			scanf("%d %d %d", &u, &v, &p);
			map[u][v] = p;
		}
		dij();
		queue<int> q;
		q.push(d);
		while (!q.empty())
		{
			for (int i = 0; i < n; i++)
			{
				if (dis[q.front()] == dis[i] + map[i][q.front()])
				{
					map[i][q.front()] = INF;
					if (i != s)
						q.push(i);
				}
			}
			q.pop();
		}
		dij();
		if (dis[d] < INF)
			printf("%d\n", dis[d]);
		else
			printf("-1\n");
	}
	return 0;
}
