#include <stdio.h>
#include <stack>
#include <utility>
#include <algorithm>
using namespace std;
int n;
pair<int, int> p[100000];

long long ccw(pair<int, int> p1, pair<int, int> p2, pair<int, int> p3)
{
	return (long long)p2.first * p3.second + p1.first * p2.second + p1.second * p3.first - p1.first * p3.second - p2.second * p3.first - p1.second * p2.first;
}

bool compare(pair<int, int> p1, pair<int, int> p2)
{
	long long ret = ccw(p[0], p1, p2);
	return ret ? ret > 0 : p1.first + p1.second < p2.first + p2.second;
}

int main()
{
	scanf("%d", &n);
	for (int i = 0; i < n; i++)
	{
		scanf("%d %d", &p[i].first, &p[i].second);
		if (p[0].first + p[0].second > p[i].first + p[i].second)
			swap(p[0], p[i]);
	}
	sort(p + 1, p + n, compare);
	stack<pair<int, int> > s;
	s.push(p[0]);
	s.push(p[1]);
	for (int i = 2; i < n; i++)
	{
		while (s.size() > 1)
		{
			pair<int, int> temp = s.top();
			s.pop();
			if (ccw(s.top(), temp, p[i]) > 0)
			{
				s.push(temp);
				break;
			}
		}
		s.push(p[i]);
	}
	printf("%lu", s.size());
}
