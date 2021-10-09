#include <bits/stdc++.h>
using namespace std;
char s[10001], t[10001], f[2];
int n, i, j, memo[3][10001];
int dp(int a, int b)
{
	if (memo[a][b])
		return memo[a][b];
	int ret = -1;
	if (s[b - a] == t[b])
		ret = dp(a, b + 1);
	if (a < 2 && f[a] == t[b])
		ret = max(ret, dp(a + 1, b + 1));
	return memo[a][b] = ret;
}
int main()
{
	scanf("%d%s%s%d%d", &n, s, t, &i, &j);
	f[0] = s[i];
	f[1] = s[j];
	for (int k = i; k < j; k++)
		s[k] = s[k + 1];
	for (int k = j; k < n; k++)
		s[k - 1] = s[k + 1];
	for (int i = 0; i < 3; i++)
		memset(memo[i], 0, sizeof(memo[i]));
	memo[0][n] = memo[1][n] = -1;
	memo[2][n] = 1;
	printf(dp(0, 0) > 0 ? "YES" : "NO");
	return 0;
}
