USE opencart;
SHOW TABLES;
SHOW COLUMNS FROM oc_customer;
SHOW COLUMNS FROM oc_address;
SHOW COLUMNS FROM oc_customer_wishlist;


-- Customer details -------------
SELECT customer_id,
       firstname,
       lastname,
       email,
       telephone,
       date_added
FROM oc_customer;

-- Customer address details --------------
SELECT address_id,
       customer_id,
       firstname,
       lastname,
       address_1,
       city,
       country_id
FROM oc_address;

-- Customer WISHLIST details ----------------
SELECT *
FROM oc_customer_wishlist;

