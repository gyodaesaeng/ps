#include <stdio.h>
#include <cmath>
int solve(int a, int b)
{
	if (b == 1)
		return a % 10;
	int ret = solve(a, b / 2);
	ret *= ret;
	if (b % 2)
		ret *= a;
	return ret % 10;
}
int main()
{
	int t;
	scanf("%d", &t);
	while (t--)
	{
		int a, b;
		scanf("%d %d", &a, &b);
		int ans = solve(a, b);
		if (!ans)
			ans = 10;
		printf("%d\n", ans);
	}
}
