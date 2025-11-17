# OpenCart API – Postman Collection

This folder contains the Postman Collection created and tested as part of the DEPI Graduation Project.  
The collection covers the full workflow of interacting with the **OpenCart REST API**, including both **positive** and **negative** test scenarios.

---

## 📌 What We Did
- Enabled and configured the **OpenCart API** from the admin panel.
- Generated an **API Key** and allowed our IP address.
- Built a full **Postman Collection** for all important API endpoints.
- Automated validation using **Postman Tests** (status codes, JSON checks, logic checks).
- Covered both:
    - ✔ Valid flow (happy scenarios)
    - ✔ Error handling (negative scenarios)

This collection can be used for testing, learning, or integrating with OpenCart systems.

---

## 📂 Files Included
- **OpenCart.postman_collection.json** → Full test collection
- **OpenCart_environment.json** → Base URL & variables
- **OpenCart API Doc.pdf** → Documentation and reference
- **README.md** → This file

---

## 🚀 How to Use the Collection
1. Import the JSON collection into **Postman**.
2. Import the environment file.
3. Set your own `BaseURL`
4. Click **Login – Generate Token** to create `api_token`.
5. Run the requests in order or execute the entire collection.

---

## 🔑 API Setup (Before Testing)
Inside OpenCart Admin Panel:

1. Go to **System → Users → API**
2. Edit user **Default**
3. Generate your **API Key**
4. Set **Status = Enabled**
5. Add your IP address

---

## 📚 Covered Endpoints Summary
The collection covers the following core endpoints:

| Feature | Endpoint |
|--------|----------|
| Authentication | `api/login` |
| Currency | `api/currency` |
| Customer | `api/customer` |
| Cart | `api/cart/add`, `api/cart/edit`, `api/cart/remove`, `api/cart/products` |
| Coupon | `api/coupon` |
| Voucher | `api/voucher`, `api/voucher/add` |
| Shipping | `api/shipping/address`, `api/shipping/methods`, `api/shipping/method` |
| Payment | `api/payment/address`, `api/payment/methods`, `api/payment/method` |
| Orders | `api/order/add` + related |

---

## ✔ Purpose
This collection serves as:
- A full functional test suite
- A reference for API integration
- Learning material for understanding OpenCart API behavior

---
