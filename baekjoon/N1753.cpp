#include <stdio.h>
#include <vector>
#include <queue>
#define INF 200000
using namespace std;
struct compare
{
	bool operator()(pair<int, int> &p1, pair<int, int> &p2)
	{
		return p1.second > p2.second;
	}
};
int main()
{
	int v, e, k;
	scanf("%d %d %d", &v, &e, &k);
	vector<pair<int, int> > graph[20001];
	for (int i = 0; i < e; i++)
	{
		int a, b, c;
		scanf("%d %d %d", &a, &b, &c);
		graph[a].push_back(make_pair(b, c));
	}
	int d[20001];
	for (int i = 1; i <= v; i++)
		d[i] = INF;
	priority_queue<pair<int, int>, vector<pair<int, int> >, compare> pq;
	pq.push(make_pair(k, 0));
	while (!pq.empty())
	{
		pair<int, int> peak = pq.top();
		pq.pop();
		if (d[peak.first] < peak.second)
			continue;
		d[peak.first] = peak.second;
		for (int i = 0; i < graph[peak.first].size(); i++)
		{
			if (d[graph[peak.first][i].first] > peak.second + graph[peak.first][i].second)
			{
				d[graph[peak.first][i].first] = d[peak.first] + graph[peak.first][i].second;
				pq.push(make_pair(graph[peak.first][i].first, d[graph[peak.first][i].first]));
			}
		}
	}
	for (int i = 1; i <= v; i++)
	{
		if (d[i] < INF)
			printf("%d\n", d[i]);
		else
			printf("INF\n");
	}
	return 0;
}
