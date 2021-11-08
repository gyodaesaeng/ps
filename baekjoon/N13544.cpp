#include <bits/stdc++.h>
using namespace std;
const int MAX_N = 100001;
int n, m, in[3], a[MAX_N];
vector<int> tree[3 * MAX_N];
void init(int node, int s, int e)
{
	if (s == e)
	{
		tree[node].push_back(a[s]);
		return;
	}
	int mid = (s + e) / 2;
	init(node * 2, s, mid);
	init(node * 2 + 1, mid + 1, e);
	tree[node].resize(tree[node * 2].size() + tree[node * 2 + 1].size());
	merge(tree[node * 2].begin(), tree[node * 2].end(), tree[node * 2 + 1].begin(), tree[node * 2 + 1].end(), tree[node].begin());
}
int query(int node, int s, int e, int l, int r, int k)
{
	if (r < s || e < l)
		return 0;
	if (l <= s && e <= r)
		return tree[node].end() - upper_bound(tree[node].begin(), tree[node].end(), k);
	int mid = (s + e) / 2;
	return query(node * 2, s, mid, l, r, k) + query(node * 2 + 1, mid + 1, e, l, r, k);
}
int main()
{
	scanf("%d", &n);
	for (int i = 1; i <= n; i++)
		scanf("%d", &a[i]);
	init(1, 1, n);
	scanf("%d", &m);
	int ans = 0;
	for (int i = 0; i < m; i++)
	{
		for (int j = 0; j < 3; j++)
		{
			scanf("%d", &in[j]);
			in[j] ^= ans;
		}
		ans = query(1, 1, n, in[0], in[1], in[2]);
		printf("%d\n", ans);
	}
	return 0;
}
