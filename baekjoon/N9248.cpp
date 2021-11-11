#include <bits/stdc++.h>
using namespace std;
const int MAX_N = 500001;
char s[MAX_N];
int n, t, suffix[MAX_N], lcp[MAX_N], tmp1[MAX_N], tmp2[MAX_N], g[MAX_N], tg[MAX_N];

void getSuffix()
{
	int m = 26;

	fill(tmp2, tmp2 + m + 1, 0);
	for (int i = 0; i < n; i++)
	{
		g[i] = s[i] - 'a';
		tmp2[g[i]]++;
	}
	for (int i = 1; i < m; i++)
		tmp2[i] += tmp2[i - 1];
	for (int i = 0; i < n; i++)
		suffix[--tmp2[g[i]]] = i;
	for (int i = 1; i == 1 || m < n; i <<= 1)
	{
		for (int j = 0; j < n; j++)
		{
			tg[j] = g[j];
			tmp1[j] = suffix[j];
			tmp2[g[tmp1[j]]] = j;
		}
		for (int j = n - 1; j >= 0; j--)
			if (tmp1[j] >= i)
				suffix[tmp2[g[tmp1[j] - i]]--] = tmp1[j] - i;
		for (int j = n - 1; j >= 0; j--)
			if (tmp1[j] + i >= n)
				suffix[tmp2[g[tmp1[j]]]--] = tmp1[j];
		for (int j = m = 0; j < n; j++)
		{
			g[suffix[j]] = m;
			if (j + 1 == n || tg[suffix[j]] != tg[suffix[j + 1]] || suffix[j] + i >= n || tg[suffix[j] + i] != tg[suffix[j + 1] + i])
				m++;
		}
	}
}

void getLcp()
{
	int j = 0;
	for (int i = 0; i < n; i++)
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
	scanf("%s", s);
	n = strlen(s);
	getSuffix();
	for (int i = 0; i < n; i++)
		printf("%d ", suffix[i] + 1);
	getLcp();
	printf("\nx ");
	for (int i = 1; i < n; i++)
		printf("%d ", lcp[i]);
	return 0;
}
