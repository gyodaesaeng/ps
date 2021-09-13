#include <stdio.h>
#include <math.h>
int main()
{
	int t;
	scanf("%d", &t);
	while (t--)
	{
		int x1, x2, y1, y2, n;
		scanf("%d %d %d %d", &x1, &y1, &x2, &y2);
		scanf("%d", &n);
		int xc, yc, r;
		int cnt = 0;
		for (int i = 0; i < n; i++)
		{
			scanf("%d %d %d", &xc, &yc, &r);
			if ((pow(xc - x1, 2) + pow(yc - y1, 2) - r * r) * (pow(xc - x2, 2) + pow(yc - y2, 2) - r * r) < 0)
				cnt++;
		}
		printf("%d\n", cnt);
	}
	return 0;
}
