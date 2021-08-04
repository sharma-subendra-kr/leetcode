// 22. Generate Parentheses
// https://leetcode.com/problems/generate-parentheses/

#include <bits/stdc++.h>
#include <iostream>
#include <list>
#include <queue>
#include <string>
#include <vector>

using namespace std;

vector<string> copyStrs(const string &str, vector<string> &arr) {
	vector<string> res(arr.size());
	int i;

	for (i = 0; i < arr.size(); i++) {
		res[i] = str + arr[i];
	}

	return res;
}

vector<string> generate(int left, int right) {
	if (right == 0) {
		vector<string> arr(1);
		arr[0] = string(")");
		return arr;
	}

	vector<string> s1, s2;

	if (left <= right && left != 0) {
		string curr;
		curr.append(string("("));
		s1 = generate(left - 1, right);
		s1 = copyStrs(curr, s1);
	}
	if (right > left) {
		string curr;
		curr.append(string(")"));
		s2 = generate(left, right - 1);
		s2 = copyStrs(curr, s2);
	}

	vector<string> res;
	res.reserve(s1.size() + s2.size());
	res.insert(res.end(), s2.begin(), s2.end());
	res.insert(res.end(), s2.begin(), s2.end());

	return res;
}

vector<string> generateParenthesis(int n) {
	int left = n, right = n;
	vector<string> res;

	if (n == 0) {
		return res;
	}

	return generate(left, right);
}

int main() {
	int n, i;

	cin >> n;

	vector<string> strs = generateParenthesis(n);

	for (i = 0; i < n; i++) {
		cout << strs[i];
	}
}