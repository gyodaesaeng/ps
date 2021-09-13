#include <stdio.h>
int memo[41][2];

int dp(int n, int m)
{
	if (memo[n][m] > -1)
		return memo[n][m];
	return memo[n][m] = dp(n - 1, m) + dp(n - 2, m);
}

int main()
{
	int t;
	scanf("%d", &t);
	for (int i = 0; i < 41; i++)
		memo[i][0] = memo[i][1] = -1;
	memo[0][0] = memo[1][1] = 1;
	memo[0][1] = memo[1][0] = 0;
	while (t--)
	{
		int n;
		scanf("%d", &n);
		printf("%d %d\n", dp(n, 0), dp(n, 1));
	}
	return 0;
}
