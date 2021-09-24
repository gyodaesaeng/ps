#include <cstdio>
#include <vector>
#include <algorithm>
using namespace std;
int main()
{
	int in[1000000];
	vector<int> v;
	int n;
	scanf("%d", &n);
	for (int i = 0; i < n; i++)
	{
		scanf("%d", &in[i]);
		v.push_back(in[i]);
	}
	sort(v.begin(), v.end());
	v.erase(unique(v.begin(), v.end()), v.end());
	for (int i = 0; i < n; i++)
		printf("%ld ", lower_bound(v.begin(), v.end(), in[i]) - v.begin());
}
