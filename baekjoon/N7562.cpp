#include <bits/stdc++.h>
using namespace std;
int l;
bool isVisit[300][300];
bool isNew(pair<int, int> p)
{
	if (p.first >= 0 && p.first < l && p.second >= 0 && p.second < l)
	{
		if (isVisit[p.first][p.second])
			return false;
		isVisit[p.first][p.second] = true;
		return true;
	}
	return false;
}
int main()
{
	int t;
	scanf("%d", &t);
	while (t--)
	{
		pair<int, int> s, e;
		scanf("%d%d%d%d%d", &l, &s.first, &s.second, &e.first, &e.second);
		for (int i = 0; i < l; i++)
			for (int j = 0; j < l; j++)
				isVisit[i][j] = false;
		queue<pair<int, pair<int, int> > > q;
		q.push(make_pair(0, s));
		isVisit[s.first][s.second] = true;
		while (q.front().second != e)
		{
			int c = q.front().first;
			pair<int, int> now = q.front().second;
			q.pop();
			now.first++;
			now.second += 2;
			if (isNew(now))
				q.push(make_pair(c + 1, pair<int, int>(now)));
			now.first++;
			now.second--;
			if (isNew(now))
				q.push(make_pair(c + 1, pair<int, int>(now)));
			now.second -= 2;
			if (isNew(now))
				q.push(make_pair(c + 1, pair<int, int>(now)));
			now.first--;
			now.second--;
			if (isNew(now))
				q.push(make_pair(c + 1, pair<int, int>(now)));
			now.first -= 2;
			if (isNew(now))
				q.push(make_pair(c + 1, pair<int, int>(now)));
			now.first--;
			now.second++;
			if (isNew(now))
				q.push(make_pair(c + 1, pair<int, int>(now)));
			now.second += 2;
			if (isNew(now))
				q.push(make_pair(c + 1, pair<int, int>(now)));
			now.first++;
			now.second++;
			if (isNew(now))
				q.push(make_pair(c + 1, pair<int, int>(now)));
		}
		printf("%d\n", q.front().first);
	}
	return 0;
}
