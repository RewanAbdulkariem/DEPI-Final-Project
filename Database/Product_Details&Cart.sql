
USE opencart;
SELECT name, price, quantity FROM oc_product JOIN oc_product_description USING(product_id) WHERE product_id = 30;
SELECT quantity FROM oc_product WHERE product_id = 40;
SELECT author, text, rating FROM oc_review WHERE product_id = 49 ORDER BY date_added DESC;
SELECT status, quantity FROM oc_product WHERE product_id = 49;
SELECT image FROM oc_product_image WHERE product_id = 43;
SELECT * FROM oc_cart ;
SELECT quantity FROM oc_cart WHERE product_id = 43;
SELECT COUNT(*) FROM oc_cart WHERE product_id = 43;
SELECT price FROM oc_cart WHERE  product_id = 43;
SELECT * FROM oc_cart WHERE customer_id = 43;