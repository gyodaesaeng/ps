#include <bits/stdc++.h>
using namespace std;
int n, in[500001][2];
int main()
{
	scanf("%d", &n);
	for (int i = 0; i <= n; i++)
		scanf("%d%d", &in[i][0], &in[i][1]);
	bool left, right, up, down;
	left = right = up = down = false;
	for (int i = 0; i < n; i++)
	{
		if (in[i][0] < in[n][0] && abs(in[i][1] - in[n][1]) <= in[n][0] - in[i][0])
			left = true;
		if (in[i][0] > in[n][0] && abs(in[i][1] - in[n][1]) <= in[i][0] - in[n][0])
			right = true;
		if (in[i][1] < in[n][1] && abs(in[i][0] - in[n][0]) <= in[n][1] - in[i][1])
			down = true;
		if (in[i][1] > in[n][1] && abs(in[i][0] - in[n][0]) <= in[i][1] - in[n][1])
			up = true;
	}
	printf(left && right && up && down ? "NO" : "YES");
	return 0;
}
