// 501. Find Mode in Binary Search Tree
// https://leetcode.com/problems/find-mode-in-binary-search-tree/

#include <bits/stdc++.h>
#include <deque>
#include <iostream>
#include <vector>
#include <utility>
#include <cstdlib>
#include <math.h>

using namespace std;

struct TreeNode {
	int val;
	TreeNode *left;
	TreeNode *right;
	TreeNode() : val(0), left(nullptr), right(nullptr) {}
	TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
	TreeNode(int x, TreeNode *left, TreeNode *right)
			: val(x), left(left), right(right) {}
};

#include "../../../utils/print.h"

// DOESNT WORK
// void count(TreeNode *root, unordered_map<int, int> &mp) {
// 	if (root == NULL) {
// 		return;
// 	}
// 	auto iter = mp.find(root->val);
// 	if (iter != mp.end()) {
// 		//
// 		iter->second++;
// 	} else {
// 		mp.insert({root->val, 1});
// 	}
// 	count(root->left, mp);
// 	count(root->right, mp);
// }

// bool static comp(pair<int, int> const &a, pair<int, int> const &b) {
// 	return a.second > b.second;
// }

// vector<int> findMode(TreeNode *root) {
// 	//
// 	unordered_map<int, int> mp;
// 	count(root, mp);

// 	vector<pair<int, int>> vp;
// 	for (auto i : mp) {
// 		vp.push_back(pair<int, int>(i.first, i.second));
// 	}
// 	sort(vp.begin(), vp.end(), comp);

// 	int max = vp[0].second;
// 	vector<int> res;
// 	int i = 0;
// 	while (vp[i].second == max) {
// 		res.push_back(vp[i].first);
// 		i++;
// 	}
// 	return res;
// }

int main() {
	//

	// TreeNode *root;
	// root = new TreeNode(1);

	// TreeNode *node1;
	// node1 = new TreeNode(2);

	// TreeNode *node2;
	// node2 = new TreeNode(2);

	// root->right = node1;
	// node1->left = node2;

	TreeNode *root;
	root = new TreeNode(1);

	TreeNode *node1;
	node1 = new TreeNode(2);

	TreeNode *node2;
	node2 = new TreeNode(2);

	TreeNode *node3;
	node3 = new TreeNode(3);

	TreeNode *node4;
	node4 = new TreeNode(3);

	root->right = node1;
	node1->left = node2;
	node1->right = node3;
	node3->left = node4;

	vector<int> res = findMode(root);

	for (int i : res) {
		cout << i << endl;
	}

	return 0;
}