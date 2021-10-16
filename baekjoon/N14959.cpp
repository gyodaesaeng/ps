#include <bits/stdc++.h>
using namespace std;
int n, in[1000001], pi[1000001], k, p;
void kmp()
{
	memset(pi, 0, sizeof(pi));
	for (int i = 1, j = 0; i < n; i++)
	{
		while (j > 0 && in[i] != in[j])
			j = pi[j - 1];
		if (in[i] == in[j])
			pi[i] = ++j;
	}
}

int main()
{
	scanf("%d", &n);
	for (int i = n - 1; i >= 0; i--)
		scanf("%d", &in[i]);
	kmp();
	k = p = INT32_MAX / 2;
	for (int i = 0; i < n; i++)
	{
		if (k + p > n - pi[i])
		{
			k = n - i - 1;
			p = i + 1 - pi[i];
		}
	}
	printf("%d %d", k, p);
	return 0;
}
