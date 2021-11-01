#include <bits/stdc++.h>
using namespace std;
int n;
pair<int, int> line[1000000];
int main()
{
	scanf("%d", &n);
	for (int i = 0; i < n; i++)
		scanf("%d %d", &line[i].first, &line[i].second);
	sort(line, line + n);
	int last = line[0].first;
	int ans = 0;
	for (int i = 0; i < n; i++)
	{
		last = max(last, line[i].first);
		if (last < line[i].second)
		{
			ans += line[i].second - last;
			last = line[i].second;
		}
	}
	printf("%d", ans);
	return 0;
}
