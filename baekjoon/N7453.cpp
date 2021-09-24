#include <bits/stdc++.h>
using namespace std;
int n, in[4][4000];
int main()
{
	scanf("%d", &n);
	for (int i = 0; i < n; i++)
		for (int j = 0; j < 4; j++)
			scanf("%d", &in[j][i]);
	vector<int> v;
	for (int i = 0; i < n; i++)
		for (int j = 0; j < n; j++)
			v.push_back(in[0][i] + in[1][j]);
	sort(v.begin(), v.end());
	long long cnt = 0;
	for (int i = 0; i < n; i++)
		for (int j = 0; j < n; j++)
			cnt += upper_bound(v.begin(), v.end(), -in[2][i] - in[3][j]) - lower_bound(v.begin(), v.end(), -in[2][i] - in[3][j]);
	printf("%lld", cnt);
	return 0;
}
