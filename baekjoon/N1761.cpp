#include <stdio.h>
#include <vector>
#include <queue>
using namespace std;
int n;
long long len[40001][17][2];
int depth[40001];
vector<pair<int, int> > tree[40001];
int log(int m)
{
	int pow = 1;
	int i;
	for (i = 0; pow <= m; i++)
		pow *= 2;
	return i - 1;
}

int main()
{
	scanf("%d", &n);
	for (int i = 1; i < n; i++)
	{
		int in[3];
		for (int j = 0; j < 3; j++)
			scanf("%d", &in[j]);
		tree[in[0]].push_back(make_pair(in[1], in[2]));
		tree[in[1]].push_back(make_pair(in[0], in[2]));
		depth[i + 1] = -1;
	}
	queue<int> q;
	q.push(1);
	depth[0] = -1;
	depth[1] = 0;
	for (int i = 1; i <= 40000; i++)
		for (int j = 0; j < 17; j++)
			len[i][j][1] = -1;
	len[1][0][0] = len[1][0][1] = 0;
	while (!q.empty())
	{
		int peek = q.front();
		q.pop();
		for (int i = 0; i < tree[peek].size(); i++)
		{
			int now = tree[peek][i].first;
			if (depth[now] > -1)
				continue;
			depth[now] = depth[peek] + 1;
			len[now][0][0] = tree[peek][i].second;
			len[now][0][1] = peek;
			for (int j = 1; len[now][j - 1][1] > 0; j++)
			{
				len[now][j][0] = len[len[now][j - 1][1]][j - 1][0] + len[now][j - 1][0];
				len[now][j][1] = len[len[now][j - 1][1]][j - 1][1];
			}
			q.push(now);
		}
	}
	int m;
	scanf("%d", &m);
	for (int i = 0; i < m; i++)
	{
		int a, b;
		scanf("%d %d", &a, &b);
		long long ans = 0;
		if (depth[b] > depth[a])
			swap(a, b);
		while (depth[a] > depth[b])
		{
			int temp = log(depth[a] - depth[b]);
			ans += len[a][temp][0];
			a = len[a][temp][1];
		}
		while (a != b)
		{
			int j = 1;
			while (len[a][j][1] != len[b][j][1])
				j++;
			ans += len[a][j - 1][0] + len[b][j - 1][0];
			a = len[a][j - 1][1];
			b = len[b][j - 1][1];
		}
		printf("%lld\n", ans);
	}
}
