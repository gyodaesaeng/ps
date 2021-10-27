#include <bits/stdc++.h>
using namespace std;
int x, y, d, c;
double t, l;
int main()
{
	scanf("%d%d%d%lf", &x, &y, &d, &t);
	l = sqrt(x * x + y * y);
	c = ceil(l / d);
	printf("%.9lf", min(l, c * t + min(c > 1 ? 0 : t, min(c * d - l, l + d - c * d - t))));
	return 0;
}
