# 1083. Sales Analysis II
# https://leetcode.com/problems/sales-analysis-ii/

# SELECT distinct buyer_id FROM Sales JOIN Product ON Sales.product_id = Product.product_id WHERE product_name = "S8" AND buyer_id NOT IN (SELECT distinct buyer_id FROM Sales JOIN Product ON Sales.product_id = Product.product_id WHERE product_name = "iPhone");
SELECT buyer_id FROM Sales JOIN Product ON Sales.product_id = Product.product_id GROUP BY buyer_id HAVING SUM(product_name = "S8") > 0 AND SUM(product_name = "iPhone") = 0;