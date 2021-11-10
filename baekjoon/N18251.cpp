#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
const int MAX_N = 262144;
int n, cnt, depth[MAX_N], tree[MAX_N], in[MAX_N];

void inOrder(int i, int d)
{
	if (i * 2 <= n)
		inOrder(i * 2, d + 1);
	depth[0] = depth[++cnt] = d;
	tree[cnt] = in[i];
	if (i * 2 + 1 <= n)
		inOrder(i * 2 + 1, d + 1);
}

int main()
{
	scanf("%d", &n);
	for (int i = 1; i <= n; i++)
		scanf("%d", &in[i]);
	cnt = 0;
	inOrder(1, 1);
	ll ans = -1000000001;
	for (int i = 1; i <= depth[0]; i++)
		for (int j = i; j <= depth[0]; j++)
		{
			ll sum = 0;
			for (int k = 1; k <= n; k++)
			{
				if (depth[k] < i || depth[k] > j)
					continue;
				sum += tree[k];
				ans = max(ans, sum);
				if (sum < 0)
					sum = 0;
			}
		}
	printf("%lld", ans);
}
