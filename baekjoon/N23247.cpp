#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
int m, n;
ll in[301][301];
int main()
{
	scanf("%d%d", &m, &n);
	memset(in[0], 0, sizeof(in[0]));
	for (int i = 1; i <= m; i++)
	{
		in[i][0] = 0;
		for (int j = 1; j <= n; j++)
			scanf("%d", &in[i][j]);
	}
	for (int i = 1; i <= m; i++)
		for (int j = 1; j <= n; j++)
			in[i][j] += in[i][j - 1];
	for (int i = 1; i <= m; i++)
		for (int j = 1; j <= n; j++)
			in[i][j] += in[i - 1][j];
	int cnt = 0;
	for (int i = 0; i <= m; i++)
	{
		for (int j = 0; j <= n; j++)
		{
			for (int k = i; k <= m; k++)
			{
				for (int l = j; l <= n; l++)
				{
					if (in[k][l] - in[k][j] - in[i][l] + in[i][j] == 10)
						cnt++;
					if (in[k][l] - in[k][j] - in[i][l] + in[i][j] > 9)
						break;
				}
			}
		}
	}
	printf("%d", cnt);
	return 0;
}
