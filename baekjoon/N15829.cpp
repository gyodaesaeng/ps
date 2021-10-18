#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
char a[51];
int l;
ll r, ans;
int main()
{
	scanf("%d%s", &l, a);
	ans = 0, r = 1;
	for (int i = 0; i < l; i++)
	{
		ans += (a[i] - 'a' + 1) * r;
		r *= 31;
		ans %= 1234567891;
		r %= 1234567891;
	}
	printf("%lld", ans);
	return 0;
}
