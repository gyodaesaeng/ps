#include <bits/stdc++.h>
using namespace std;

const int MAXN = 100001;

char in[MAXN];
int l, r, p, palLen[MAXN * 2];
string s;

int main()
{
	scanf("%s", in);
	l = strlen(in);
	for (int i = 0; i < l; i++)
	{
		s += '#';
		s += in[i];
	}
	s += '#';
	r = 0;
	p = 0;
	l = s.size();
	for (int i = 0; i < l; i++)
	{
		if (i <= r)
			palLen[i] = min(palLen[2 * p - i], r - i);
		else
			palLen[i] = 0;

		while (i - palLen[i] - 1 >= 0 && i + palLen[i] + 1 < l && s[i - palLen[i] - 1] == s[i + palLen[i] + 1])
			palLen[i]++;
		if (r < i + palLen[i])
		{
			r = i + palLen[i];
			p = i;
		}
	}
	int ans = 0;
	for (int i = 0; i < l; i++)
		ans = max(ans, palLen[i]);
	printf("%d", ans);
	return 0;
}
