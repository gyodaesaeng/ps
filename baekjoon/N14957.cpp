#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
ll in[2], y[2];
struct stair
{
	ll x, y, index;
	bool operator<(stair const &s1) const
	{
		return this->x > s1.x;
	}
};
priority_queue<stair> pq;
int main()
{
	scanf("%d%d", &in[0], &in[1]);
	for (int i = 0; i < 2; i++)
	{
		scanf("%d", &y[i]);
		for (int j = 0; j < in[i]; j++)
		{
			int a, b;
			scanf("%d%d", &a, &b);
			stair s;
			s.x = a;
			s.y = b;
			s.index = i;
			pq.push(s);
		}
	}
	int cnt = 0;
	ll area = 0, tempArea = 0, lastX;
	bool isRegion = false;
	while (!pq.empty())
	{
		stair s = pq.top();
		pq.pop();
		if (s.index ? s.y > y[0] : s.y < y[1])
		{
			if (isRegion)
				tempArea += (s.x - lastX) * (y[1] - y[0]);
			else if (y[0] >= y[1])
				isRegion = true;
		}
		else if (isRegion)
		{
			cnt++;
			area += tempArea + (s.x - lastX) * (y[1] - y[0]);
			tempArea = 0;
			isRegion = false;
		}
		lastX = s.x;
		y[s.index] = s.y;
	}
	printf("%d %lld", cnt, area);
	return 0;
}
