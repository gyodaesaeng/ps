#include <bits/stdc++.h>
using namespace std;
int n, m, in[1002][1002], road[1002][1002][4], cost[1002][1002];
struct info
{
	int x, y, cost;
	bool operator<(info const &i1) const
	{
		return this->cost > i1.cost;
	}
};
int main()
{
	scanf("%d%d", &m, &n);
	for (int i = 1; i <= m; i++)
		for (int j = 1; j <= n; j++)
			scanf("%d", &in[i][j]);
	for (int i = 0; i <= m; i++)
		in[i][0] = in[i][n + 1] = -1;
	for (int i = 0; i <= n; i++)
		in[0][i] = in[m + 1][i] = -1;
	for (int i = 1; i <= m; i++)
	{
		for (int j = 1; j <= n; j++)
		{
			road[i][j][0] = (in[i - 1][j] >= 0 && in[i][j] >= 0) ? in[i - 1][j] : -1;
			road[i][j][1] = (in[i][j - 1] >= 0 && in[i][j] >= 0) ? in[i][j - 1] : -1;
			road[i][j][2] = (in[i + 1][j] >= 0 && in[i][j] >= 0) ? in[i + 1][j] : -1;
			road[i][j][3] = (in[i][j + 1] >= 0 && in[i][j] >= 0) ? in[i][j + 1] : -1;
		}
	}
	for (int i = 1; i <= m; i++)
		for (int j = 1; j <= n; j++)
			cost[i][j] = INT32_MAX;
	priority_queue<info> pq;
	info s;
	s.x = s.y = 1;
	s.cost = in[1][1];
	pq.push(s);
	while (!pq.empty())
	{
		info peak = pq.top();
		pq.pop();
		if (cost[peak.x][peak.y] < peak.cost)
			continue;
		if (road[peak.x][peak.y][0] >= 0 && cost[peak.x - 1][peak.y] > peak.cost + road[peak.x][peak.y][0])
		{
			cost[peak.x - 1][peak.y] = peak.cost + road[peak.x][peak.y][0];
			info temp;
			temp.x = peak.x - 1;
			temp.y = peak.y;
			temp.cost = peak.cost + road[peak.x][peak.y][0];
			pq.push(temp);
		}
		if (road[peak.x][peak.y][1] >= 0 && cost[peak.x][peak.y - 1] > peak.cost + road[peak.x][peak.y][1])
		{
			cost[peak.x][peak.y - 1] = peak.cost + road[peak.x][peak.y][1];
			info temp;
			temp.x = peak.x;
			temp.y = peak.y - 1;
			temp.cost = peak.cost + road[peak.x][peak.y][1];
			pq.push(temp);
		}
		if (road[peak.x][peak.y][2] >= 0 && cost[peak.x + 1][peak.y] > peak.cost + road[peak.x][peak.y][2])
		{
			cost[peak.x + 1][peak.y] = peak.cost + road[peak.x][peak.y][2];
			info temp;
			temp.x = peak.x + 1;
			temp.y = peak.y;
			temp.cost = peak.cost + road[peak.x][peak.y][2];
			pq.push(temp);
		}
		if (road[peak.x][peak.y][3] >= 0 && cost[peak.x][peak.y + 1] > peak.cost + road[peak.x][peak.y][3])
		{
			cost[peak.x][peak.y + 1] = peak.cost + road[peak.x][peak.y][3];
			info temp;
			temp.x = peak.x;
			temp.y = peak.y + 1;
			temp.cost = peak.cost + road[peak.x][peak.y][3];
			pq.push(temp);
		}
	}
	printf("%d", cost[m][n] < INT32_MAX ? cost[m][n] : -1);
	return 0;
}
