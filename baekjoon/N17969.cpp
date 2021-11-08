#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
struct Edge
{
	int e;
	ll l;
};
struct Info
{
	ll cnt, s1, s2;
};
const int MAX_V = 100000;
int n, a, b, c, cnt[MAX_V];
ll ans;
vector<Edge> edge[MAX_V];

int getSize(int v, int p)
{
	cnt[v] = 1;
	for (Edge e : edge[v])
		if (e.e != p)
			cnt[v] += getSize(e.e, v);
	return cnt[v];
}

int getCent(int v, int p, int m)
{
	for (Edge e : edge[v])
		if (e.e != p && cnt[e.e] * 2 > m)
			return getCent(e.e, v, m);
	return v;
}

Info getInfo(int v, int p)
{
	Info ret;
	ret.cnt = 0;
	ret.s1 = 0;
	ret.s2 = 0;
	for (Edge e : edge[v])
	{
		if (e.e == p)
			continue;
		Info info = getInfo(e.e, v);
		info.s2 += 2 * info.s1 * e.l + info.cnt * e.l * e.l;
		info.s1 += info.cnt * e.l;
		ans += ret.s2 * info.cnt + ret.cnt * info.s2 + 2 * ret.s1 * info.s1;
		ret.cnt += info.cnt;
		ret.s1 += info.s1;
		ret.s2 += info.s2;
	}
	if (!ret.cnt)
		ret.cnt++;
	return ret;
}

int main()
{
	scanf("%d", &n);
	for (int i = 1; i < n; i++)
	{
		scanf("%d%d%d", &a, &b, &c);
		Edge e1, e2;
		e1.e = --b;
		e2.e = --a;
		e1.l = e2.l = c;
		edge[a].push_back(e1);
		edge[b].push_back(e2);
	}
	getSize(0, -1);
	ans = 0;
	getInfo(getCent(0, -1, n), -1);
	printf("%lld", ans);
	return 0;
}
