// 681. Next Closest Time
// https://leetcode.com/problems/next-closest-time/

#include <bits/stdc++.h>
#include <deque>
#include <iostream>
#include <vector>
#include <utility>
#include <cstdlib>
#include <string>

using namespace std;

#include "../../../utils/customString.h"

int getTime(string time) {
	int m1 = (int)time[4] - 48;
	int m2 = (int)time[3] - 48;
	int h1 = (int)time[1] - 48;
	int h2 = (int)time[0] - 48;

	return h2 * 10 * 60 + h1 * 60 + m2 * 10 + m1;
}

string formatTime(int h, int m) {
	string _h = h >= 10 ? to_string(h) : "0" + to_string(h);
	string _m = m >= 10 ? to_string(m) : "0" + to_string(m);

	return _h + ":" + _m;
}

// string nextClosestTime(string time) {
// 	unordered_set<string> st;

// 	st.insert(string(1, time[0]));
// 	st.insert(string(1, time[1]));
// 	st.insert(string(1, time[3]));
// 	st.insert(string(1, time[4]));

// 	int min = INT_MAX;
// 	string res = "";
// 	int _time = getTime(time);

// 	for (int i = 0; i < 24; i++) {
// 		for (int j = 0; j < 60; j++) {
// 			string m1 = to_string(j % 10);
// 			string m2 = to_string(j / 10);
// 			string h1 = to_string(i % 10);
// 			string h2 = to_string(i / 10);

// 			if (st.find(m1) != st.end() && st.find(m2) != st.end() &&
// 					st.find(h1) != st.end() && st.find(h2) != st.end()) {
// 				int diff = _time - (i * 60 + j);
// 				if (diff == 0) {
// 					continue;
// 				}
// 				if (diff > 0) {
// 					diff = 1440 - diff;
// 				} else {
// 					diff = -diff;
// 				}

// 				if (diff < min) {
// 					min = diff;
// 					res = formatTime(i, j);
// 				}
// 			}
// 		}
// 	}
// 	return res != "" ? res : time;
// }

int increaseMinute(vector<int> arr, int num) {}

int increaseHour() {}

int decreaseMinute() {}

int decreaseHour() {}

string nextClosestTime(string time) {
	vector<int> st;
	vector<int> arr;

	st.push_back(time[0] - '0');
	st.push_back(time[1] - '0');
	st.push_back(time[3] - '0');
	st.push_back(time[4] - '0');

	arr.push_back(time[0] - '0');
	arr.push_back(time[1] - '0');
	arr.push_back(time[3] - '0');
	arr.push_back(time[4] - '0');

	sort(arr.begin(), arr.end());
}

int main() {
	//

	string time;

	time = "19:34";
	// time = "23:59";
	// time = "01:32";
	// time = "00:00";
	// time = "01:11";

	string res = nextClosestTime(time);

	cout << res << endl;

	return 0;
}