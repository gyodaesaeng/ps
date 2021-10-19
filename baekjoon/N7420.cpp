#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
int n, l, temp;
pair<ll, ll> p[1000];

ll ccw(pair<ll, ll> p1, pair<ll, ll> p2, pair<ll, ll> p3)
{
	return (p2.first - p1.first) * (p3.second - p1.second) - (p2.second - p1.second) * (p3.first - p1.first);
}

bool compare(pair<ll, ll> p1, pair<ll, ll> p2)
{
	ll ret = ccw(p[0], p1, p2);
	return ret ? ret > 0 : p1 < p2;
}

ll pow(ll a)
{
	return a * a;
}

int main()
{
	scanf("%d%d", &n, &l);
	for (int i = 0; i < n; i++)
	{
		scanf("%lld %lld", &p[i].first, &p[i].second);
		if (p[0] > p[i])
			swap(p[0], p[i]);
	}
	sort(p + 1, p + n, compare);
	stack<int> s;
	s.push(0);
	s.push(1);
	for (int i = 2; i < n; i++)
	{
		while (s.size() > 1)
		{
			temp = s.top();
			s.pop();
			if (ccw(p[s.top()], p[temp], p[i]) > 0)
			{
				s.push(temp);
				break;
			}
		}
		s.push(i);
	}
	double len = 2 * M_PI * l;
	int first = temp = s.top();
	s.pop();
	while (!s.empty())
	{
		len += sqrt(pow(p[temp].first - p[s.top()].first) + pow(p[temp].second - p[s.top()].second));
		temp = s.top();
		s.pop();
	}
	len += sqrt(pow(p[temp].first - p[first].first) + pow(p[temp].second - p[first].second));
	ll ans = round(len);
	printf("%lld", ans);
	return 0;
}
