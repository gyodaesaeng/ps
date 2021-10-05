#include <bits/stdc++.h>
using namespace std;
int n, temp, e[10001], ans[10000];
int main()
{
	scanf("%d", &n);
	for (int i = 0; i < n; i++)
		scanf("%d%d", &temp, &e[i + 1]);
	int x = 0, y = 1, dir = e[1];
	ans[0] = 1;
	for (int i = 1; i < n; i++)
	{
		if (dir == e[i])
		{
			if (i % 2)
				ans[i] = ++x;
			else
				ans[i] = ++y;
		}
		else
		{
			dir = e[i];
			ans[i] = 1;
			if (i % 2)
				x++;
			else
				y++;
		}
	}
	for (int i = 0; i < n; i++)
		printf("%d ", ans[i]);
	return 0;
}
