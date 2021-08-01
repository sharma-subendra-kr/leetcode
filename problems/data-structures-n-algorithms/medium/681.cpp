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

// int getSeconds(string time) {
// 	vector<string> data;
// 	if (time.size() == 5) {
// 		data = split(time, ':');
// 	} else {
// 		data.push_back(time.substr(0, 2));
// 		data.push_back(time.substr(2, 2));
// 	}

// 	int seconds = 0;
// 	seconds += stoi(data[0]) * 60 * 60;
// 	seconds += stoi(data[1]) * 60;

// 	return seconds;
// }

// void swap(int i, int j, string &str) {
// 	char temp = str[j];
// 	str[j] = str[i];
// 	str[i] = temp;
// }

// void getPermutations(string str, int index, vector<int> &res) {
// 	if (index == str.size() - 1) {
// 		int seconds = getSeconds(str);
// 		if (seconds <= 86340) {
// 			res.push_back(seconds);
// 		}
// 		return;
// 	}

// 	for (int i = index; i < str.size(); i++) {
// 		swap(index, i, str);
// 		getPermutations(str, index + 1, res);
// 		swap(i, index, str);
// 	}
// }

// string nextClosestTime(string time) {
// 	int seconds = getSeconds(time);
// 	vector<string> _time = split(time, ':');

// 	string input = accumulate(_time.begin(), _time.end(), string(""));
// 	vector<int> times;
// 	getPermutations(input, 0, times);

// 	sort(times.begin(), times.end());

// 	for (int i = 0; i < times.size(); i++) {
// 		if (times[i] > seconds) {
// 		}
// 	}

// 	return time;
// }

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

string nextClosestTime(string time) {
	unordered_set<string> st;

	st.insert(string(1, time[0]));
	st.insert(string(1, time[1]));
	st.insert(string(1, time[3]));
	st.insert(string(1, time[4]));

	int min = INT_MAX;
	string res = "";
	int _time = getTime(time);

	for (int i = 0; i < 24; i++) {
		for (int j = 0; j < 60; j++) {
			string m1 = to_string(j % 10);
			string m2 = to_string(j / 10);
			string h1 = to_string(i % 10);
			string h2 = to_string(i / 10);

			if (st.find(m1) != st.end() && st.find(m2) != st.end() &&
					st.find(h1) != st.end() && st.find(h2) != st.end()) {
				int diff = _time - (i * 60 + j);
				if (diff == 0) {
					continue;
				}
				if (diff > 0) {
					diff = 1440 - diff;
				} else {
					diff = -diff;
				}

				if (diff < min) {
					min = diff;
					res = formatTime(i, j);
				}
			}
		}
	}
	return res != "" ? res : time;
}

int main() {
	//

	string time;

	// time = "19:34";
	// time = "23:59";
	// time = "01:32";
	// time = "00:00";
	time = "01:11";

	string res = nextClosestTime(time);

	cout << res << endl;

	return 0;
}