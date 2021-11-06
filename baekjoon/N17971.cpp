#include <bits/stdc++.h>
using namespace std;
struct Ladder
{
	bool isDeleted;
	int i, j, d;
};
int n, in, order[50], swaped[50][50];
vector<Ladder> v;

bool cmp(Ladder const &l1, Ladder const &l2)
{
	return l1.d < l2.d;
}

int main()
{
	scanf("%d", &n);
	for (int i = 1; i < n; i++)
	{
		for (int j = 1;; j++)
		{
			Ladder ladder;
			ladder.isDeleted = false;
			ladder.i = i;
			ladder.j = j;
			scanf("%d", &ladder.d);
			if (!ladder.d)
				break;
			v.push_back(ladder);
		}
	}
	sort(v.begin(), v.end(), cmp);
	while (true)
	{
		for (int i = 0; i < n; i++)
			order[i] = i;
		memset(swaped, 0, sizeof(swaped));
		bool isErase = false;
		for (int i = 0; i < v.size(); i++)
		{
			if (v[i].isDeleted)
				continue;
			int j = v[i].i;
			if (swaped[order[j - 1]][order[j]])
			{
				isErase = true;
				v[i].isDeleted = true;
				v[swaped[order[j - 1]][order[j]] - 1].isDeleted = true;
				break;
			}
			swaped[order[j - 1]][order[j]] = swaped[order[j]][order[j - 1]] = i + 1;
			swap(order[j - 1], order[j]);
		}
		if (!isErase)
			break;
	}
	int ans = 0;
	for (Ladder l : v)
		if (!l.isDeleted)
			ans++;
	printf("%d\n", ans);
	for (Ladder l : v)
		if (!l.isDeleted)
			printf("%d %d\n", l.i, l.j);
	return 0;
}
