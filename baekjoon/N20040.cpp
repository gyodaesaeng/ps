#include <bits/stdc++.h>
using namespace std;
int n, m, in[2], u[500000];
int uf(int a)
{
	if (u[u[a]] == u[a])
		return u[a];
	return u[a] = uf(u[a]);
}
int main()
{
	scanf("%d%d", &n, &m);
	for (int i = 0; i < 500000; i++)
		u[i] = i;
	for (int i = 0; i < m; i++)
	{
		scanf("%d%d", &in[0], &in[1]);
		if (uf(in[0]) == uf(in[1]))
		{
			printf("%d", i + 1);
			return 0;
		}
		u[uf(in[0])] = uf(in[1]);
	}
	printf("0");
	return 0;
}
