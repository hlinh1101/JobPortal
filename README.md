# ProjectPTUD
# 🧑‍💼 Job Portal System - Spring Boot + React

Một hệ thống **cổng thông tin việc làm** toàn diện, giúp **nhà tuyển dụng** đăng tin và **ứng viên** tìm kiếm, ứng tuyển việc làm dễ dàng.  
Tích hợp **SSO với Google** sử dụng giao thức **OIDC**, đảm bảo trải nghiệm đăng nhập đơn giản và bảo mật cao.

---

## 🚀 Tính năng nổi bật

### 💼 Quản lý công việc
- Nhà tuyển dụng:
  - Đăng bài tuyển dụng mới.
  - Quản lý và cập nhật trạng thái công việc.
- Ứng viên:
  - Duyệt danh sách việc làm.
  - Ứng tuyển với CV và kỹ năng.

### 📄 Quản lý hồ sơ
- Ứng viên có thể cập nhật hồ sơ cá nhân, kỹ năng, học vấn, và tải lên CV.

---

## ⚙️ Công nghệ sử dụng

### ✅ Backend
- Java 17, Spring Boot
- Spring Security + OAuth2 Client (Google SSO)
- Spring Data JPA (MySQL)
- RESTful API theo mô hình Service/Controller/DTO
- Global Exception Handling

### ✅ Frontend
- React.js
- Axios, React Router
- Quản lý state cho đăng nhập và gọi API
- Giao diện dễ sử dụng, responsive

---

## 🛠 Hướng dẫn chạy project
### 1. Backend
  cd Job-Portal-SpringBoot-Backend
  ./mvnw spring-boot:run
### 2. Frontend
  cd JobPortal-react-app
  npm install
  npm start

 
