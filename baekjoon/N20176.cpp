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
	while (n < a.size() + b.size())
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
	vector<int> in[3];
	for (int i = 0; i < 3; i++)
	{
		int n;
		scanf("%d", &n);
		in[i].resize(60001);
		for (int j = 0; j < 60001; j++)
			in[i][j] = 0;
		int m;
		for (int j = 0; j < n; j++)
		{
			scanf("%d", &m);
			in[i][m + 30000] = 1;
		}
	}
	vector<int> c;
	convolution(in[0], in[2], c);
	int ans = 0;
	for (int i = 0; i < 60001; i++)
		if (in[1][i])
			ans += c[i * 2];
	printf("%d", ans);
	return 0;
}
