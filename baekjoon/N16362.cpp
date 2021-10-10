#include <bits/stdc++.h>
using namespace std;
bool isProper;
char in[1001];
void err()
{
	printf("error");
	exit(0);
}
char *p(char *s)
{
	if (!*s)
		err();
	int cnt = 0;
	bool isOper = true;
	while (*s && *s != ')')
	{
		if (!isOper)
			err();
		if (!isalpha(*s))
		{
			if (*s != '(')
				err();
			s = p(s + 1);
			if (*s != ')')
				err();
		}
		s++;
		cnt++;
		if (*s && strchr("+-*/%", *s))
		{
			isOper = true;
			s++;
		}
		else
			isOper = false;
	}
	if (isOper)
		err();
	if (cnt != 2)
		isProper = false;
	return s;
}

int main()
{
	scanf("%[^\n]", in);
	int cnt = 0, l = strlen(in);
	for (int i = 0; i <= l; i++)
	{
		in[i - cnt] = in[i];
		if (in[i] == ' ')
			cnt++;
	}
	isProper = true;
	if (*p(in) == ')')
		err();
	printf(isProper ? "proper" : "improper");
	return 0;
}
