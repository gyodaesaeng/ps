#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
int n, m, k, a, b, c;
ll in[1000001], d;
pair<ll, ll> tree[3 * 1000001];

ll init(int node, int s, int e)
{
	if (s == e)
		return tree[node].first = in[s];
	return tree[node].first = init(node * 2, s, (s + e) / 2) + init(node * 2 + 1, (s + e) / 2 + 1, e);
}

void update(int node, int s, int e, int i, int j, ll diff)
{
	if (tree[node].second)
	{
		tree[node].first += (e - s + 1) * tree[node].second;
		if (s != e)
		{
			tree[node * 2].second += tree[node].second;
			tree[node * 2 + 1].second += tree[node].second;
		}
		tree[node].second = 0;
	}
	if (j < s || i > e)
		return;
	if (i <= s && e <= j)
	{
		tree[node].first += (e - s + 1) * diff;
		if (s != e)
		{
			tree[node * 2].second += diff;
			tree[node * 2 + 1].second += diff;
		}
		return;
	}
	update(node * 2, s, (s + e) / 2, i, j, diff);
	update(node * 2 + 1, (s + e) / 2 + 1, e, i, j, diff);

	tree[node].first = tree[node * 2].first + tree[node * 2 + 1].first;
}

ll sum(int node, int s, int e, int i, int j)
{
	if (tree[node].second)
	{
		tree[node].first += (e - s + 1) * tree[node].second;
		if (s != e)
		{
			tree[node * 2].second += tree[node].second;
			tree[node * 2 + 1].second += tree[node].second;
		}
		tree[node].second = 0;
	}
	if (i > e || j < s)
		return 0;
	if (i <= s && e <= j)
		return tree[node].first;
	return sum(node * 2, s, (s + e) / 2, i, j) + sum(node * 2 + 1, (s + e) / 2 + 1, e, i, j);
}

int main()
{
	scanf("%d%d%d", &n, &m, &k);
	for (int i = 1; i <= n; i++)
		scanf("%lld", &in[i]);
	init(1, 1, n);
	for (int i = 0; i < m + k; i++)
	{
		scanf("%d%d%d", &a, &b, &c);
		if (a == 1)
		{
			scanf("%lld", &d);
			update(1, 1, n, b, c, d);
		}
		else
			printf("%lld\n", sum(1, 1, n, b, c));
	}
	return 0;
}
