#include <stdio.h>
#include <cmath>
int main()
{
	int t;
	scanf("%d", &t);
	while (t--)
	{
		int x, y;
		scanf("%d %d", &x, &y);
		y -= x;
		int n, m;
		n = 0;
		m = 0;
		while (y > 0)
		{
			y -= ++n;
			m++;
			if (y > 0)
			{
				y -= n;
				m++;
			}
		}
		printf("%d\n", m);
	}
}
