// 38. Count and Say
// https://leetcode.com/problems/count-and-say/

#include <stdio.h>
#include <stdlib.h>

/*
	input 4

	countAndSay(1) return "1" ->

	countAndSay(2) gets "1" from -> countAndSay(1) -> has "one 1" return "11" ->

	countAndSay(3) gets "11" from -> countAndSay(2) -> has "two 1" return "211" ->

	countAndSay(4) gets "211" from -> countAndSay(3) -> has "1 2" return "1211"

 */

char *countAndSay(int n) {
	char *arr = (char *)malloc(sizeof(char) * (n + 1));
	char *temp;
	int i = 1, iter = 0, count = 0, done = 0;
	char first;

	if (n == 1) {
		arr[0] = '1';
		arr[1] = '\0';
	} else {
		temp = countAndSay(n - 1);

		while (iter < n - 1) {
			arr[i] = temp[iter];

			if (iter == 0) {
				first = temp[iter];
				count++;
			} else if (count > 0 && temp[iter] == first) {
				count++;
			} else if (done != 1 && temp[iter] != first) {
				done = 1;
			}

			i++;
			iter++;
		}
		arr[0] = count + '0';
		// printf("%d", count);
	}
	arr[n] = '\0';
	return arr;
}

int main() {
	int n;
	char *res;

	scanf("%d", &n);

	res = countAndSay(n);

	printf("\n\n%s", res);
}