#include <bits/stdc++.h>
using namespace std;
int main()
{
	int n;
	long long in[100000][2];
	scanf("%d", &n);
	for (int i = 1; i < n; i++)
		scanf("%lld", &in[i][0]);
	for (int i = 1; i < n; i++)
		scanf("%lld", &in[i][1]);
	long long sum = 0;
	long long cost = in[1][1];
	for (int i = 1; i < n; i++)
	{
		cost = min(cost, in[i][1]);
		sum += cost * in[i][0];
	}
	printf("%lld", sum);
	return 0;
}
