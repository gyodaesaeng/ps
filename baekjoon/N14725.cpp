#include <stdio.h>
#include <vector>
#include <string>
#include <algorithm>
using namespace std;
class Trie
{
public:
	vector<Trie *> next;
	string s;
	~Trie()
	{
		for (int i = 0; i < next.size(); i++)
			delete next[i];
	}
};

void insertTrie(Trie *t, int len, string *s)
{
	if (!len)
		return;
	for (int i = 0; i < t->next.size(); i++)
	{
		if (t->next[i]->s == s[0])
		{
			insertTrie(t->next[i], len - 1, s + 1);
			return;
		}
	}
	t->next.push_back(new Trie());
	t->next.back()->s = s[0];
	insertTrie(t->next.back(), len - 1, s + 1);
}
bool compare(Trie *a, Trie *b)
{
	return a->s < b->s;
}
void printTrie(int depth, Trie *t)
{
	sort(t->next.begin(), t->next.end(), compare);
	for (int i = 0; i < t->next.size(); i++)
	{
		for (int j = 0; j < depth; j++)
			printf("--");
		printf("%s\n", t->next[i]->s.c_str());
		printTrie(depth + 1, t->next[i]);
	}
}
int main()
{
	int n;
	scanf("%d", &n);
	Trie t;
	for (int i = 0; i < n; i++)
	{
		int k;
		scanf("%d", &k);
		string in[15];
		for (int j = 0; j < k; j++)
		{
			char temp[15];
			scanf("%s", temp);
			in[j] = temp;
		}
		insertTrie(&t, k, in);
	}
	printTrie(0, &t);
	return 0;
}
