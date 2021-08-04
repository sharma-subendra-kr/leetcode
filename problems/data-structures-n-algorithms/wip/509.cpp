// 509. Fibonacci Number
// https://leetcode.com/problems/fibonacci-number/

#include <bits/stdc++.h>
#include <deque>
#include <iostream>
#include <vector>
#include <utility>
#include <cstdlib>
#include <math.h>

using namespace std;

// int fibonacci(int n, unordered_map<int, int> &mp) {
// 	if (n == 0 || n == 1) {
// 		return n;
// 	}

// 	if (!mp[n - 1]) {
// 		mp[n - 1] = fibonacci(n - 1, mp);
// 	}
// 	if (!mp[n - 2]) {
// 		mp[n - 2] = fibonacci(n - 2, mp);
// 	}

// 	mp[n] = mp[n - 1] + mp[n - 2];

// 	return mp[n];
// }

// int fib(int n) {
// 	//
// 	unordered_map<int, int> mp;
// 	return fibonacci(n, mp);
// }

int fib(int n) {
	if (n == 0 || n == 1) {
		return n;
	}

	int n1 = 1;
	int n2 = 0;
	int sum = 0;
	for (int i = 2; i <= n; i++) {
		sum = n1 + n2;
		n2 = n1;
		n1 = sum;
	}
	return sum;
}

int main() {
	//
	int n;

	n = 5;

	int res = fib(n);

	cout << res << endl;

	return 0;
}