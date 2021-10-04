#include <bits/stdc++.h>
using namespace std;
int m, n, w, h, wi[2000], d[2000], s[2000];
vector<int> p[2000];
int main()
{
	scanf("%d%d%d%d", &m, &n, &w, &h);
	int sum = 0;
	for (int i = 0; i < m; i++)
	{
		scanf("%d", &wi[i]);
		sum += wi[i];
	}
	for (int i = 0; i < n; i++)
	{
		scanf("%d", &d[i]);
		sum -= d[i];
	}
	if (sum != 0)
	{
		printf("-1");
		return 0;
	}
	priority_queue<pair<int, int> > pq;
	queue<int> q;
	for (int i = 0; i < m; i++)
		pq.push(make_pair(wi[i], i));
	memset(s, 0, sizeof(s));
	for (int i = 0; i < n; i++)
	{
		for (int j = 1; j < w && i + j < n; j++)
			d[i + j] -= d[i];
		while (!q.empty() && s[q.front()] == i)
		{
			pq.push(make_pair(wi[q.front()], q.front()));
			q.pop();
		}
		while (d[i]--)
		{
			if (pq.empty())
			{
				printf("-1");
				return 0;
			}
			int now = pq.top().second;
			pq.pop();
			p[now].push_back(i + 1);
			s[now] = i + w + h;
			wi[now] -= w;
			if (wi[now])
				q.push(now);
		}
	}
	printf("1\n");
	for (int i = 0; i < m; i++)
	{
		for (int j : p[i])
			printf("%d ", j);
		printf("\n");
	}
	return 0;
}
