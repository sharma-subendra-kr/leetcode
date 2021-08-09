// 453. Minimum Moves to Equal Array Elements
// https://leetcode.com/problems/minimum-moves-to-equal-array-elements/

#include <bits/stdc++.h>
#include <deque>
#include <iostream>
#include <vector>
#include <utility>
#include <cstdlib>
#include <string>

using namespace std;

int minMoves(vector<int> &nums) {
	int sum = 0;
	int min = INT_MAX;
	for (int i = 0; i < nums.size(); i++) {
		sum += nums[i];
		if (nums[i] < min) {
			min = nums[i];
		}
	}

	return sum - min * nums.size();
}

int main() {
	vector<int> nums;

	nums = {1, 2, 3};
	// nums = {0, 0, 0};
	// nums = {1, 2};
	nums = {1, 2, 3, 4};

	int res = minMoves(nums);

	cout << res << endl;

	return 0;
}