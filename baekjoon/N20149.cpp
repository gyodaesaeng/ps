#include <bits/stdc++.h>
using namespace std;
pair<double, double> in[5];
double ccw(int a, int b, int c)
{
	double cross = (in[b].first - in[a].first) * (in[c].second - in[a].second) - (in[b].second - in[a].second) * (in[c].first - in[a].first);
	if (cross > 0)
		return 1;
	if (cross < 0)
		return -1;
	return 0;
}
int main()
{
	for (int i = 0; i < 4; i++)
		scanf("%lf%lf", &in[i].first, &in[i].second);
	if (in[0] > in[1])
		swap(in[0], in[1]);
	if (in[2] > in[3])
		swap(in[2], in[3]);
	if (!ccw(0, 1, 2) && !ccw(0, 1, 3))
	{
		if (in[1] < in[2] || in[3] < in[0])
		{
			printf("0");
			return 0;
		}
		printf("1\n");
		if (in[1] == in[2])
			printf("%lf %lf", in[1].first, in[1].second);
		else if (in[0] == in[3])
			printf("%lf %lf", in[0].first, in[0].second);
		return 0;
	}
	if (ccw(0, 1, 2) * ccw(0, 1, 3) > 0 || ccw(2, 3, 0) * ccw(2, 3, 1) > 0)
	{
		printf("0");
		return 0;
	}
	while (in[3].first - in[2].first > 0.000000001 || in[3].second - in[2].second > 0.000000001)
	{
		in[4].first = (in[2].first + in[3].first) / 2;
		in[4].second = (in[2].second + in[3].second) / 2;
		if (ccw(0, 1, 2) * ccw(0, 1, 4) <= 0)
			in[3] = in[4];
		else
			in[2] = in[4];
	}
	printf("1\n%.16lf %.16lf", in[2].first, in[2].second);
	return 0;
}
