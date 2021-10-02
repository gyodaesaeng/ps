#include <bits/stdc++.h>
using namespace std;
int main()
{
	while (true)
	{
		char s[6];
		scanf("%s", s);
		if (s[0] == '0')
			return 0;
		bool isP = true;
		for (int i = 0; i < strlen(s); i++)
		{
			if (s[i] != s[strlen(s) - i - 1])
			{
				isP = false;
				break;
			}
		}
		if (isP)
			printf("yes\n");
		else
			printf("no\n");
	}
	return 0;
}
