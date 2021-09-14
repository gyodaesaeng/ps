#include <stdio.h>
bool in[50][50];
int m, n;
void bfs(int x, int y)
{
	if (!in[x][y] || x < 0 || x >= m || y < 0 || y >= n)
		return;
	in[x][y] = false;
	bfs(x - 1, y);
	bfs(x + 1, y);
	bfs(x, y - 1);
	bfs(x, y + 1);
}
int main()
{
	int t;
	scanf("%d", &t);
	while (t--)
	{
		for (int i = 0; i < 50; i++)
			for (int j = 0; j < 50; j++)
				in[i][j] = false;
		scanf("%d %d", &m, &n);
		int k;
		scanf("%d", &k);
		for (int i = 0; i < k; i++)
		{
			int x, y;
			scanf("%d %d", &x, &y);
			in[x][y] = true;
		}
		int cnt = 0;
		for (int i = 0; i < m; i++)
		{
			for (int j = 0; j < n; j++)
			{
				if (in[i][j])
				{
					cnt++;
					bfs(i, j);
				}
			}
		}
		printf("%d\n", cnt);
	}
}
