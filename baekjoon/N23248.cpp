#include <bits/stdc++.h>
using namespace std;
int m, n, k, in[2];
set<int> s[100001];
int main()
{
	scanf("%d%d%d", &m, &n, &k);
	for (int i = 0; i < k; i++)
	{
		scanf("%d%d", &in[0], &in[1]);
		s[in[0]].insert(in[1]);
	}
	int ans = 0;
	while (k)
	{
		int now = 0;
		for (int i = 1; i <= m; i++)
		{
			auto lb = s[i].lower_bound(now);
			if (lb == s[i].end())
				continue;
			k -= s[i].size();
			now = *s[i].rbegin();
			s[i].erase(lb, s[i].end());
			k += s[i].size();
		}
		ans++;
	}
	printf("%d", ans);
	return 0;
}
