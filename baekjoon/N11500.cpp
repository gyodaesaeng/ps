#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
int t, n, in;
ll s[27][27][2], c[27][27], ans[27][2];
ll getC(ll a, ll b)
{
	if (c[a][b])
		return c[a][b];
	if (a == b || !b)
		return c[a][b] = 1;
	return c[a][b] = getC(a - 1, b - 1) + getC(a - 1, b);
}
ll gcd(ll a, ll b)
{
	a = abs(a);
	b = abs(b);
	if (a < b)
		swap(a, b);
	while (b)
	{
		ll c = a % b;
		a = b;
		b = c;
	}
	return a;
}
int main()
{
	for (int i = 0; i < 27; i++)
	{
		memset(c[i], 0, sizeof(c[i]));
		for (int j = 0; j < 27; j++)
		{
			s[i][j][0] = 0;
			s[i][j][1] = 1;
		}
	}
	for (int i = 0; i < 26; i++)
	{
		s[i][i + 1][0] = 1;
		s[i][i + 1][1] = i + 1;
		for (int j = 1; j <= i; j++)
		{
			s[i][j][0] = getC(i + 1, j);
			for (int k = 0; k <= j; k++)
			{
				s[i][k][0] = s[i][k][0] * s[j - 1][k][1] - s[i][k][1] * getC(i + 1, j - 1) * s[j - 1][k][0];
				s[i][k][1] *= s[j - 1][k][1];
				ll g = gcd(s[i][k][0], s[i][k][1]);
				s[i][k][0] /= g;
				s[i][k][1] /= g;
			}
		}
		for (int j = 0; j <= i; j++)
		{
			s[i][j][1] *= i + 1;
			ll g = gcd(s[i][j][0], s[i][j][1]);
			s[i][j][0] /= g;
			s[i][j][1] /= g;
		}
	}
	scanf("%d", &t);
	while (t--)
	{
		scanf("%d", &n);
		for (int i = 0; i < n + 2; i++)
		{
			ans[i][0] = 0;
			ans[i][1] = 1;
		}
		for (int i = 0; i <= n; i++)
		{
			scanf("%d", &in);
			if (!i)
				ans[0][0] = in;
			for (int j = 0; j < i + 2; j++)
			{
				ans[j][0] = ans[j][0] * s[i][j][1] + in * ans[j][1] * s[i][j][0];
				ans[j][1] *= s[i][j][1];
				ll g = gcd(ans[j][0], ans[j][1]);
				ans[j][0] /= g;
				ans[j][1] /= g;
			}
		}
		ll ret = 0;
		for (int i = 0; i < n + 2; i++)
			ret += abs(ans[i][0]);
		printf("%lld\n", ret);
	}
	return 0;
}
