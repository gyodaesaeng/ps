#include <bits/stdc++.h>
using namespace std;
char in[2501];
int memo[2501];
bitset<2501> isP[2501];

int dp(int a)
{
	if (!in[a])
		return 0;
	if (memo[a])
		return memo[a];
	memo[a] = 2501;
	for (int i = a; in[i]; i++)
		if (isP[a][i])
			memo[a] = min(memo[a], dp(i + 1) + 1);
	return memo[a];
}

int main()
{
	scanf("%s", in);
	int n = strlen(in);
	for (int i = 0; i < n; i++)
		for (int j = i; j >= 0; j--)
			if (in[i] == in[j] && (i - j < 2 || isP[j + 1][i - 1]))
				isP[j][i] = true;
	memset(memo, 0, sizeof(memo));
	printf("%d", dp(0));
	return 0;
}
