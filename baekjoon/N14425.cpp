#include <bits/stdc++.h>
using namespace std;
map<string, bool> s;
char in[501];
int n, m;
int main()
{
	scanf("%d%d", &n, &m);
	while (n--)
	{
		scanf("%s", in);
		string str(in);
		s.insert(make_pair(str, true));
	}
	int ans = 0;
	while (m--)
	{
		scanf("%s", in);
		string str(in);
		if (s.find(str) != s.end())
			ans++;
	}
	printf("%d", ans);
	return 0;
}
