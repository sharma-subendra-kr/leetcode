# 181. Employees Earning More Than Their Managers
# https://leetcode.com/problems/employees-earning-more-than-their-managers/
# SELECT Name as Employee from Employee e WHERE e.Salary > (SELECT Salary FROM Employee WHERE Id = e.ManagerId);
# SELECT e1.Name as Employee from Employee e1, Employee e2 WHERE e1.ManagerId = e2.Id AND e1.Salary > e2.Salary;
SELECT e1.Name as Employee from Employee e1 JOIN Employee e2 ON e1.ManagerId = e2.Id AND e1.Salary > e2.Salary;