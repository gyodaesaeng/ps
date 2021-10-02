#include <bits/stdc++.h>
using namespace std;
char in[1000001];
int fail[1000001];
int main()
{
	while (true)
	{
		scanf("%s", in);
		if (in[0] == '.')
			return 0;
		memset(fail, 0, sizeof(fail));
		int l = strlen(in);
		for (int i = 1, j = 0; i < l; i++)
		{
			while (j && in[i] != in[j])
				j = fail[j - 1];
			if (in[i] == in[j])
				fail[i] = ++j;
		}
		if (l % (l - fail[l - 1]))
			printf("1\n");
		else
			printf("%d\n", l / (l - fail[l - 1]));
	}
	return 0;
}
