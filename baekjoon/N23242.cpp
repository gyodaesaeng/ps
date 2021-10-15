#include <bits/stdc++.h>
using namespace std;
int B, n;
double in[4001], sum[2][4001], memo[31][4001];
double dp(int a, int b)
{
	if (memo[a][b] < INFINITY)
		return memo[a][b];
	if (a == 1)
		return memo[a][b] = (sum[1][n] - sum[1][b - 1]) - (sum[0][n] - sum[0][b - 1]) * (sum[0][n] - sum[0][b - 1]) / (n - b + 1);
	double ret = INFINITY;
	for (int i = b; i <= n - a + 1; i++)
		ret = min(ret, (sum[1][i] - sum[1][b - 1]) - (sum[0][i] - sum[0][b - 1]) * (sum[0][i] - sum[0][b - 1]) / (i - b + 1) + dp(a - 1, i + 1));
	return memo[a][b] = ret;
}
int main()
{
	scanf("%d%d", &B, &n);
	for (int i = 1; i <= n; i++)
		scanf("%lf", &in[i]);
	sum[0][0] = sum[1][0] = 0;
	for (int i = 1; i <= n; i++)
	{
		sum[0][i] = sum[0][i - 1] + in[i];
		sum[1][i] = sum[1][i - 1] + in[i] * in[i];
	}
	for (int i = 0; i < 31; i++)
		for (int j = 0; j < 4001; j++)
			memo[i][j] = INFINITY;
	double ans = INFINITY;
	for (int i = 1; i <= B; i++)
		ans = min(ans, dp(i, 1));
	printf("%lf", ans);
	return 0;
}
