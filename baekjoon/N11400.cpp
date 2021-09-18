#include <cstdio>
#include <vector>
#include <algorithm>
#include <utility>
using namespace std;
int v, e, cnt, order[100001];
vector<int> graph[100001];
vector<pair<int, int> > bridge;

int dfs(int vertex, int parent)
{
	order[vertex] = cnt++;
	int ret = order[vertex];

	for (int i = 0; i < (int)graph[vertex].size(); i++)
	{
		int next = graph[vertex][i];
		if (next == parent)
			continue;
		if (!order[next])
		{
			int low = dfs(next, vertex);
			if (low > order[vertex])
				bridge.push_back(make_pair(min(vertex, next), max(vertex, next)));
			ret = min(ret, low);
		}
		else
			ret = min(ret, order[next]);
	}
	return ret;
}

int main()
{
	scanf("%d %d", &v, &e);
	for (int i = 0; i < e; i++)
	{
		int a, b;
		scanf("%d %d", &a, &b);
		graph[a].push_back(b);
		graph[b].push_back(a);
	}
	cnt = 1;
	dfs(1, 0);
	sort(bridge.begin(), bridge.end());
	printf("%d\n", bridge.size());
	for (int i = 0; i < bridge.size(); i++)
		printf("%d %d\n", bridge[i].first, bridge[i].second);
	return 0;
}
