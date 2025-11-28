/* ===========================================================
   ACCOUNT MANAGEMENT DATABASE TEST QUERIES
   Author: Rewan Abdelkariem
   Date: 04-Nov-2025
   Database: OpenCart
   =========================================================== */
/* -----------------------------------------------------------
   OP-461: Verify that customer details are updated correctly in oc_customer table
   ----------------------------------------------------------- */
SELECT customer_id,
       firstname,
       lastname,
       email,
       telephone
FROM oc_customer 
WHERE customer_id = 1;

/* -----------------------------------------------------------
   OP-462: Verify that updated customer details are consistent
   ----------------------------------------------------------- */
SELECT DISTINCT customer_id 
FROM oc_address
WHERE customer_id = 1;

/* -----------------------------------------------------------
   OP-463: Verify NOT NULL constraint on mandatory fields
   ----------------------------------------------------------- */
UPDATE oc_customer 
SET firstname = NULL 
WHERE customer_id = 1;

SELECT customer_id, firstname 
FROM oc_customer 
WHERE customer_id = 1;

SHOW COLUMNS FROM oc_customer WHERE Field = 'firstname';

/* -----------------------------------------------------------
   OP-464: Verify UNIQUE constraint on email field
   ----------------------------------------------------------- */
SELECT customer_id, email 
FROM oc_customer;

UPDATE oc_customer 
SET email = 'rewan@example.com'
WHERE customer_id = 1;

SELECT customer_id, email 
FROM oc_customer;

/* -----------------------------------------------------------
   OP-465: Verify password encryption format
   ----------------------------------------------------------- */
SELECT customer_id, password
FROM oc_customer;
/* -----------------------------------------------------------
   OP-466: Verify password updates correctly
   ----------------------------------------------------------- */
SELECT customer_id, password
FROM oc_customer
WHERE customer_id = 1;

/* -----------------------------------------------------------
   OP-467: Verify new address creation
   ----------------------------------------------------------- */
SELECT address_id, customer_id, firstname, lastname, address_1, city, postcode, country_id 
FROM oc_address 
WHERE customer_id = 1 
ORDER BY address_id DESC;

/* -----------------------------------------------------------
   OP-468: Verify address details can be updated
   ----------------------------------------------------------- */
SELECT address_id, customer_id, firstname, lastname, address_1, city, postcode, country_id 
FROM oc_address
WHERE customer_id = 1 
ORDER BY address_id DESC;

/* -----------------------------------------------------------
   OP-469: Verify deleting an address removes the corresponding record from oc_address
   ----------------------------------------------------------- */
SELECT address_id, customer_id, firstname, lastname, address_1, city, postcode, country_id 
FROM oc_address
WHERE customer_id = 1 
ORDER BY address_id DESC;

/* -----------------------------------------------------------
   OP-470: Verify that multiple addresses for the same customer are stored correctly
   ----------------------------------------------------------- */
SELECT address_id, customer_id, firstname, lastname, address_1, city, postcode, country_id
FROM oc_address
WHERE customer_id = 1
ORDER BY address_id;

SELECT COUNT(*) 
FROM oc_address 
WHERE customer_id = 1;

/* -----------------------------------------------------------
   OP-470: Verify that every address in the oc_address table belongs to a valid customer record in oc_customer
   ----------------------------------------------------------- */
SELECT a.address_id, a.customer_id
FROM oc_address a
LEFT JOIN oc_customer c ON a.customer_id = c.customer_id
WHERE c.customer_id IS NULL;


/* -----------------------------------------------------------
OP-471 – Check that customer emails are stored in lowercase
 ----------------------------------------------------------- */
SELECT email 
FROM oc_customer 
WHERE email LIKE '%rewan.qa%';

/* -----------------------------------------------------------
OP-495 - Verify that the telephone field only accepts valid length values and rejects overly long numbers.
 ----------------------------------------------------------- */
SHOW COLUMNS FROM oc_customer LIKE 'telephone';

INSERT INTO oc_customer (firstname, lastname, email, telephone, password)
VALUES ('Long', 'Number', 'test.length@example.com', '012345678901234567890111111111111', 'pass123');

SELECT customer_id,
       firstname,
       lastname,
       email,
       telephone,
       date_added
FROM oc_customer;

