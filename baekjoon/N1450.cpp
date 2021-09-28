#define _USE_MATH_DEFINES
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
	int n, m;
	scanf("%d", &n);
	vector<int> a(200001, 0), c;
	a[0] = 1;
	for (int i = 0; i < n; i++)
	{
		int in;
		scanf("%d", &in);
		a[in] = 1;
	}
	convolution(a, a, c);
	scanf("%d", &m);
	int cnt = 0;
	for (int i = 0; i < m; i++)
	{
		int in;
		scanf("%d", &in);
		if (c[in])
			cnt++;
	}
	printf("%d", cnt);
	return 0;
}
