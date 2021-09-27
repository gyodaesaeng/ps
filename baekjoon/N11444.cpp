#include <bits/stdc++.h>
using namespace std;
typedef vector<vector<long long> > Matrix;
Matrix m(2);
Matrix mul(Matrix a, Matrix b)
{
	Matrix ret(2);
	for (int i = 0; i < 2; i++)
	{
		ret[i].resize(2);
		for (int j = 0; j < 2; j++)
		{
			ret[i][j] = 0;
			for (int k = 0; k < 2; k++)
				ret[i][j] += a[i][k] * b[k][j];
			ret[i][j] %= 1000000007;
		}
	}
	return ret;
}
Matrix fi(long long n)
{
	if (n < 2)
		return m;
	Matrix ret = fi(n / 2);
	ret = mul(ret, ret);
	if (n % 2)
		ret = mul(ret, m);
	return ret;
}
int main()
{
	long long n;
	scanf("%lld", &n);
	m[0].push_back(1);
	m[0].push_back(1);
	m[1].push_back(1);
	m[1].push_back(0);
	printf("%lld", fi(n)[0][1]);
	return 0;
}
