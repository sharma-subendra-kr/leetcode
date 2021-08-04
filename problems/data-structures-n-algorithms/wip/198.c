// 198. House Robber
// https://leetcode.com/problems/house-robber/

#include <stdio.h>
#include <stdlib.h>

int max(int a, int b) {
	if (a > b) {
		return a;
	}
	return b;
}

// int _rob(int *nums, int i) {
// 	if (i < 0) {
// 		return 0;
// 	}

// 	return max(_rob(nums, i - 2) + nums[i], _rob(nums, i - 1));
// }

// int rob(int *nums, int numsSize) {
// 	if (numsSize == 0) {
// 		return 0;
// 	}

// 	return max(_rob(nums, numsSize - 3) + nums[numsSize - 1],
// 						 _rob(nums, numsSize - 1));
// }

int rob(int *nums, int numsSize) {
	int sum1 = 0, sum2 = 0;
	int i;

	for (i = 0; i < numsSize; i++) {
		if (i % 2 == 0) {
			sum1 += nums[i];
		} else {
			sum2 += nums[i];
		}
	}

	return max(sum1, sum2);
}

int main() {
	int *nums, numsSize;
	int i, res;

	scanf("%d", &numsSize);

	nums = (int *)malloc(sizeof(int) * numsSize);

	for (i = 0; i < numsSize; i++) {
		scanf("%d", &nums[i]);
	}

	res = rob(nums, numsSize);

	printf("%d", res);

	return 0;
}