#include <cstdio>
#include <algorithm>
#include <cstring>
using namespace std;
#define MIN -3276800
int n, m, memo[100][51], in[100], sum[101];

int dp(int a, int b)
{
	if (a < 0)
		return b ? MIN : 0;
	if (memo[a][b] > MIN)
		return memo[a][b];
	memo[a][b] = dp(a - 1, b);
	for (int i = a - 1; (i + 1) / 2 >= b - 1; i--)
		if (dp(i - 1, b - 1) > MIN)
			memo[a][b] = max(memo[a][b], dp(i - 1, b - 1) + sum[a] - sum[i]);
	return memo[a][b];
}

int main()
{
	scanf("%d %d", &n, &m);
	scanf("%d", &in[0]);
	sum[0] = in[0];
	for (int i = 1; i < n; i++)
	{
		scanf("%d", &in[i]);
		sum[i] = sum[i - 1] + in[i];
	}
	for (int i = 0; i < n; i++)
	{
		memo[i][0] = 0;
		for (int j = 1; j <= m; j++)
			memo[i][j] = MIN;
	}
	printf("%d", dp(n - 1, m));
	return 0;
}
