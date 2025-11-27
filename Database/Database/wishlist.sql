/* ===========================================================
   WISHLIST DATABASE TEST QUERIES
   Author: Rewan Abdelkariem
   Date: 09-Nov-2025
   Database: OpenCart
   =========================================================== */

/* -----------------------------------------------------------
   OP-496: Verify that adding a product to the wishlist creates
   a record in oc_wishlist.
   ----------------------------------------------------------- */
SELECT * 
FROM oc_customer_wishlist 
WHERE customer_id = 1 AND product_id = 43;

/* -----------------------------------------------------------
   OP-497: Verify that removing a product from the wishlist 
           deletes the correct record from oc_customer_wishlist
   ----------------------------------------------------------- */
SELECT * 
FROM oc_customer_wishlist 
WHERE customer_id = 1 AND product_id = 43;

/* -----------------------------------------------------------
   OP-498: Verify that adding the same product twice 
           does not create duplicate records
   ----------------------------------------------------------- */
SELECT COUNT(*) AS duplicate_count
FROM oc_customer_wishlist
WHERE customer_id = 1 AND product_id = 43;


/* -----------------------------------------------------------
   OP-499: Verify that every wishlist record belongs to 
           a valid customer record in oc_customer
   ----------------------------------------------------------- */
SELECT w.customer_id, w.product_id
FROM oc_customer_wishlist w
LEFT JOIN oc_customer c ON w.customer_id = c.customer_id
WHERE c.customer_id IS NULL;


/* -----------------------------------------------------------
   OP-500: Verify that wishlist data is consistent and 
           references existing products
   ----------------------------------------------------------- */
SELECT w.wishlist_id, w.product_id, p.product_id AS valid_product
FROM oc_customer_wishlist w
LEFT JOIN oc_product p ON w.product_id = p.product_id
WHERE p.product_id IS NULL;

/* ----------------------------*
