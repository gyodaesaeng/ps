#define _USE_MATH_DEFINES
#include <math.h>
#include <complex>
#include <vector>
#include <algorithm>
#include <cstring>
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
	vector<int> v[2];
	for (int i = 0; i < 2; i++)
	{
		char in[300000];
		scanf("%s", in);
		if (in[0] == '0')
		{
			printf("0");
			return 0;
		}
		int len = strlen(in);
		v[i].resize(len);
		for (int j = 0; j < len; j++)
			v[i][len - 1 - j] = in[j] - '0';
	}
	vector<int> c;
	convolution(v[0], v[1], c);
	int carry = 0;
	for (int i = 0; i < c.size(); i++)
	{
		c[i] += carry;
		carry = c[i] / 10;
		c[i] %= 10;
	}
	while (carry)
	{
		c.push_back(carry % 10);
		carry /= 10;
	}
	long long i = c.size() - 1;
	while (!c[i])
		i--;
	while (i >= 0)
		printf("%c", c[i--] + '0');
	return 0;
}
