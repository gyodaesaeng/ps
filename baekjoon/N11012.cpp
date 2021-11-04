#include <bits/stdc++.h>
using namespace std;
const int MAX_Y = 100000;
const int MAX_M = 50000;
struct Parade
{
	bool isFirst;
	int x, y1, y2, i;
};
int t, n, m, tree[MAX_Y + 2], memo[MAX_M];
pair<int, int> egg[10000];
Parade p[MAX_M * 2];

bool cmp(Parade const &p1, Parade const &p2)
{
	return p1.x < p2.x;
}

int get(int i)
{
	int ret = 0;
	while (i > 0)
	{
		ret += tree[i];
		i -= i & -i;
	}
	return ret;
}
void update(int i, int v)
{
	while (i < MAX_Y + 2)
	{
		tree[i] += v;
		i += i & -i;
	}
}

int main()
{
	scanf("%d", &t);
	while (t--)
	{
		scanf("%d%d", &n, &m);
		for (int i = 0; i < n; i++)
			scanf("%d%d", &egg[i].first, &egg[i].second);
		for (int i = 0; i < m; i++)
		{
			scanf("%d%d%d%d", &p[i * 2].x, &p[i * 2 + 1].x, &p[i * 2].y1, &p[i * 2].y2);
			p[i * 2].x--;
			p[i * 2 + 1].y1 = p[i * 2].y1;
			p[i * 2 + 1].y2 = ++p[i * 2].y2;
			p[i * 2].i = p[i * 2 + 1].i = i;
			p[i * 2].isFirst = true;
			p[i * 2 + 1].isFirst = false;
		}
		sort(egg, egg + n);
		sort(p, p + 2 * m, cmp);
		memset(tree, 0, sizeof(tree));
		long long ans = 0;
		int j = 0;
		for (int i = 0; i < m * 2; i++)
		{
			while (j < n && egg[j].first <= p[i].x)
				update(egg[j++].second + 1, 1);
			if (p[i].isFirst)
				memo[p[i].i] = get(p[i].y2) - get(p[i].y1);
			else
				ans += get(p[i].y2) - get(p[i].y1) - memo[p[i].i];
		}
		printf("%lld\n", ans);
	}
	return 0;
}
