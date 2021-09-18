#include <cstdio>
#include <vector>
#include <algorithm>
#include <string>
using namespace std;
int v, e, cnt, order[10001];
bool isCut[10001];
vector<int> graph[10001];
int dfs(int vertex)
{
	order[vertex] = ++cnt;
	int ret = order[vertex];
	for (int i = 0; i < graph[vertex].size(); i++)
	{
		int next = graph[vertex][i];
		if (!order[next])
		{
			int low = dfs(next);
			if (low >= order[vertex])
				isCut[vertex] = true;
			ret = min(ret, low);
		}
		else
			ret = min(ret, order[next]);
	}
	return ret;
}
int main()
{
	scanf("%d%d", &v, &e);
	for (int i = 0; i < e; i++)
	{
		int a, b;
		scanf("%d%d", &a, &b);
		graph[a].push_back(b);
		graph[b].push_back(a);
	}
	for (int i = 1; i <= v; i++)
	{
		order[i] = 0;
		isCut[i] = false;
	}
	cnt = 1;
	for (int i = 1; i <= v; i++)
	{
		if (!order[i])
		{
			order[i] = cnt++;
			int child = 0;
			for (int j = 0; j < graph[i].size(); j++)
			{
				if (!order[graph[i][j]])
				{
					child++;
					dfs(graph[i][j]);
				}
			}
			if (child > 1)
				isCut[i] = true;
		}
	}
	cnt = 0;
	for (int i = 1; i <= v; i++)
		if (isCut[i])
			cnt++;
	printf("%d\n", cnt);
	for (int i = 1; i <= v; i++)
		if (isCut[i])
			printf("%d ", i);
	return 0;
}
