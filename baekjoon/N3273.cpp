#include <bits/stdc++.h>
using namespace std;
int main()
{
	vector<int> in;
	int n;
	scanf("%d", &n);
	in.resize(n);
	for (int i = 0; i < n; i++)
		scanf("%d", &in[i]);
	int x;
	scanf("%d", &x);
	sort(in.begin(), in.end());
	auto it1 = in.begin();
	auto it2 = in.end() - 1;
	int cnt = 0;
	while (it1 != it2)
	{
		if ((*it1) + (*it2) == x)
		{
			cnt++;
			it1++;
			continue;
		}
		if ((*it1) + (*it2) < x)
			it1++;
		else
			it2--;
	}
	printf("%d", cnt);
	return 0;
}
