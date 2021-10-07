#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
ll n, m;
pair<ll, ll> getLoc(ll a, ll b, int turn)
{
	if (a == 1)
		return make_pair(0, 0);
	if (turn < 0)
		turn += 4;
	if (turn > 3)
		turn -= 4;
	a /= 2;
	ll c = b / (a * a);
	pair<ll, ll> ret;
	switch (turn)
	{
	case 0:
		switch (c)
		{
		case 0:
			ret = getLoc(a, b % (a * a), turn + 1);
			break;
		case 1:
			ret = getLoc(a, b % (a * a), turn);
			ret.second += a;
			break;
		case 2:
			ret = getLoc(a, b % (a * a), turn);
			ret.first += a;
			ret.second += a;
			break;
		case 3:
			ret = getLoc(a, b % (a * a), turn - 1);
			ret.first += a;
			break;
		}
		break;
	case 1:
		switch (c)
		{
		case 0:
			ret = getLoc(a, b % (a * a), turn - 1);
			break;
		case 1:
			ret = getLoc(a, b % (a * a), turn);
			ret.first += a;
			break;
		case 2:
			ret = getLoc(a, b % (a * a), turn);
			ret.first += a;
			ret.second += a;
			break;
		case 3:
			ret = getLoc(a, b % (a * a), turn + 1);
			ret.second += a;
			break;
		}
		break;
	case 2:
		switch (c)
		{
		case 0:
			ret = getLoc(a, b % (a * a), turn + 1);
			ret.first += a;
			ret.second += a;
			break;
		case 1:
			ret = getLoc(a, b % (a * a), turn);
			ret.first += a;
			break;
		case 2:
			ret = getLoc(a, b % (a * a), turn);
			break;
		case 3:
			ret = getLoc(a, b % (a * a), turn - 1);
			ret.second += a;
			break;
		}
		break;
	case 3:
		switch (c)
		{
		case 0:
			ret = getLoc(a, b % (a * a), turn - 1);
			ret.first += a;
			ret.second += a;
			break;
		case 1:
			ret = getLoc(a, b % (a * a), turn);
			ret.second += a;
			break;
		case 2:
			ret = getLoc(a, b % (a * a), turn);
			break;
		case 3:
			ret = getLoc(a, b % (a * a), turn + 1);
			ret.first += a;
			break;
		}
		break;
	}

	return ret;
}
int main()
{
	scanf("%lld%lld", &n, &m);
	pair<ll, ll> ans = getLoc(n, m - 1, 0);
	printf("%lld %lld", ans.first + 1, ans.second + 1);
	return 0;
}
