#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
const int MAX_N = 100001;

int n, m, a, b, s[MAX_N], e[MAX_N];
ll tree[2][MAX_N * 3];
vector<int> child[MAX_N];

void dfs(int node)
{
	s[node] = ++a;
	for (int i : child[node])
		dfs(i);
	e[node] = a;
}

void update(int node, int s, int e, int i, int j, ll diff)
{
	if (tree[1][node])
	{
		tree[0][node] += (e - s + 1) * tree[1][node];
		if (s != e)
		{
			tree[1][node * 2] += tree[1][node];
			tree[1][node * 2 + 1] += tree[1][node];
		}
		tree[1][node] = 0;
	}
	if (j < s || i > e)
		return;
	if (i <= s && e <= j)
	{
		tree[0][node] += (e - s + 1) * diff;
		if (s != e)
		{
			tree[1][node * 2] += diff;
			tree[1][node * 2 + 1] += diff;
		}
		return;
	}
	update(node * 2, s, (s + e) / 2, i, j, diff);
	update(node * 2 + 1, (s + e) / 2 + 1, e, i, j, diff);
	tree[0][node] = tree[0][node * 2] + tree[0][node * 2 + 1];
}

ll getA(int node, int s, int e, int i)
{
	if (tree[1][node])
	{
		tree[0][node] += (e - s + 1) * tree[1][node];
		if (s != e)
		{
			tree[1][node * 2] += tree[1][node];
			tree[1][node * 2 + 1] += tree[1][node];
		}
		tree[1][node] = 0;
	}
	if (i > e || i < s)
		return 0;
	if (s == e)
		return tree[0][node];
	int mid = (s + e) / 2;
	if (i > mid)
		return getA(node * 2 + 1, mid + 1, e, i);
	return getA(node * 2, s, mid, i);
}

int main()
{
	scanf("%d%d", &n, &m);
	scanf("%d", &a);
	for (int i = 2; i <= n; i++)
	{
		scanf("%d", &a);
		child[a].push_back(i);
	}
	a = 0;
	dfs(1);
	while (m--)
	{
		scanf("%d%d", &a, &b);
		if (a == 1)
		{
			scanf("%d", &a);
			update(1, 1, n, s[b], e[b], a);
		}
		else
			printf("%lld\n", getA(1, 1, n, s[b]));
	}
	return 0;
}
