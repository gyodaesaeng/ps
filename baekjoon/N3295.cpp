#include <bits/stdc++.h>
using namespace std;
const int MAX_N = 1001;
bool c[MAX_N];
int t, n, m, u, v, work[MAX_N];
vector<int> can[MAX_N];
int dfs(int a)
{
	for (int i : can[a])
	{
		if (c[i])
			continue;
		c[i] = true;
		if (work[i] && !dfs(work[i]))
			continue;
		work[i] = a;
		return 1;
	}
	return 0;
}
int main()
{
	scanf("%d", &t);
	while (t--)
	{
		scanf("%d%d", &n, &m);
		for (int i = 1; i <= n; i++)
			can[i].clear();
		for (int i = 0; i < m; i++)
		{
			scanf("%d%d", &u, &v);
			can[u + 1].push_back(v + 1);
		}
		memset(work, 0, sizeof(work));
		int ans = 0;
		for (int i = 1; i <= n; i++)
		{
			memset(c, false, sizeof(c));
			ans += dfs(i);
		}
		printf("%d\n", ans);
	}
	return 0;
}
