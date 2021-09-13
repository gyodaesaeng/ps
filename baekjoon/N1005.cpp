#include <stdio.h>
#include <vector>
using namespace std;
int d[1001], memo[1001];
vector<int> seq[1001];
int dp(int w)
{
	if (memo[w] > -1)
		return memo[w];
	if (seq[w].size() == 0)
		return memo[w] = d[w];
	memo[w] = -1;
	for (int i = 0; i < seq[w].size(); i++)
		memo[w] = memo[w] > d[w] + dp(seq[w][i]) ? memo[w] : d[w] + dp(seq[w][i]);
	return memo[w];
}
int main()
{
	int t;
	scanf("%d", &t);
	while (t--)
	{
		int n, k;
		scanf("%d %d", &n, &k);
		for (int i = 1; i <= n; i++)
		{
			scanf("%d", &d[i]);
			memo[i] = -1;
			seq[i].clear();
		}
		int x, y;
		for (int i = 0; i < k; i++)
		{
			scanf("%d %d", &x, &y);
			seq[y].push_back(x);
		}
		int w;
		scanf("%d", &w);
		printf("%d\n", dp(w));
	}
}
