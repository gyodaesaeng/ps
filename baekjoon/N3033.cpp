#include <bits/stdc++.h>
using namespace std;
const int MAX_N = 200001;
char s[MAX_N];
int l, t, suffix[MAX_N], lcp[MAX_N], tmp1[MAX_N], tmp2[MAX_N], g[MAX_N], tg[MAX_N];

void getSuffix()
{
	int m = 26;

	fill(tmp2, tmp2 + m + 1, 0);
	for (int i = 0; i < l; i++)
	{
		g[i] = s[i] - 'a';
		tmp2[g[i]]++;
	}
	for (int i = 1; i < m; i++)
		tmp2[i] += tmp2[i - 1];
	for (int i = 0; i < l; i++)
		suffix[--tmp2[g[i]]] = i;
	for (int i = 1; i == 1 || m < l; i <<= 1)
	{
		for (int j = 0; j < l; j++)
		{
			tg[j] = g[j];
			tmp1[j] = suffix[j];
			tmp2[g[tmp1[j]]] = j;
		}
		for (int j = l - 1; j >= 0; j--)
			if (tmp1[j] >= i)
				suffix[tmp2[g[tmp1[j] - i]]--] = tmp1[j] - i;
		for (int j = l - 1; j >= 0; j--)
			if (tmp1[j] + i >= l)
				suffix[tmp2[g[tmp1[j]]]--] = tmp1[j];
		for (int j = m = 0; j < l; j++)
		{
			g[suffix[j]] = m;
			if (j + 1 == l || tg[suffix[j]] != tg[suffix[j + 1]] || suffix[j] + i >= l || tg[suffix[j] + i] != tg[suffix[j + 1] + i])
				m++;
		}
	}
}

void getLcp()
{
	int j = 0;
	for (int i = 0; i < l; i++)
	{
		if (!g[i])
			continue;
		while (s[i + j] == s[suffix[g[i] - 1] + j])
			j++;
		lcp[g[i]] = j;
		if (j)
			j--;
	}
}

int main()
{
	scanf("%d%s", &l, s);
	getSuffix();
	getLcp();
	int ans = 0;
	for (int i = 1; i < l; i++)
		ans = max(ans, lcp[i]);
	printf("%d", ans);
	return 0;
}
