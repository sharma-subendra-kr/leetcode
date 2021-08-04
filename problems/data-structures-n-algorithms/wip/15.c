// 15. 3Sum
// https://leetcode.com/problems/3sum/

#include <stdio.h>
#include <stdlib.h>

int comp(const void *a, const void *b) {

	int _a = *((int *)a);
	int _b = *((int *)b);

	if (_a > _b) {
		return 1;
	} else if (_a < _b) {
		return -1;
	}
	return 0;
}

int **threeSum(int *nums, int numsSize, int *returnSize,
							 int **returnColumnSizes) {
	int **res, i, low, high, sum;
	*returnSize = 0;

	qsort(nums, numsSize, sizeof(int), comp);

	res = (int **)malloc(sizeof(int) * numsSize);
	*returnColumnSizes = (int *)malloc(sizeof(int) * numsSize);

	for (i = 0; i < numsSize; i++) {
		low = i + 1;
		high = numsSize - 1;

		while (low < high) {
			sum = nums[i] + nums[low] + nums[high];
			if (sum < 0) {
				low++;
			} else if (sum > 0) {
				high--;
			} else if ((nums[low] != nums[low - 1] && low != i) &&
								 (high != numsSize - 1 && nums[high] != nums[high + 1])) {
				res[*returnSize] = (int *)malloc(sizeof(int) * 3);
				res[*returnSize][0] = nums[i];
				res[*returnSize][1] = nums[low++];
				res[*returnSize][2] = nums[high++];
				(*returnColumnSizes)[*returnSize] = 3;
				(*returnSize)++;
			}
		}
	}

	return res;
}

int main() {
	int *nums, numsSize, returnSize, *returnColumnSizes;
	int i, j, **arr;

	scanf("%d", &numsSize);

	nums = (int *)malloc(sizeof(int) * numsSize);

	for (i = 0; i < numsSize; i++) {
		scanf("%d", &nums[i]);
	}

	arr = threeSum(nums, numsSize, &returnSize, &returnColumnSizes);

	for (i = 0; i < returnSize; i++) {
		for (j = 0; j < 3; j++) {
			printf("%d ", arr[i][j]);
		}
		printf("\n");
	}

	return 0;
}