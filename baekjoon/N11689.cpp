#include <stdio.h>
int main()
{
	long long n;
	scanf("%lld", &n);
	long long ans = n;
	for (long long i = 2; i * i <= n; i++)
	{
		if (n % i == 0)
		{
			while (n % i == 0)
				n /= i;
			ans /= i;
			ans *= i - 1;
		}
	}
	if (n > 1)
	{
		ans /= n;
		ans *= n - 1;
	}
	printf("%lld", ans);
}
