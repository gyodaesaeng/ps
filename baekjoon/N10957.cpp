#include <bits/stdc++.h>
using namespace std;
int n, m, u, v, uni[2][100001], cnt, order[100001];
vector<int> graph[100001];
int uf(int a, int b)
{
	if (uni[a][b] == b)
		return b;
	return uni[a][b] = uf(a, uni[a][b]);
}
int dfs(int vertex, int parent)
{
	order[vertex] = cnt++;
	int ret = order[vertex];
	bool isp = false;
	for (int i = 0; i < (int)graph[vertex].size(); i++)
	{
		int next = graph[vertex][i];
		if (next == parent)
		{
			if (isp)
				ret = min(ret, order[parent]);
			else
				isp = true;
		}
		else if (!order[next])
		{
			int low = dfs(next, vertex);
			if (low > order[vertex])
				printf("%d %d\n", vertex, next);
			ret = min(ret, low);
		}
		else
			ret = min(ret, order[next]);
	}
	return ret;
}

int main()
{
	scanf("%d%d", &n, &m);
	for (int i = 1; i <= n; i++)
		uni[0][i] = uni[1][i] = i;
	for (int i = 0; i < m; i++)
	{
		scanf("%d%d", &u, &v);
		if (uf(0, u) == uf(0, v))
		{
			if (uf(1, u) == uf(1, v))
				continue;
			uni[1][uf(1, u)] = uf(1, v);
		}
		else
			uni[0][uf(0, u)] = uf(0, v);
		graph[u].push_back(v);
		graph[v].push_back(u);
	}
	cnt = 1;
	memset(order, 0, sizeof(order));
	for (int i = 1; i <= n; i++)
	{
		if (!order[i])
			dfs(i, 0);
	}
	return 0;
}
