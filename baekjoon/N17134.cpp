#include <bits/stdc++.h>
using namespace std;
typedef complex<double> base;
void fft(vector<base> &a, bool invert)
{
	int n = a.size();
	for (int i = 1, j = 0; i < n; i++)
	{
		int bit = n >> 1;
		for (; j >= bit; bit >>= 1)
			j -= bit;
		j += bit;
		if (i < j)
			swap(a[i], a[j]);
	}
	for (int len = 2; len <= n; len <<= 1)
	{
		double ang = 2 * M_PI / len * (invert ? -1 : 1);
		base wlen(cos(ang), sin(ang));
		for (int i = 0; i < n; i += len)
		{
			base w(1);
			for (int j = 0; j < len / 2; j++)
			{
				base u = a[i + j], v = a[i + j + len / 2] * w;
				a[i + j] = u + v;
				a[i + j + len / 2] = u - v;
				w *= wlen;
			}
		}
	}
	if (invert)
	{
		for (int i = 0; i < n; i++)
			a[i] /= n;
	}
}

void convolution(const vector<int> &a, const vector<int> &b, vector<int> &c)
{
	vector<base> fa(a.begin(), a.end()), fb(b.begin(), b.end());
	int n = 1;
	while (n < max(a.size(), b.size()))
		n <<= 1;
	n <<= 1;
	fa.resize(n);
	fb.resize(n);
	fft(fa, false);
	fft(fb, false);
	for (int i = 0; i < n; i++)
		fa[i] *= fb[i];
	fft(fa, true);
	c.resize(n);
	for (int i = 0; i < n; i++)
		c[i] = int(fa[i].real() + (fa[i].real() > 0 ? 0.5 : -0.5));
}

int main()
{
	vector<int> prime(1000001, 0), semi(1000001, 0), ans;
	int t, n;
	for (int i = 2; i < 1000001; i++)
		prime[i] = 1;
	for (int i = 2; i < 1000001; i++)
		if (prime[i])
			for (int j = i * 2; j < 1000001; j += i)
				prime[j] = 0;
	for (int i = 2; i * 2 < 1000001; i++)
		if (prime[i])
			semi[i * 2] = 1;
	prime[2] = 0;
	convolution(prime, semi, ans);
	scanf("%d", &t);
	while (t--)
	{
		scanf("%d", &n);
		printf("%d\n", ans[n]);
	}
	return 0;
}
