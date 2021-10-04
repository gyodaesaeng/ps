#include <bits/stdc++.h>
using namespace std;
int n, d[20][20], memo[20][1 << 21];
int dp(int a, int b)
{
	if (a == n)
		return 0;
	if (memo[a][b])
		return memo[a][b];
	int ret = INT32_MAX;
	for (int i = 0; i < n; i++)
		if (!(b & 1 << i))
			ret = min(ret, d[a][i] + dp(a + 1, b | 1 << i));
	return memo[a][b] = ret;
}
int main()
{
	scanf("%d", &n);
	for (int i = 0; i < n; i++)
		for (int j = 0; j < n; j++)
			scanf("%d", &d[i][j]);
	for (int i = 0; i < n; i++)
		memset(memo[i], 0, sizeof(memo[i]));
	printf("%d", dp(0, 0));
	return 0;
}
