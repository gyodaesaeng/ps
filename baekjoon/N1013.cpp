#include <stdio.h>

bool isPattern(char *in)
{
	if (!in[0])
		return true;
	if (in[0] == '1')
	{
		if (in[1] != '0' || in[2] != '0')
			return false;
		int i = 3;
		while (in[i] == '0')
			i++;
		if (!in[i])
			return false;
		while (in[i] == '1')
			i++;
		if (!in[i])
			return true;
		if (!in[i + 1])
			return false;
		if (in[i + 1] == '1')
			return isPattern(in + i + 2);
		if (in[i - 2] == '1')
			return isPattern(in + i - 1);
		return false;
	}
	else
	{
		if (in[1] == '1')
			return isPattern(in + 2);
		return false;
	}
}

int main()
{
	int t;
	scanf("%d", &t);
	while (t--)
	{
		char in[200];
		scanf("%s", in);
		printf(isPattern(in) ? "YES\n" : "NO\n");
	}
}
