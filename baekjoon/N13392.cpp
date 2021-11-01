#include <bits/stdc++.h>
using namespace std;
int n, now[10000], want[10000], memo[10000][10];
int dp(int a, int b)
{
	if (a == n)
		return 0;
	if (memo[a][b] >= 0)
		return memo[a][b];
	int gap = (20 + now[a] - b - want[a]) % 10;
	return memo[a][b] = min(gap + dp(a + 1, b), 10 - gap + dp(a + 1, (b + gap) % 10));
}
int main()
{
	scanf("%d", &n);
	for (int i = 0; i < n; i++)
		scanf("%1d", &now[i]);
	for (int i = 0; i < n; i++)
		scanf("%1d", &want[i]);
	for (int i = 0; i < n; i++)
		for (int j = 0; j < 10; j++)
			memo[i][j] = -1;
	printf("%d", dp(0, 0));
	return 0;
}
