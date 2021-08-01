// 843. Guess the Word
// https://leetcode.com/problems/guess-the-word/

#include <bits/stdc++.h>
#include <deque>
#include <iostream>
#include <vector>
#include <utility>
#include <cstdlib>
#include <locale>

using namespace std;

// Doesnt work
// static bool compare(string a, string b) {
// 	string _a, _b;
// 	if (a.size() < b.size()) {
// 		_a = a;
// 		_b = b;
// 	} else {
// 		_a = b;
// 		_b = a;
// 	}

// 	for (int i = 0; i < _a.size(); i++) {
// 		if ((int)_a[i] == (int)_b[i]) {
// 			continue;
// 		}
// 		return ((int)_a[i] > (int)_b[i]);
// 	}
// 	return a.size() > b.size();
// }

// void findSecretWord(vector<string> &wordlist, Master &master) {
// 	sort(wordlist.begin(), wordlist.end(), compare);

// 	int low = 0, high = wordlist.size() - 1, mid;
// 	int left = master.guess(wordlist[low]);
// 	int right = master.guess(wordlist[high]);

// 	int count = 0;
// 	while (low < high && count < 10) {
// 		mid = (high + low) / 2;
// 		int g = master.guess(wordlist[mid]);
// 		if (abs(left - g) < abs(right - g)) {
// 			high = mid - 1;
// 		} else {
// 			low = mid + 1;
// 		}
// 		count++;
// 	}

// 	for (int i = 0; i < wordlist.size(); i++) {
// 		cout << i << endl;
// 		cout << wordlist[i] << endl;
// 	}
// }

int getMatch(string w, string m) {
	int match = 0;
	for (int i = 0; i < 6; i++) {
		if (w[i] == m[i]) {
			match++;
		}
	}
	return match;
}

void findSecretWord(vector<string> &wordlist, Master &master) {
	srand(time(0));
	int count = 0;
	while (count < 10) {
		int r = rand() % (long)wordlist.size();
		int g = master.guess(wordlist[r]);

		vector<string> _wordlist;
		for (string s : wordlist) {
			if (getMatch(s, wordlist[r]) == g) {
				_wordlist.push_back(s);
			}
		}
		wordlist = _wordlist;
		count++;
	}
}
