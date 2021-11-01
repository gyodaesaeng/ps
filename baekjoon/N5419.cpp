#include <bits/stdc++.h>
using namespace std;
struct P
{
	int x, y;
};
int n, bit[75000];

bool cmp(P a, P b)
{
	if (a.y == b.y)
		return a.x > b.x;
	return a.y < b.y;
}

int get(int i)
{
	int ret = 0;
	while (i > 0)
	{
		ret += bit[i];
		i -= i & -i;
	}
	return ret;
}
void update(int i)
{
	while (i <= n)
	{
		bit[i]++;
		i += i & -i;
	}
}

int main()
{
	int t;
	scanf("%d", &t);
	while (t--)
	{
		scanf("%d", &n);
		P p[75001];
		vector<int> co;
		for (int i = 0; i < n; i++)
		{
			scanf("%d%d", &p[i].x, &p[i].y);
			co.push_back(p[i].x);
		}
		sort(co.begin(), co.end());
		co.erase(unique(co.begin(), co.end()), co.end());
		for (int i = 0; i < n; i++)
			p[i].x = lower_bound(co.begin(), co.end(), p[i].x) - co.begin();
		sort(p, p + n, cmp);
		fill(bit, bit + n, 0);
		update(p[0].x + 1);
		long long ans = 0;
		for (int i = 1; i < n; i++)
		{
			ans += i - get(p[i].x);
			update(p[i].x + 1);
		}
		printf("%lld\n", ans);
	}
	return 0;
}
