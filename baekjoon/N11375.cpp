#include <bits/stdc++.h>
using namespace std;
const int MAX_N = 1001;
bool c[MAX_N];
int n, m, k, work[MAX_N];
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
	scanf("%d%d", &n, &m);
	for (int i = 1; i <= n; i++)
	{
		scanf("%d", &k);
		can[i].resize(k);
		for (int j = 0; j < k; j++)
			scanf("%d", &can[i][j]);
	}
	memset(work, 0, sizeof(work));
	int ans = 0;
	for (int i = 1; i <= n; i++)
	{
		memset(c, false, sizeof(c));
		ans += dfs(i);
	}
	printf("%d", ans);
	return 0;
}
