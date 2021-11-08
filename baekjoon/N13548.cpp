#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
const int MAX_N = 100001;
struct Query
{
	int i, s, e;
};
int n, m, sqrtN, s, e, most, a[MAX_N], cnt[MAX_N], cntCnt[MAX_N], ans[MAX_N];
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
		scanf("%d", &a[i]);
	scanf("%d", &m);
	for (int i = 0; i < m; i++)
	{
		Query q;
		scanf("%d%d", &q.s, &q.e);
		q.i = i;
		query.push_back(q);
	}
	sqrtN = sqrt(n);
	sort(query.begin(), query.end(), cmp);
	s = query[0].s;
	e = query[0].e;
	memset(cnt, 0, sizeof(cnt));
	memset(cntCnt, 0, sizeof(cntCnt));
	cntCnt[0] = n;
	most = 0;
	for (int i = s; i <= e; i++)
	{
		cntCnt[cnt[a[i]]]--;
		cntCnt[++cnt[a[i]]]++;
		if (cnt[a[i]] > most)
			most = cnt[a[i]];
	}
	ans[query[0].i] = most;
	for (int i = 1; i < m; i++)
	{
		while (s < query[i].s)
		{
			if (!--cntCnt[cnt[a[s]]] && cnt[a[s]] == most)
				most--;
			cntCnt[--cnt[a[s++]]]++;
		}
		while (s > query[i].s)
		{
			cntCnt[cnt[a[--s]]]--;
			cntCnt[++cnt[a[s]]]++;
			if (cnt[a[s]] > most)
				most++;
		}
		while (e < query[i].e)
		{
			cntCnt[cnt[a[++e]]]--;
			cntCnt[++cnt[a[e]]]++;
			if (cnt[a[e]] > most)
				most++;
		}
		while (e > query[i].e)
		{
			if (!--cntCnt[cnt[a[e]]] && cnt[a[e]] == most)
				most--;
			cntCnt[--cnt[a[e--]]]++;
		}
		ans[query[i].i] = most;
	}
	for (int i = 0; i < m; i++)
		printf("%d\n", ans[i]);
	return 0;
}
