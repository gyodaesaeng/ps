#include <bits/stdc++.h>
using namespace std;
int main()
{
	int n;
	scanf("%d", &n);
	if (n < 2)
	{
		printf("0");
		return 0;
	}
	bool sieve[n + 1];
	memset(sieve, false, sizeof(sieve));
	for (int i = 2; i <= n; i++)
	{
		if (sieve[i])
			continue;
		for (int j = 2; i * j <= n; j++)
			sieve[i * j] = true;
	}
	vector<int> prime;
	for (int i = 2; i <= n; i++)
		if (!sieve[i])
			prime.push_back(i);
	int sum = prime[0];
	int cnt = 0;
	int i = 0;
	int j = 0;
	while (j < prime.size())
	{
		if (sum == n)
			cnt++;
		if (sum > n && i < j)
			sum -= prime[i++];
		else
			sum += prime[++j];
	}
	printf("%d", cnt);
	return 0;
}
