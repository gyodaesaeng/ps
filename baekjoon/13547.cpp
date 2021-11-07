#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
const int MAX_N = 100001;
struct Query
{
	int i, s, e;
};
int n, m, sqrtN, s, e, last, a[MAX_N], cnt[MAX_N], ans[MAX_N];
vector<int> zip;
vector<Query> query;

bool cmp(Query const &q1, Query const &q2)
{
	if (q1.s / sqrtN != q2.s / sqrtN)
		return q1.s / sqrtN < q2.s / sqrtN;
	return q1.e < q2.e;
}
int main()
{
	scanf("%d", &n);
	for (int i = 1; i <= n; i++)
	{
		scanf("%d", &a[i]);
		zip.push_back(a[i]);
	}
	scanf("%d", &m);
	for (int i = 0; i < m; i++)
	{
		Query q;
		scanf("%d%d", &q.s, &q.e);
		q.i = i;
		query.push_back(q);
	}
	sqrtN = sqrt(n);
	sort(zip.begin(), zip.end());
	zip.erase(unique(zip.begin(), zip.end()), zip.end());
	for (int i = 1; i <= n; i++)
		a[i] = lower_bound(zip.begin(), zip.end(), a[i]) - zip.begin();
	sort(query.begin(), query.end(), cmp);
	s = query[0].s;
	e = query[0].e;
	memset(cnt, 0, sizeof(cnt));
	last = 0;
	for (int i = s; i <= e; i++)
		if (!cnt[a[i]]++)
			last++;
	ans[query[0].i] = last;
	for (int i = 1; i < m; i++)
	{
		while (s < query[i].s)
			if (!--cnt[a[s++]])
				last--;
		while (s > query[i].s)
			if (!cnt[a[--s]]++)
				last++;
		while (e < query[i].e)
			if (!cnt[a[++e]]++)
				last++;
		while (e > query[i].e)
			if (!--cnt[a[e--]])
				last--;
		ans[query[i].i] = last;
	}
	for (int i = 0; i < m; i++)
		printf("%d\n", ans[i]);
	return 0;
}
