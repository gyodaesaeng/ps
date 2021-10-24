#include <bits/stdc++.h>
using namespace std;
int n, in, pi[360000];
bool a[720000], b[360000];
bool kmp()
{
	memset(pi, 0, sizeof(pi));
	int j = 0;
	for (int i = 1; i < 360000; i++)
	{
		while (j && b[i] != b[j])
			j = pi[j - 1];
		if (b[i] == b[j])
			pi[i] = ++j;
	}
	j = 0;
	for (int i = 0; i < 720000; i++)
	{
		while (j > 0 && a[i] != b[j])
			j = pi[j - 1];
		if (a[i] == b[j] && ++j == 360000)
			return true;
	}
	return false;
}

int main()
{
	scanf("%d", &n);
	memset(a, false, sizeof(a));
	for (int i = 0; i < n; i++)
	{
		scanf("%d", &in);
		a[in] = a[360000 + in] = true;
	}
	memset(b, false, sizeof(b));
	for (int i = 0; i < n; i++)
	{
		scanf("%d", &in);
		b[in] = true;
	}
	printf(kmp() ? "possible" : "impossible");
	return 0;
}
