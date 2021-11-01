#include <bits/stdc++.h>
using namespace std;
vector<pair<int, int> > route;
int main()
{
	int n, m;
	scanf("%d%d", &n, &m);
	while (n--)
	{
		int a, b;
		scanf("%d%d", &a, &b);
		if (a > b)
			route.push_back(make_pair(b, a));
	}
	sort(route.begin(), route.end());
	long long ans = m;
	int last = 0;
	for (pair<int, int> p : route)
	{
		last = max(last, p.first);
		if (last < p.second)
		{
			ans += 2 * (p.second - last);
			last = p.second;
		}
	}
	printf("%lld", ans);
	return 0;
}
