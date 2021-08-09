// 937. Reorder Data in Log Files
// https://leetcode.com/problems/reorder-data-in-log-files/

#include <bits/stdc++.h>
#include <deque>
#include <iostream>
#include <vector>
#include <utility>
#include <cstdlib>
#include <locale>

using namespace std;

#include "../../../utils/customString.h"

// overall correct soln but does't work in c++ cuz of nature of sort function

int getWeight(char c) {
	int a;

	if (c > 57) {
		a = c - 'a' + 11;
	} else if (c >= 48) {
		a = c - '0' + 1;
	} else {
		a = 0;
	}

	return a;
}

bool isDigit(char c) {
	if (c >= 48 && c <= 57) {
		return true;
	}
	return false;
}

bool isChar(char c) {
	if (c >= 97 && c < 123) {
		return true;
	}
	return false;
}

// bool comp(string &a, string &b) {
// 	if (isDigit(a[a.size() - 1]) && isChar(b[b.size() - 1])) {
// 		return false;
// 	} else if (isChar(a[a.size() - 1]) && isDigit(b[b.size() - 1])) {
// 		return true;
// 	} else if (isDigit(a[a.size() - 1]) && isDigit(b[b.size() - 1])) {
// 		return false;
// 	}

// 	int ia = 0;
// 	int ib = 0;

// 	while (ia < a.size() && a[ia] != ' ') {
// 		ia++;
// 	}

// 	while (ib < b.size() && b[ib] != ' ') {
// 		ib++;
// 	}

// 	while (ia < a.size() && ib < b.size() && a[ia] == b[ib]) {
// 		ia++;
// 		ib++;
// 	}

// 	if (ia < a.size() && ib < b.size()) {
// 		return getWeight(a[ia]) < getWeight(b[ib]);
// 	} else if (ia == a.size() && ib < b.size()) {
// 		return true;
// 	} else if (ib == b.size() && ia < a.size()) {
// 		return false;
// 	}
// 	ia = 0;
// 	ib = 0;
// 	while (a[ia] != ' ' && b[ib] != ' ' && a[ia] == b[ib]) {
// 		ia++;
// 		ib++;
// 	}
// 	return getWeight(a[ia]) < getWeight(b[ib]);
// }

bool comp(string &a, string &b) {
	// if (isDigit(a[a.size() - 1])) {
	// 	return false;
	// } else if (isDigit(b[b.size() - 1])) {
	// 	return true;
	// }
	if (isDigit(a[a.size() - 1]) && isChar(b[b.size() - 1])) {
		return false;
	} else if (isChar(a[a.size() - 1]) && isDigit(b[b.size() - 1])) {
		return true;
	} else if (isDigit(a[a.size() - 1]) && isDigit(b[b.size() - 1])) {
		return false;
	}

	int ia = 0;
	int ib = 0;

	while (ia < a.size() && a[ia] != ' ') {
		ia++;
	}

	while (ib < b.size() && b[ib] != ' ') {
		ib++;
	}

	while (ia < a.size() && ib < b.size() && a[ia] == b[ib]) {
		ia++;
		ib++;
	}

	if (ia < a.size() && ib < b.size()) {
		return getWeight(a[ia]) <= getWeight(b[ib]);
	} else if (ia == a.size() && ib < b.size()) {
		return true;
	} else if (ib == b.size() && ia < a.size()) {
		return false;
	}
	ia = 0;
	ib = 0;
	while (a[ia] != ' ' && b[ib] != ' ' && a[ia] == b[ib]) {
		ia++;
		ib++;
	}
	return getWeight(a[ia]) <= getWeight(b[ib]);
}

vector<string> reorderLogFiles(vector<string> &logs) {
	//

	sort(logs.begin(), logs.end(), comp);

	return logs;
}

int main() {
	//

	vector<string> logs;

	logs = {"dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig",
					"let3 art zero"};

	vector<string> res = reorderLogFiles(logs);

	for (int i = 0; i < res.size(); i++) {
		cout << res[i] << ", ";
	}
	cout << endl;

	return 0;
}