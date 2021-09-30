#include <bits/stdc++.h>
using namespace std;
vector<int> v[2], in[2];
int n, c, temp;
void bf(int i, int j, int sum)
{
	if (sum > c)
		return;
	if (j == in[i].size())
	{
		v[i].push_back(sum);
		return;
	}
	bf(i, j + 1, sum);
	bf(i, j + 1, sum + in[i][j]);
}
int main()
{
	scanf("%d%d", &n, &c);
	for (int i = 0; i < n; i++)
	{
		scanf("%d", &temp);
		in[i % 2].push_back(temp);
	}
	for (int i = 0; i < 2; i++)
	{
		bf(i, 0, 0);
		sort(v[i].begin(), v[i].end());
	}
	int ans = 0;
	int j = v[1].size();
	for (int i : v[0])
	{
		while (j > 0 && i + v[1][j - 1] > c)
			j--;
		ans += j;
	}
	printf("%d", ans);
	return 0;
}
