#include <stdio.h>
int en[10000][2];
int memo[10000][2][2][2][2];
int n, w;

int dp(int a, int b, int c, int d, int e)
{
	if (memo[a][b][c][d][e] != -1)
		return memo[a][b][c][d][e];
	if (a == n - 1)
	{
		memo[a][b][c][d][e] = 2;
		if (b + d > 0)
			memo[a][b][c][d][e]--;
		if (c + e > 0)
			memo[a][b][c][d][e]--;
		if (memo[a][b][c][d][e] == 2 && en[a][0] + en[a][1] <= w)
			memo[a][b][c][d][e] = 1;
		return memo[a][b][c][d][e];
	}
	memo[a][b][c][d][e] = 2 - b - c + dp(a + 1, 0, 0, d, e);
	if (b + c == 0 && en[a][0] + en[a][1] <= w)
		memo[a][b][c][d][e]--;
	if (en[a][0] + en[a + 1][0] <= w)
	{
		if (en[a][1] + en[a + 1][1] <= w)
			memo[a][b][c][d][e] = memo[a][b][c][d][e] < dp(a + 1, 1, 1, d, e) + 2 ? memo[a][b][c][d][e] : dp(a + 1, 1, 1, d, e) + 2;
		memo[a][b][c][d][e] = memo[a][b][c][d][e] < dp(a + 1, 1, 0, d, e) + 2 - c ? memo[a][b][c][d][e] : dp(a + 1, 1, 0, d, e) + 2 - c;
	}
	if (en[a][1] + en[a + 1][1] <= w)
		memo[a][b][c][d][e] = memo[a][b][c][d][e] < dp(a + 1, 0, 1, d, e) + 2 - b ? memo[a][b][c][d][e] : dp(a + 1, 0, 1, d, e) + 2 - b;
	return memo[a][b][c][d][e];
}

int main()
{
	int t;
	scanf("%d", &t);
	while (t--)
	{
		scanf("%d %d", &n, &w);
		for (int i = 0; i < n; i++)
			for (int j = 0; j < 16; j++)
				memo[i][j / 8][(j % 8) / 4][(j % 4) / 2][j % 2] = -1;
		for (int i = 0; i < 2; i++)
			for (int j = 0; j < n; j++)
				scanf("%d", &en[j][i]);
		int min = dp(0, 0, 0, 0, 0);
		if (en[0][0] + en[n - 1][0] <= w)
		{
			if (en[0][1] + en[n - 1][1] <= w)
				min = min < dp(0, 1, 1, 1, 1) + 2 ? min : dp(0, 1, 1, 1, 1) + 2;
			min = min < dp(0, 1, 0, 1, 0) + 1 ? min : dp(0, 1, 0, 1, 0) + 1;
		}
		if (en[0][1] + en[n - 1][1] <= w)
			min = min < dp(0, 0, 1, 0, 1) + 1 ? min : dp(0, 0, 1, 0, 1) + 1;
		printf("%d\n", min);
	}
}
