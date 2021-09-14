#include <stdio.h>
#include <cmath>
#include <cstdint>
int n;
int in[20][2];
long long bf(long long x, long long y, int m, int p)
{
	if (m == n - 1)
	{
		x += p ? in[m][0] : -in[m][0];
		y += p ? in[m][1] : -in[m][1];
		return (x * x + y * y);
	}
	long long ret = INT64_MAX;
	if (p)
		ret = bf(x + in[m][0], y + in[m][1], m + 1, p - 1);
	if (p < n - m)
	{
		long long temp = bf(x - in[m][0], y - in[m][1], m + 1, p);
		ret = ret < temp ? ret : temp;
	}
	return ret;
}
int main()
{
	int t;
	scanf("%d", &t);
	while (t--)
	{
		scanf("%d", &n);
		for (int i = 0; i < n; i++)
			scanf("%d %d", &in[i][0], &in[i][1]);
		printf("%.12lf\n", sqrt(bf(0, 0, 0, n / 2)));
	}
}
