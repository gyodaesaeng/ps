#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
struct Side
{
	bool isStart;
	int x1, x2, y;
};
const int MAX_N = 200000;
int n, cnt[MAX_N * 6], sum[MAX_N * 6];
Side s[MAX_N * 2];
vector<int> x;

bool cmp(Side const &s1, Side const &s2)
{
	return s1.y < s2.y;
}
void update(int node, int start, int end, int l, int r, int v)
{
	if (l > end || r < start)
		return;
	if (l <= start && end <= r)
		cnt[node] += v;
	else
	{
		int mid = (start + end) / 2;
		update(node * 2, start, mid, l, r, v);
		update(node * 2 + 1, mid + 1, end, l, r, v);
	}
	if (cnt[node])
		sum[node] = x[end] - x[start - 1];
	else
		sum[node] = start == end ? 0 : sum[node * 2] + sum[node * 2 + 1];
}
int main()
{
	scanf("%d", &n);
	for (int i = 0; i < n; i++)
	{
		scanf("%d%d%d%d", &s[i * 2].x1, &s[i * 2].x2, &s[i * 2].y, &s[i * 2 + 1].y);
		x.push_back(s[i * 2].x1);
		x.push_back(s[i * 2].x2);
		s[i * 2 + 1].x1 = s[i * 2].x1;
		s[i * 2 + 1].x2 = s[i * 2].x2;
		s[i * 2].isStart = true;
		s[i * 2 + 1].isStart = false;
	}
	sort(x.begin(), x.end());
	x.erase(unique(x.begin(), x.end()), x.end());
	for (int i = 0; i < 2 * n; i++)
	{
		s[i].x1 = lower_bound(x.begin(), x.end(), s[i].x1) - x.begin();
		s[i].x2 = lower_bound(x.begin(), x.end(), s[i].x2) - x.begin();
	}
	sort(s, s + 2 * n, cmp);
	memset(cnt, 0, sizeof(cnt));
	ll ans = 0, last = s[0].y;
	for (int i = 0; i < 2 * n; i++)
	{
		ans += (s[i].y - last) * sum[1];
		last = s[i].y;
		update(1, 1, x.size(), s[i].x1 + 1, s[i].x2, s[i].isStart ? 1 : -1);
	}
	printf("%lld", ans);
	return 0;
}
