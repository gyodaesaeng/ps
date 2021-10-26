#include <bits/stdc++.h>
#define S 300
#define E 301
#define MAX_V 302
using namespace std;
typedef long long ll;
struct Point
{
	ll x, y;
	bool operator<(Point p)
	{
		if (x == p.x)
			return y < p.y;
		return x < p.x;
	}
	bool operator==(Point p)
	{
		return x == p.x && y == p.y;
	}
};
int n, k, h, m, c[MAX_V][MAX_V], work[MAX_V], level[MAX_V];
Point corner[1000], hole[50], mouse[250];

int ccw(Point p1, Point p2, Point p3)
{
	ll ret = (p2.x - p1.x) * (p3.y - p1.y) - (p2.y - p1.y) * (p3.x - p1.x);
	if (ret)
		return ret > 0 ? 1 : -1;
	return 0;
}

int isCross(Point p1, Point p2, Point p3, Point p4)
{
	int ccwRet[] = {ccw(p1, p2, p3),
					ccw(p1, p2, p4),
					ccw(p3, p4, p1),
					ccw(p3, p4, p2)};
	if (ccwRet[0] * ccwRet[1] > 0 || ccwRet[2] * ccwRet[3] > 0)
		return 0;
	if (!ccwRet[0] && !ccwRet[1] && !ccwRet[2] && !ccwRet[3])
	{
		if (p2 < p1)
			swap(p1, p2);
		if (p4 < p3)
			swap(p3, p4);
		if (p2 < p3 || p4 < p1 || p2 == p3 || p1 == p4)
			return 0;
		return 1;
	}
	if (ccwRet[2] * ccwRet[3] == 0)
		return 0;
	return 1;
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
		for (int i = 0; i < MAX_V; i++)
		{
			if (!level[i] && c[peak][i] > 0)
			{
				level[i] = level[peak] + 1;
				q.push(i);
			}
		}
	}
	return level[E];
}

int dfs(int node, int flow)
{
	if (node == E)
		return flow;
	while (work[node] < MAX_V)
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
		work[node]++;
	}
	return 0;
}

int main()
{
	scanf("%d%d%d%d", &n, &k, &h, &m);
	for (int i = 0; i < n; i++)
		scanf("%lld%lld", &corner[i].x, &corner[i].y);
	for (int i = 0; i < h; i++)
		scanf("%lld%lld", &hole[i].x, &hole[i].y);
	for (int i = 0; i < m; i++)
		scanf("%lld%lld", &mouse[i].x, &mouse[i].y);
	memset(c, 0, sizeof(c));
	for (int i = 0; i < m; i++)
	{
		c[S][i] = 1;
		for (int j = 0; j < h; j++)
		{
			int cross = 0;
			for (int l = 0; l < n; l++)
			{
				if (isCross(mouse[i], hole[j], corner[l], corner[(l + 1) % n]))
				{
					cross = 1;
					break;
				}
			}
			if (!cross)
				c[i][m + j] = 1;
		}
	}
	for (int i = 0; i < h; i++)
		c[m + i][E] = k;
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
	printf(ans == m ? "Possible" : "Impossible");
	return 0;
}
