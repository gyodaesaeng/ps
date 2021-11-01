#include <bits/stdc++.h>
using namespace std;
double in[6], l, t1, t2;
double p(double a)
{
	return a * a;
}
int main()
{
	for (int i = 0; i < 6; i++)
		scanf("%lf", &in[i]);
	if (in[2] < in[5])
		for (int i = 0; i < 3; i++)
			swap(in[i], in[i + 3]);
	l = sqrt(p(in[3] - in[0]) + p(in[4] - in[1]));
	if (l <= in[2] - in[5])
		printf("%.3lf", M_PI * p(in[5]));
	else if (l > in[2] + in[5])
		printf("0.000");
	else
	{
		t1 = acos((p(in[2]) + p(l) - p(in[5])) / (2 * in[2] * l));
		t2 = acos((p(in[5]) + p(l) - p(in[2])) / (2 * in[5] * l));
		printf("%.3lf", p(in[2]) * t1 - p(in[2]) * sin(2 * t1) / 2 + p(in[5]) * t2 - p(in[5]) * sin(2 * t2) / 2);
	}
	return 0;
}
