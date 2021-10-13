#include <bits/stdc++.h>
using namespace std;
int n;
struct at
{
	int b, p, q, r;
	bool operator<(at const &a1) const
	{
		if (p * q * r == a1.p * a1.q * a1.r)
		{
			if (p + q + r == a1.p + a1.q + a1.r)
				return b < a1.b;
			return p + q + r < a1.p + a1.q + a1.r;
		}
		return p * q * r < a1.p * a1.q * a1.r;
	}
};
vector<at> v;
int main()
{
	scanf("%d", &n);
	for (int i = 0; i < n; i++)
	{
		at in;
		scanf("%d%d%d%d", &in.b, &in.p, &in.q, &in.r);
		v.push_back(in);
	}
	sort(v.begin(), v.end());
	printf("%d %d %d", v[0].b, v[1].b, v[2].b);
	return 0;
}
