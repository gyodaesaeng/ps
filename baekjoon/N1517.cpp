#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
int n, temp;
ll tree[500001];
pair<int, int> in[500001];
bool cmp(pair<int, int> p1, pair<int, int> p2)
{
	if (p1.first == p2.first)
		return p1.second > p2.second;
	return p1.first > p2.first;
}
ll get(int i)
{
	ll ret = 0;
	while (i > 0)
	{
		ret += tree[i];
		i -= i & -i;
	}
	return ret;
}
void update(int i, ll v)
{
	while (i <= n)
	{
		tree[i] += v;
		i += i & -i;
	}
}
int main()
{
	scanf("%d", &n);
	for (int i = 0; i < n; i++)
	{
		scanf("%d", &in[i].first);
		in[i].second = i + 1;
	}
	sort(in, in + n, cmp);
	ll ans = 0;
	for (int i = 0; i < n; i++)
	{
		ans += get(in[i].second - 1);
		update(in[i].second, 1);
	}
	printf("%lld", ans);
	return 0;
}
