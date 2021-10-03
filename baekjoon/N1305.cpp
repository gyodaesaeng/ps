#include <bits/stdc++.h>
using namespace std;
int l, pi[1000000];
char s[1000000];
void kmp()
{
	memset(pi, 0, sizeof(pi));
	int j = 0;
	for (int i = 1; i < l; i++)
	{
		while (j && s[i] != s[j])
			j = pi[j - 1];
		if (s[i] == s[j])
			pi[i] = ++j;
	}
}
int main()
{
	scanf("%d%s", &l, s);
	kmp();
	printf("%d", l - pi[l - 1]);
	return 0;
}
