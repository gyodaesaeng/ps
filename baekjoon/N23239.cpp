#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
ll w, h, l, powL1, powL2;
int main()
{
	scanf("%lld%lld%lld", &w, &h, &l);
	ll ans = l * 2;
	powL1 = l * l;
	for (ll i = 1; i < l; i++)
		ans += 3 * (ll)sqrt(powL1 - i * i);
	if (l > w)
	{
		powL1 = (l - w) * (l - w);
		for (ll i = 0; i <= h && i < l - w; i++)
			ans += sqrt(powL1 - i * i);
	}
	if (l > h)
	{
		powL2 = (l - h) * (l - h);
		for (ll i = 0; i <= w && i < l - h; i++)
			ans += sqrt(powL2 - i * i);
	}
	if (l > w + h)
	{
		for (ll i = 1;; i++)
		{
			ll temp1 = 0;
			ll temp2 = powL1 - (i + h) * (i + h);
			if (temp2 > 0)
				temp1 = sqrt(temp2);
			temp2 = powL2 - i * i;
			if (temp2 > 0)
				temp1 = max(temp1, (ll)sqrt(temp2) - w);
			if (temp1 < 1)
				break;
			ans += temp1;
		}
	}
	printf("%lld", ans);
	return 0;
}
