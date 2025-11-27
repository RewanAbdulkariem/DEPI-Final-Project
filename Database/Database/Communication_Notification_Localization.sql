-- ===================================================
-- 1️⃣ Customer Support - Contact Us
-- ===================================================

-- 
SELECT name, email, enquiry, date_added 
FROM oc_customer_inquiry 
ORDER BY date_added DESC;

-- 
SELECT * 
FROM oc_customer_inquiry 
WHERE email='testuser@example.com' 
ORDER BY date_added DESC;

-- 
SELECT * 
FROM oc_customer_inquiry 
WHERE enquiry_id=123;

-- 
SELECT status, admin_comment 
FROM oc_customer_inquiry 
WHERE enquiry_id=123;

-- 
SELECT i.enquiry_id 
FROM oc_customer_inquiry i 
LEFT JOIN oc_customer c ON i.customer_id=c.customer_id 
WHERE c.customer_id IS NULL;


-- ===================================================
-- 2️⃣ Notifications & Emails
-- ===================================================

-- 
SELECT * 
FROM oc_customer_activity 
WHERE type='notification' 
ORDER BY date_added DESC;

-- 
SELECT * 
FROM oc_mail_history 
WHERE email='testuser@example.com' 
ORDER BY date_sent DESC;


-- ===================================================
-- 3️⃣ Language Change
-- ===================================================

-- 
SELECT language 
FROM oc_customer 
WHERE customer_id=123;

--  (session)
SELECT value 
FROM oc_session 
WHERE key='language' AND session_id='abc123';


-- ===================================================
-- 4️⃣ Currency Change
-- ===================================================

--
SELECT currency 
FROM oc_customer 
WHERE customer_id=123;

--(session)
SELECT value 
FROM oc_session 
WHERE key='currency' AND session_id='abc123';
