use opencartoldv ;

SELECT firstname, lastname, email FROM oc_customer WHERE email='makarious@morgan.com';

SELECT password FROM oc_customer WHERE email='makarious@morgan.com';

SELECT COUNT(email) FROM oc_customer WHERE email='makarious@morgan.com' HAVING COUNT(email) > 1;

SELECT email, date_added FROM oc_customer WHERE email='makarious@morgan.com';

SELECT firstname, lastname, email, password FROM oc_customer WHERE email='makarious@morgan.com' 
AND (firstname IS NULL OR lastname IS NULL);

SELECT status FROM oc_customer WHERE email='makarious@morgan.com';

SELECT email, date_modified FROM oc_customer_login WHERE email='makarious@morgan.com';

SELECT date_modified FROM oc_customer_login WHERE email='makarious@morgan.com';

SELECT status, COUNT(*) AS total_users FROM oc_customer GROUP BY status HAVING total_users > 0;

SELECT firstname, email, date_added FROM oc_customer ORDER BY date_added DESC;

SELECT firstname, lastname FROM oc_customer WHERE firstname LIKE 'Mak%';

SELECT c.firstname, c.email, a.city FROM oc_customer c JOIN oc_address a ON c.customer_id = a.customer_id 
WHERE c.email='makarious@morgan.com';

SELECT COUNT(*) FROM oc_customer WHERE DATE(date_added)=CURDATE();

SELECT email, status FROM oc_customer WHERE email='makarious@morgan.com' or email='mohamed@henna.com';

SELECT * FROM oc_customer WHERE email='rewan@khaled.com';

SELECT DATE(date_added) AS register_date, COUNT(*) AS total_users FROM oc_customer 
GROUP BY DATE(date_added) ORDER BY register_date DESC;

SELECT * FROM oc_customer WHERE email='makarious@morgancom'; 

SELECT customer_id FROM oc_customer ORDER BY customer_id DESC LIMIT 2;

SELECT * FROM oc_customer WHERE email='makarious@morgan.com';

SELECT * FROM oc_customer_login WHERE email='makarious@morgan.com' ORDER BY date_added DESC LIMIT 1;

SELECT status FROM oc_customer WHERE email='mohamed@henna.com'; 

SELECT * FROM oc_api_session ORDER BY date_added DESC LIMIT 4;

SELECT * FROM oc_customer WHERE email='amany@ayman.com'; 

SELECT * FROM oc_product WHERE status = 1;

SELECT * FROM oc_product WHERE status = 0;

SELECT p.product_id, pd.name FROM oc_product p JOIN oc_product_description pd ON p.product_id = pd.product_id;

SELECT * FROM oc_product_description WHERE name LIKE '%Phone%';

SELECT * FROM oc_product WHERE model LIKE 'sam1%';

SELECT * FROM oc_product_description WHERE tag LIKE '%tablet%';

SELECT p.product_id, pc.category_id FROM oc_product_to_category pc JOIN oc_product p ON p.product_id = pc.product_id 
WHERE pc.category_id = 20;

SELECT model , price FROM oc_product ORDER BY price ASC;

SELECT model, date_added FROM oc_product ORDER BY date_added DESC;

SELECT * FROM oc_product WHERE quantity > 0;

SELECT * FROM oc_product WHERE quantity = 0; 

SELECT p.model, ps.price AS special_price FROM oc_product p JOIN oc_product_special ps ON p.product_id = ps.product_id;

SELECT * FROM oc_product_to_category WHERE product_id = 28;

SELECT * FROM oc_product WHERE product_id=35;
SELECT * FROM oc_product_description WHERE product_id=35;

SELECT * FROM oc_product_to_store WHERE store_id=0;

SELECT * FROM oc_product WHERE manufacturer_id=9;

SELECT category_id, COUNT(*) FROM oc_product_to_category GROUP BY category_id;

SELECT * FROM oc_product LIMIT 10 OFFSET 10;

SELECT * FROM oc_product WHERE product_id IN (SELECT product_id FROM oc_module WHERE code='featured');





