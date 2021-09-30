#include <bits/stdc++.h>
using namespace std;
int n, m, in[2], ans;
bool visited[501];
vector<int> graph[501];
bool dfs(int p, int v)
{
	if (visited[v])
		return false;
	visited[v] = true;
	for (int i : graph[v])
	{
		if (i == p)
			continue;
		if (!dfs(v, i))
			return false;
	}
	return true;
}
int main()
{
	int t = 1;
	while (true)
	{
		scanf("%d%d", &n, &m);
		if (!n && !m)
			return 0;
		for (int i = 1; i <= n; i++)
			graph[i].clear();
		for (int i = 0; i < m; i++)
		{
			scanf("%d%d", &in[0], &in[1]);
			graph[in[0]].push_back(in[1]);
			graph[in[1]].push_back(in[0]);
		}
		memset(visited, false, sizeof(visited));
		ans = 0;
		for (int i = 1; i <= n; i++)
			if (dfs(0, i))
				ans++;
		printf("Case %d: ", t++);
		if (ans < 1)
			printf("No trees.\n");
		else if (ans < 2)
			printf("There is one tree.\n");
		else
			printf("A forest of %d trees.\n", ans);
	}
	return 0;
}
