#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
struct Query
{
	int i, l, r;
};
const int MAX_N = 100001;
int n, sqrtN, t, l, r, a[MAX_N];
ll cnt[MAX_N], ans[MAX_N], now;
vector<int> z;
vector<Query> q;

bool cmp(Query const &q1, Query const &q2)
{
	if (q1.l / sqrtN != q2.l / sqrtN)
		return q1.l / sqrtN < q2.l / sqrtN;
	return q1.r < q2.r;
}

int main()
{
	scanf("%d%d", &n, &t);
	sqrtN = sqrt(n);
	for (int i = 1; i <= n; i++)
	{
		scanf("%d", &a[i]);
		z.push_back(a[i]);
	}
	sort(z.begin(), z.end());
	z.erase(unique(z.begin(), z.end()), z.end());
	for (int i = 1; i <= n; i++)
		a[i] = lower_bound(z.begin(), z.end(), a[i]) - z.begin();
	q.resize(t);
	for (int i = 0; i < t; i++)
	{
		q[i].i = i;
		scanf("%d%d", &q[i].l, &q[i].r);
	}
	sort(q.begin(), q.end(), cmp);
	memset(cnt, 0, sizeof(cnt));
	memset(ans, 0, sizeof(ans));
	now = 0;
	l = q[0].l;
	r = q[0].r;
	for (int i = l; i <= r; i++)
	{
		cnt[a[i]]++;
		now += z[a[i]] * (2 * cnt[a[i]] - 1);
	}
	ans[q[0].i] = now;
	for (int i = 1; i < t; i++)
	{
		while (l > q[i].l)
		{
			cnt[a[--l]]++;
			now += z[a[l]] * (2 * cnt[a[l]] - 1);
		}
		while (l < q[i].l)
		{
			cnt[a[l]]--;
			now -= z[a[l]] * (2 * cnt[a[l]] + 1);
			l++;
		}
		while (r < q[i].r)
		{
			cnt[a[++r]]++;
			now += z[a[r]] * (2 * cnt[a[r]] - 1);
		}
		while (r > q[i].r)
		{
			cnt[a[r]]--;
			now -= z[a[r]] * (2 * cnt[a[r]] + 1);
			r--;
		}
		ans[q[i].i] = now;
	}
	for (int i = 0; i < t; i++)
		printf("%lld\n", ans[i]);
	return 0;
}
