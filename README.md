# 🛒 E-commerce Product Management API

This is a beginner-level Spring Boot project that simulates a simple E-commerce backend system. It allows you to perform CRUD operations on products, upload product images, and search by brand.

---

## 📦 Features

- 🏠 Welcome/Home route
- 📃 List all products
- 🔍 Get product by ID
- 🖼️ View product image
- ➕ Add product with image
- ✏️ Update product and image
- ❌ Delete product
- 🔎 Search product by brand

---

## 🛠️ Tech Stack

- Java 17
- Spring Boot
- Spring Security (Basic Auth)
- Maven
- Multipart File Upload
- In-memory or MySQL DB (as per config)

---

## 🔐 Security

- Basic HTTP Authentication (Stateless)
- Public routes:
  - `/api/home`
  - `/api/list`
- All other routes require authentication

---

## 🧪 API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| `GET` | `/api/home` | Welcome endpoint |
| `GET` | `/api/list` | Get all products |
| `GET` | `/api/list/{id}` | Get product by ID |
| `POST` | `/api/list` | Add new product with image |
| `GET` | `/api/list/{id}/image` | Get product image |
| `PUT` | `/api/list/{id}` | Update product and image |
| `DELETE` | `/api/list/{id}` | Delete product |
| `GET` | `/api/list/search?keyword=brand` | Search by brand |

---

## 🧰 How to Run

1. Clone the repository:

```bash
git clone https://github.com/Shaad27s/ecomm-springboot-api.git
cd ecomm-springboot-api


## 🧾 License

This project is open-source and free to use.

---

## 👤 Author

Made by [Shaad27s](https://github.com/Shaad27s)
