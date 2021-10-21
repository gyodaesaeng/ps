#include <bits/stdc++.h>
#define INF 3000000000000LL
using namespace std;
typedef long long ll;
struct Point
{
	int x, y;
	ll w;
};
struct Node
{
	ll sum, lMax, rMax, aMax;
};
int n;
vector<int> co[2], py[3000];
vector<Point> p;
Node tree[9000];

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
	scanf("%d", &n);
	p.resize(n);
	for (int i = 0; i < n; i++)
	{
		scanf("%d%d%lld", &p[i].x, &p[i].y, &p[i].w);
		co[0].push_back(p[i].x);
		co[1].push_back(p[i].y);
	}
	for (int i = 0; i < 2; i++)
	{
		sort(co[i].begin(), co[i].end());
		co[i].erase(unique(co[i].begin(), co[i].end()), co[i].end());
	}
	for (int i = 0; i < p.size(); i++)
	{
		p[i].x = lower_bound(co[0].begin(), co[0].end(), p[i].x) - co[0].begin();
		p[i].y = lower_bound(co[1].begin(), co[1].end(), p[i].y) - co[1].begin();
		py[p[i].x].push_back(i);
	}
	ll ans = -INF;
	for (int i = 0; i < co[0].size(); i++)
	{
		for (int j = 0; j < 9000; j++)
			tree[j].sum = tree[j].lMax = tree[j].rMax = tree[j].aMax = 0;
		for (int j = i; j < co[0].size(); j++)
		{
			for (int k = 0; k < py[j].size(); k++)
				update(1, 0, co[1].size() - 1, p[py[j][k]].y, p[py[j][k]].w);
			ans = max(ans, get(1, 0, co[1].size() - 1, 0, co[1].size() - 1).aMax);
		}
	}
	printf("%lld", ans);
	return 0;
}
