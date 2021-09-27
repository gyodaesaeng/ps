#include <bits/stdc++.h>
using namespace std;
int main()
{
	int n;
	int memo[30001];
	memset(memo, 0, sizeof(memo));
	memo[15000] = 1;
	scanf("%d", &n);
	for (int i = 0; i < n; i++)
	{
		int in;
		scanf("%d", &in);
		for (int j = 0; j < 30001; j++)
		{
			if (memo[j] && memo[j] < i + 2)
			{
				if (!memo[j + in])
					memo[j + in] = i + 2;
				if (!memo[j - in])
					memo[j - in] = i + 2;
			}
		}
	}
	scanf("%d", &n);
	for (int i = 0; i < n; i++)
	{
		int in;
		scanf("%d", &in);
		if (in > 15000)
		{
			printf("N ");
			continue;
		}
		if (memo[in + 15000])
			printf("Y ");
		else
			printf("N ");
	}
	return 0;
}
