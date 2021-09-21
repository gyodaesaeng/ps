#define _USE_MATH_DEFINES
#include <math.h>
#include <complex>
#include <vector>
#include <algorithm>
using namespace std;

#define sz(v) ((int)(v).size())
#define all(v) (v).begin(), (v).end()
typedef complex<double> base;

void fft(vector<base> &a, bool invert)
{
	int n = sz(a);
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
	vector<base> fa(all(a)), fb(all(b));
	int n = 1;
	while (n < max(sz(a), sz(b)))
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
	int n, l, m;
	long long w;
	scanf("%d%d%d%lld", &n, &l, &m, &w);
	vector<int> sky[m], telescope[m];
	for (int i = 0; i < m; i++)
	{
		sky[i].resize(n);
		for (int j = 0; j < n; j++)
			scanf("%d", &sky[i][j]);
	}
	for (int i = 0; i < m; i++)
	{
		telescope[i].resize(l);
		for (int j = l - 1; j >= 0; j--)
			scanf("%d", &telescope[i][j]);
	}
	int cnt = 0;
	vector<int> c[m];
	for (int i = 0; i < m; i++)
		convolution(sky[i], telescope[i], c[i]);
	for (int i = 0; i + l <= n; i++)
	{
		long long sum = 0;
		for (int j = 0; j < m; j++)
			sum += c[j][i + l - 1];
		if (sum > w)
			cnt++;
	}
	printf("%d", cnt);
}
