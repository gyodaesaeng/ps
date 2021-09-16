#include <stdio.h>
int map[50][50];
long long ans[50][50];
int n, s, e, t;
void pow(int m)
{
	if (m < 2)
		return;
	pow(m / 2);
	long long temp[50][50];
	for (int i = 0; i < 5 * n; i++)
	{
		for (int j = 0; j < 5 * n; j++)
		{
			temp[i][j] = 0;
			for (int k = 0; k < 5 * n; k++)
			{
				temp[i][j] += ans[i][k] * ans[k][j];
				temp[i][j] %= 1000003;
			}
		}
	}
	if (m % 2)
	{
		for (int i = 0; i < 5 * n; i++)
		{
			for (int j = 0; j < 5 * n; j++)
			{
				ans[i][j] = 0;
				for (int k = 0; k < 5 * n; k++)
				{
					ans[i][j] += temp[i][k] * map[k][j];
					ans[i][j] %= 1000003;
				}
			}
		}
	}
	else
	{
		for (int i = 0; i < 5 * n; i++)
			for (int j = 0; j < 5 * n; j++)
				ans[i][j] = temp[i][j];
	}
}
int main()
{
	scanf("%d %d %d %d", &n, &s, &e, &t);
	for (int i = 0; i < 5 * n; i++)
		for (int j = 0; j < 5 * n; j++)
			map[i][j] = ans[i][j] = 0;
	for (int i = 0; i < n; i++)
	{
		char s[10];
		scanf("%s", s);
		for (int j = 0; j < 4; j++)
			map[i * 5 + j][i * 5 + j + 1] = ans[i * 5 + j][i * 5 + j + 1] = 1;
		for (int j = 0; j < n; j++)
		{
			if (s[j] > '0')
				map[i * 5 + s[j] - '1'][j * 5] = ans[i * 5 + s[j] - '1'][j * 5] = 1;
		}
	}
	pow(t);
	printf("%lld", ans[(s - 1) * 5][(e - 1) * 5]);
	return 0;
}
