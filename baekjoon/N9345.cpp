#include <bits/stdc++.h>
using namespace std;
int tree[300000][2], table[100000];
void update(int node, int s, int e, int i, int v)
{
	if (i < s || i > e)
		return;
	if (s == e)
	{
		tree[node][0] = tree[node][1] = v;
		return;
	}
	int left = node * 2, right = node * 2 + 1;
	update(left, s, (s + e) / 2, i, v);
	update(right, (s + e) / 2 + 1, e, i, v);
	tree[node][0] = min(tree[left][0], tree[right][0]);
	tree[node][1] = max(tree[left][1], tree[right][1]);
}
pair<int, int> get(int node, int s, int e, int i, int j)
{
	if (j < s || i > e)
		return make_pair(100000, -1);
	if (i <= s && j >= e)
		return make_pair(tree[node][0], tree[node][1]);
	pair<int, int> left = get(node * 2, s, (s + e) / 2, i, j);
	pair<int, int> right = get(node * 2 + 1, (s + e) / 2 + 1, e, i, j);
	return make_pair(min(left.first, right.first), max(left.second, right.second));
}
int main()
{
	int t;
	scanf("%d", &t);
	while (t--)
	{
		int n, k;
		scanf("%d%d", &n, &k);
		for (int i = 0; i < n; i++)
		{
			table[i] = i;
			update(1, 0, n - 1, i, i);
		}
		while (k--)
		{
			int q, a, b;
			scanf("%d%d%d", &q, &a, &b);
			if (q)
			{
				pair<int, int> p = get(1, 0, n - 1, a, b);
				printf(p.first == a && p.second == b ? "YES\n" : "NO\n");
			}
			else
			{
				update(1, 0, n - 1, a, table[b]);
				update(1, 0, n - 1, b, table[a]);
				swap(table[a], table[b]);
			}
		}
	}
	return 0;
}
