#include <stdio.h>
long long memo[10][2];
long long pow(int a, int b)
{
	if (b < 1)
		return 1;
	long long half = pow(a, b / 2);
	return half * half * (b % 2 ? a : 1);
}
int main()
{
	int n;
	scanf("%d", &n);
	memo[0][0] = memo[0][1] = 0;
	for (int i = 1; i < 10; i++)
	{
		memo[i][0] = memo[i - 1][0] * 10 + pow(10, i - 1) - 1;
		memo[i][1] = memo[i - 1][1] * 10 + pow(10, i - 1);
	}
	for (int i = 0; i < 10; i++)
	{
		long long cnt = 0;
		int j;
		for (j = 0; n >= pow(10, j); j++)
		{
			int k = (n / pow(10, j)) % 10;
			if (!i && n < pow(10, j + 1))
			{
				cnt += memo[j][0] + (k - 1) * memo[j][1];
				break;
			}
			cnt += k * memo[j][1];
			if (i < k)
				cnt += pow(10, j);
			if (i == k)
				cnt += n % pow(10, j) + 1;
		}
		printf("%lld ", cnt);
	}
	return 0;
}
