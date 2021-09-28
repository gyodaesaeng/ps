#include <bits/stdc++.h>
using namespace std;
int main()
{
	int n;
	scanf("%d", &n);
	vector<int> in;
	in.resize(n);
	for (int i = 0; i < n; i++)
		scanf("%d", &in[i]);
	sort(in.begin(), in.end());
	int i = 0;
	int j = in.size() - 1;
	int minI = i;
	int minJ = j;
	while (i < j)
	{
		if (abs(in[minI] + in[minJ]) > abs(in[i] + in[j]))
		{
			minI = i;
			minJ = j;
		}
		if (in[i] + in[j] > 0)
			j--;
		else
			i++;
	}
	printf("%d %d", in[minI], in[minJ]);
	return 0;
}
