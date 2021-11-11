#include <bits/stdc++.h>
using namespace std;
struct Line
{
	int x1, y1, x2, y2;
};

struct State
{
	int x, y, dir;
	bool operator==(State s)
	{
		return x == s.x && y == s.y && dir == s.dir;
	}
};
vector<Line> x, y;

bool cmpx(Line l1, Line l2)
{
	return l1.x1 < l2.x1;
}

bool cmpy(Line l1, Line l2)
{
	return l1.y1 < l2.y1;
}

int main()
{
	int n, t;
	scanf("%d%d", &n, &t);
	State start, now;
	Line nowLine;
	for (int i = 0; i < n; i++)
	{
		Line l;
		scanf("%d%d%d%d", &l.x1, &l.y1, &l.x2, &l.y2);
		if (!i)
		{
			now.x = l.x1;
			now.y = l.y1;
			if (l.x1 < l.x2)
				now.dir = 0;
			else if (l.y1 > l.y2)
				now.dir = 1;
			else if (l.x1 > l.x2)
				now.dir = 2;
			else
				now.dir = 3;
			start = now;
		}
		if (l.x1 > l.x2 || l.y1 > l.y2)
		{
			swap(l.x1, l.x2);
			swap(l.y1, l.y2);
		}
		if (!i)
			nowLine = l;
		if (l.x1 == l.x2)
			x.push_back(l);
		else
			y.push_back(l);
	}
	sort(x.begin(), x.end(), cmpx);
	sort(y.begin(), y.end(), cmpy);
	int cnt = 0;
	int i;
	Line temp;
	while (true)
	{
		temp.x1 = now.x;
		temp.y1 = now.y;
		switch (now.dir)
		{
		case 0:
			i = upper_bound(x.begin(), x.end(), temp, cmpx) - x.begin();
			while (i < x.size() && x[i].x1 < nowLine.x2 && (x[i].y1 > nowLine.y1 || x[i].y2 < nowLine.y1))
				i++;
			if (i == x.size() || x[i].x1 > nowLine.x2)
			{
				if (t - cnt > nowLine.x2 - now.x)
				{
					now.dir = 2;
					cnt += nowLine.x2 - now.x;
					now.x = nowLine.x2;
				}
				else
				{
					printf("%d %d", now.x + t - cnt, now.y);
					return 0;
				}
			}
			else
			{
				if (t - cnt > x[i].x1 - now.x)
				{
					now.dir = 3;
					cnt += x[i].x1 - now.x;
					now.x = x[i].x1;
					nowLine = x[i];
				}
				else
				{
					printf("%d %d", now.x + t - cnt, now.y);
					return 0;
				}
			}
			break;
		case 1:
			i = lower_bound(y.begin(), y.end(), temp, cmpy) - y.begin() - 1;
			while (i >= 0 && y[i].y1 > nowLine.y1 && (y[i].x1 > nowLine.x1 || y[i].x2 < nowLine.x1))
				i--;
			if (i < 0 || y[i].y1 < nowLine.y1)
			{
				if (t - cnt > now.y - nowLine.y1)
				{
					now.dir = 3;
					cnt += now.y - nowLine.y1;
					now.y = nowLine.y1;
				}
				else
				{
					printf("%d %d", now.x, now.y - t + cnt);
					return 0;
				}
			}
			else
			{
				if (t - cnt > now.y - y[i].y1)
				{
					now.dir = 0;
					cnt += now.y - y[i].y1;
					now.y = y[i].y1;
					nowLine = y[i];
				}
				else
				{
					printf("%d %d", now.x, now.y - t + cnt);
					return 0;
				}
			}
			break;
		case 2:
			i = lower_bound(x.begin(), x.end(), temp, cmpx) - x.begin() - 1;
			while (i >= 0 && x[i].x1 > nowLine.x1 && (x[i].y1 > nowLine.y1 || x[i].y2 < nowLine.y1))
				i--;
			if (i < 0 || x[i].x1 < nowLine.x1)
			{
				if (t - cnt > now.x - nowLine.x1)
				{
					now.dir = 0;
					cnt += now.x - nowLine.x1;
					now.x = nowLine.x1;
				}
				else
				{
					printf("%d %d", now.x - t + cnt, now.y);
					return 0;
				}
			}
			else
			{
				if (t - cnt > now.x - x[i].x1)
				{
					now.dir = 1;
					cnt += now.x - x[i].x1;
					now.x = x[i].x1;
					nowLine = x[i];
				}
				else
				{
					printf("%d %d", now.x - t + cnt, now.y);
					return 0;
				}
			}
			break;
		case 3:
			i = upper_bound(y.begin(), y.end(), temp, cmpy) - y.begin();
			while (i < y.size() && y[i].y1 < nowLine.y2 && (y[i].x1 > nowLine.x1 || y[i].x2 < nowLine.x1))
				i++;
			if (i == y.size() || y[i].y1 > nowLine.y2)
			{
				if (t - cnt > nowLine.y2 - now.y)
				{
					now.dir = 1;
					cnt += nowLine.y2 - now.y;
					now.y = nowLine.y2;
				}
				else
				{
					printf("%d %d", now.x, now.y + t - cnt);
					return 0;
				}
			}
			else
			{
				if (t - cnt > y[i].y2 - now.y)
				{
					now.dir = 2;
					cnt += y[i].y2 - now.y;
					now.y = y[i].y2;
					nowLine = y[i];
				}
				else
				{
					printf("%d %d", now.x, now.y + t - cnt);
					return 0;
				}
			}
			break;
		}
		if (now == start)
		{
			t %= cnt;
			cnt = 0;
		}
	}
	return 0;
}
