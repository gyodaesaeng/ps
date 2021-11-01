#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
int n, in[200000][2], bit[200001];
vector<int> star[200000], co[2];

ll get(int i)
{
	ll ret = 0;
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
	scanf("%d", &n);
	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < 2; j++)
		{
			scanf("%d", &in[i][j]);
			co[j].push_back(in[i][j]);
		}
	}
	for (int i = 0; i < 2; i++)
	{
		sort(co[i].begin(), co[i].end());
		co[i].erase(unique(co[i].begin(), co[i].end()), co[i].end());
		for (int j = 0; j < n; j++)
			in[j][i] = lower_bound(co[i].begin(), co[i].end(), in[j][i]) - co[i].begin();
	}
	for (int i = 0; i < n; i++)
		star[in[i][1]].push_back(in[i][0] + 1);
	fill(bit, bit + n, 0);
	ll ans = 0;
	for (int i = n - 1; i >= 0; i--)
	{
		for (int j : star[i])
		{
			ans += get(j - 1) * (get(n) - get(j));
			ans %= 1000000007;
		}
		for (int j : star[i])
			update(j);
	}
	printf("%lld", ans);
	return 0;
}
