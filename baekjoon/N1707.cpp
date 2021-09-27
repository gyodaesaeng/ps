#include <bits/stdc++.h>
using namespace std;
bool isBi(int v, vector<int> graph[])
{
	int visit[v + 1];
	memset(visit, 0, sizeof(visit));
	stack<int> s;
	for (int i = 1; i <= v; i++)
	{
		if (visit[i])
			continue;
		s.push(i);
		visit[i] = 1;
		while (!s.empty())
		{
			int now = s.top();
			s.pop();
			for (int j : graph[now])
			{
				if (visit[j])
				{
					if (visit[j] == visit[now])
						return false;
				}
				else
				{
					visit[j] = 3 - visit[now];
					s.push(j);
				}
			}
		}
	}
	return true;
}
int main()
{
	int k;
	scanf("%d", &k);
	while (k--)
	{
		int v, e;
		scanf("%d%d", &v, &e);
		vector<int> graph[v + 1];
		for (int i = 0; i < e; i++)
		{
			int u, v;
			scanf("%d%d", &u, &v);
			graph[u].push_back(v);
			graph[v].push_back(u);
		}
		if (isBi(v, graph))
			printf("YES\n");
		else
			printf("NO\n");
	}
	return 0;
}
