// 1480. Running Sum of 1d Array
// https://leetcode.com/problems/running-sum-of-1d-array/

#include <bits/stdc++.h>
#include <deque>
#include <iostream>
#include <vector>
#include <utility>
#include <cstdlib>
#include <math.h>

using namespace std;

// vector<int> runningSum(vector<int> &nums) {
// 	//
// 	vector<int> res;
// 	for (int i = 0; i < nums.size(); i++) {
// 		int prev = 0;
// 		int curr = nums[i];
// 		if (i - 1 >= 0) {
// 			prev = res[i - 1];
// 		}
// 		res.push_back(prev + curr);
// 	}

// 	return res;
// }

vector<int> runningSum(vector<int> &nums) {
	//
	for (int i = 0; i < nums.size(); i++) {
		int prev = 0;
		int curr = nums[i];
		if (i - 1 >= 0) {
			prev = nums[i - 1];
		}
		nums[i] = prev + curr;
	}

	return nums;
}

int main() {
	//
	vector<int> nums;

	nums = {1, 2, 3, 4};

	vector<int> res = runningSum(nums);

	for (int i : res) {
		cout << i << endl;
	}

	return 0;
}