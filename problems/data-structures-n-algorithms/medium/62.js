// 62. Unique Paths
// https://leetcode.com/problems/unique-paths/

const uniquePaths = function (m, n) {
	const matrix = new Array(m);
	for (let i = 0; i < m; i++) {
		matrix[i] = new Array(n);
	}

	for (let i = 0; i < m; i++) {
		matrix[i][0] = 1;
	}

	for (let i = 0; i < n; i++) {
		matrix[0][i] = 1;
	}

	for (let i = 1; i < m; i++) {
		for (let j = 1; j < n; j++) {
			matrix[i][j] = matrix[i - 1][j] + matrix[i][j - 1];
		}
	}

	return matrix[m - 1][n - 1];
};

function main() {
	debugger;
	const res = uniquePaths(7, 3);
	console.log(res);
}

main();
