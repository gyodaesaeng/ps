#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
int t, n;
pair<ll, ll> p[200000];

ll ccw(pair<ll, ll> p1, pair<ll, ll> p2, pair<ll, ll> p3)
{
	return (p2.first - p1.first) * (p3.second - p1.second) - (p2.second - p1.second) * (p3.first - p1.first);
}

bool compare(pair<ll, ll> p1, pair<ll, ll> p2)
{
	ll ret = ccw(p[0], p1, p2);
	if (ret)
		return ret > 0;
	return p1 < p2;
}
ll pow(ll a)
{
	return a * a;
}
int main()
{
	scanf("%d", &t);
	while (t--)
	{
		scanf("%d", &n);
		for (int i = 0; i < n; i++)
		{
			scanf("%lld %lld", &p[i].first, &p[i].second);
			if (p[0] > p[i])
				swap(p[0], p[i]);
		}
		sort(p + 1, p + n, compare);
		stack<pair<ll, ll> > s;
		s.push(p[0]);
		s.push(p[1]);
		for (int i = 2; i < n; i++)
		{
			while (s.size() > 1)
			{
				pair<ll, ll> temp = s.top();
				s.pop();
				if (ccw(s.top(), temp, p[i]) > 0)
				{
					s.push(temp);
					break;
				}
			}
			s.push(p[i]);
		}
		vector<pair<ll, ll> > v;
		while (!s.empty())
		{
			v.push_back(s.top());
			s.pop();
		}
		int next, p1, p2, j = 1;
		ll len = 0;
		pair<ll, ll> zero, pi, pj;
		zero.first = 0;
		zero.second = 0;
		for (int i = 0; i < v.size(); i++)
		{
			next = (i + 1) % v.size();
			pi.first = v[next].first - v[i].first;
			pi.second = v[next].second - v[i].second;
			while (true)
			{
				next = (j + 1) % v.size();
				pj.first = v[next].first - v[j].first;
				pj.second = v[next].second - v[j].second;
				if (ccw(zero, pi, pj) >= 0)
					break;
				j = next;
			}
			ll nowLen = pow(v[i].first - v[j].first) + pow(v[i].second - v[j].second);
			if (len < nowLen)
			{
				len = nowLen;
				p1 = i;
				p2 = j;
			}
		}
		printf("%lld %lld %lld %lld\n", v[p1].first, v[p1].second, v[p2].first, v[p2].second);
	}
	return 0;
}
