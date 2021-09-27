#include <stdio.h>
int m, n;
bool in[11][10];
int memo[11][10][1 << 12];

int dp(int x, int y, int bm)
{
	if (x > m)
	{
		if (y == n - 1)
			return 0;
		return dp(1, y + 1, bm);
	}
	if (memo[x][y][bm] > -1)
		return memo[x][y][bm];
	int max = dp(x + 1, y, bm & ~(1 << x));
	if (!(bm & (1 << x)) && in[x][y])
		max = max > dp(x + 1, y, bm | 1 << (x - 1) | 1 << (x + 1)) + 1 ? max : dp(x + 1, y, bm | 1 << (x - 1) | 1 << (x + 1)) + 1;
	return memo[x][y][bm] = max;
}

int main()
{
	int c;
	char s[10];
	scanf("%d", &c);
	while (c--)
	{
		scanf("%d %d", &n, &m);
		for (int i = 0; i < n; i++)
		{
			scanf("%s", s);
			for (int j = 1; j <= m; j++)
			{
				in[j][i] = s[j - 1] == '.';
				for (int k = 0; k < (1 << 12); k++)
					memo[j][i][k] = -1;
			}
		}
		printf("%d\n", dp(1, 0, 0));
	}
	return 0;
}
