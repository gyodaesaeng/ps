#include <bits/stdc++.h>
#define INF 10000000
using namespace std;
typedef long long ll;
struct Point
{
	int x, y, c;
};
struct Node
{
	ll sum, lMax, rMax, aMax;
};
int n, c[2], l[2];
vector<int> co[2];
vector<Point> p[2], py[2001];
Node tree[6003];

Node update(int node, int s, int e, int i, ll diff)
{
	if (i < s || i > e)
		return tree[node];
	if (s == e)
	{
		tree[node].sum += diff;
		tree[node].lMax = tree[node].rMax = tree[node].aMax = tree[node].sum;
		return tree[node];
	}
	Node lNode = update(node * 2, s, (s + e) / 2, i, diff);
	Node rNode = update(node * 2 + 1, (s + e) / 2 + 1, e, i, diff);
	tree[node].sum = lNode.sum + rNode.sum;
	tree[node].lMax = max(lNode.lMax, lNode.sum + rNode.lMax);
	tree[node].rMax = max(rNode.rMax, lNode.rMax + rNode.sum);
	tree[node].aMax = max(max(lNode.aMax, rNode.aMax), lNode.rMax + rNode.lMax);
	return tree[node];
}

Node get(int node, int s, int e, int i, int j)
{
	if (i > e || j < s)
		return {0, -INF, -INF, -INF};
	if (i <= s && e <= j)
		return tree[node];
	Node lNode = get(node * 2, s, (s + e) / 2, i, j);
	Node rNode = get(node * 2 + 1, (s + e) / 2 + 1, e, i, j);
	Node ret;
	ret.sum = lNode.sum + rNode.sum;
	ret.lMax = max(lNode.lMax, lNode.sum + rNode.lMax);
	ret.rMax = max(rNode.rMax, lNode.rMax + rNode.sum);
	ret.aMax = max(max(lNode.aMax, rNode.aMax), lNode.rMax + rNode.lMax);
	return ret;
}

int main()
{
	for (int i = 0; i < 2; i++)
	{
		scanf("%d", &n);
		p[i].resize(n);
		for (int j = 0; j < n; j++)
		{
			scanf("%d%d", &p[i][j].x, &p[i][j].y);
			co[0].push_back(p[i][j].x);
			co[1].push_back(p[i][j].y);
		}
	}
	scanf("%d%d", &c[0], &c[1]);
	c[1] *= -1;
	for (int i = 0; i < 2; i++)
	{
		sort(co[i].begin(), co[i].end());
		co[i].erase(unique(co[i].begin(), co[i].end()), co[i].end());
		l[i] = co[i].size() + 1;
	}
	for (int i = 0; i < 2; i++)
	{
		for (int j = 0; j < p[i].size(); j++)
		{
			p[i][j].x = lower_bound(co[0].begin(), co[0].end(), p[i][j].x) - co[0].begin();
			p[i][j].y = lower_bound(co[1].begin(), co[1].end(), p[i][j].y) - co[1].begin();
			p[i][j].c = c[i];
			py[p[i][j].x].push_back(p[i][j]);
		}
	}
	ll ans = -INF;
	for (int i = 0; i < co[0].size(); i++)
	{
		for (int j = 0; j < 6003; j++)
			tree[j].sum = tree[j].lMax = tree[j].rMax = tree[j].aMax = 0;
		for (int j = i; j < co[0].size(); j++)
		{
			for (Point k : py[j])
				update(1, 0, co[1].size() - 1, k.y, k.c);
			ans = max(ans, get(1, 0, co[1].size() - 1, 0, co[1].size() - 1).aMax);
		}
	}
	printf("%lld", ans);
	return 0;
}
