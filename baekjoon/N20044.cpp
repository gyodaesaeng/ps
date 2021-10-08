#include <bits/stdc++.h>
using namespace std;
int n, a;
vector<int> in;
int main()
{
	scanf("%d", &n);
	for (int i = 0; i < 2 * n; i++)
	{
		scanf("%d", &a);
		in.push_back(a);
	}
	sort(in.begin(), in.end());
	int ans = 200000;
	for (int i = 0; i < n; i++)
	{
		ans = min(ans, in[i] + in[2 * n - i - 1]);
	}
	printf("%d", ans);
	return 0;
}
