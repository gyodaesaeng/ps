#include <bits/stdc++.h>
using namespace std;
int n, m, s, e, d[10001];
vector<int> route[10001];
vector<pair<int, int> > g[10001];
struct compare
{
	bool operator()(pair<int, int> &p1, pair<int, int> &p2)
	{
		return p1.first > p2.first;
	}
};

int dfs(int v)
{
	if (v == s)
		return 0;
	int ret = 0;
	for (int i : route[v])
		ret += dfs(i) + 1;
	route[v].clear();
	return ret;
}

int main()
{
	scanf("%d%d", &n, &m);
	for (int i = 0; i < m; i++)
	{
		int a, b, c;
		scanf("%d%d%d", &a, &b, &c);
		g[a].push_back(make_pair(-c, b));
	}
	scanf("%d%d", &s, &e);
	memset(d, 0, sizeof(d));
	priority_queue<pair<int, int>, vector<pair<int, int> >, compare> pq;
	pq.push(make_pair(0, s));
	d[s] = 0;
	while (!pq.empty())
	{
		auto peak = pq.top();
		pq.pop();
		if (peak.first > d[peak.second])
			continue;
		for (auto i : g[peak.second])
		{
			if (peak.first + i.first == d[i.second])
				route[i.second].push_back(peak.second);
			else if (peak.first + i.first < d[i.second])
			{
				d[i.second] = peak.first + i.first;
				route[i.second].clear();
				route[i.second].push_back(peak.second);
				pq.push(make_pair(d[i.second], i.second));
			}
		}
	}
	printf("%d\n%d", -d[e], dfs(e));
	return 0;
}
