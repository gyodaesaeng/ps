#include <stdio.h>
#include <math.h>

int main()
{
	int t;
	scanf("%d", &t);
	int in[6];
	while (t--)
	{
		for (int i = 0; i < 6; i++)
			scanf("%d", &in[i]);
		int d = pow(in[0] - in[3], 2) + pow(in[1] - in[4], 2);
		if (in[0] == in[3] && in[1] == in[4] && in[2] == in[5])
			printf("-1\n");
		else if (d < pow(in[2] - in[5], 2) || d > pow(in[2] + in[5], 2))
			printf("0\n");
		else if (d == pow(in[2] - in[5], 2) || d == pow(in[2] + in[5], 2))
			printf("1\n");
		else
			printf("2\n");
	}
	return 0;
}
