
#include <bits/stdc++.h>
using namespace std;
struct Trie
{
	Trie *go[26];
	int cnt;
	bool isLast;
	Trie()
	{
		cnt = 0;
		isLast = false;
		for (int i = 0; i < 26; i++)
			go[i] = NULL;
	}
	~Trie()
	{
		for (int i = 0; i < 26; i++)
			if (go[i])
				delete go[i];
	}
	void insert(const char *key)
	{
		if (*key == '\0')
			isLast = true;
		else
		{
			int next = *key - 'a';
			if (!go[next])
			{
				go[next] = new Trie();
				cnt++;
			}
			go[next]->insert(key + 1);
		}
	}
	int query(const char *key, int ret)
	{
		if (*key == '\0')
			return ret;
		else
		{
			if (cnt > 1 || isLast)
				ret++;
			int next = *key - 'a';
			return go[next]->query(key + 1, ret);
		}
	}
};

char in[100001][81];
int n;
int main()
{
	while (scanf("%d", &n) != EOF)
	{
		Trie trie;
		for (int i = 0; i < n; i++)
		{
			scanf("%s", in[i]);
			trie.insert(in[i]);
		}
		int cnt = 0;
		if (trie.cnt == 1)
			cnt += n;
		for (int i = 0; i < n; i++)
			cnt += trie.query(in[i], 0);
		printf("%.2lf\n", (double)cnt / n);
	}
	return 0;
}
