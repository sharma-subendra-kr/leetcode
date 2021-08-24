// 627. Swap Salary
// https://leetcode.com/problems/swap-salary/

# UPDATE salary SET sex=CASE WHEN sex='m'THEN'f'WHEN sex='f'THEN'm'END;
	# UPDATE salary SET sex=CASE WHEN sex='m'THEN'f'ELSE'm'END;
	UPDATE salary SET sex=CASE sex WHEN'm'THEN'f'ELSE'm'END;