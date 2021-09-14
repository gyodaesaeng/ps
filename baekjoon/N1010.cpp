#include <stdio.h>
long long memo[30][30];
long long dp(int n, int m)
{
	if (memo[n][m] > -1)
		return memo[n][m];
	return memo[n][m] = dp(n - 1, m) + dp(n - 1, m - 1);
}

int main()
{
	int t;
	scanf("%d", &t);
	for (int i = 1; i < 30; i++)
	{
		memo[i][0] = 1;
		memo[i][1] = i;
		for (int j = 2; j < 30; j++)
			memo[i][j] = -1;
	}
	while (t--)
	{
		int n, m;
		scanf("%d %d", &n, &m);
		printf("%lld\n", dp(m, n));
	}
}
