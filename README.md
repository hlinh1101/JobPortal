### 1. Tổng quan về dự án
####     Backend:
    - Được triển khai bằng Spring Boot.
    - URL Swagger UI để kiểm tra API: http://localhost:8080/swagger-ui/index.html#/.
    - Chức năng chính:
        + Quản lý người dùng (Admin, Recruiter, Job Seeker).
        + Quản lý công việc (Job Posting, Job Applications).
        + Xử lý xác thực và phân quyền (Role-based access control).
    #### Frontend:
    - Được triển khai bằng React.
    - Repository frontend: JobPortal-react-app.
### 2. Cấu trúc thư mục backend
####     Backend có cấu trúc như sau:
    - Entities: Các lớp đại diện cho bảng trong cơ sở dữ liệu, ví dụ:
        Admin, User, Job, Resume, Skill, JobApplication, EducationalDetails.
    - DTOs (Data Transfer Objects): Các lớp dùng để truyền dữ liệu giữa client và server, ví dụ:
        PostJobRequestDto, SignInRequestDto, JobSeekerRequestDto, SkillDto.
    - Repositories: Các interface để thao tác với cơ sở dữ liệu, ví dụ:
        AdminRepository, UserRepository, JobRepository.
    - Services: Chứa logic nghiệp vụ, ví dụ:
        AdminService, JobService, SignUpService.
    - Controllers: Xử lý các request từ client, ví dụ:
        SignUpController, JobController, RecruiterController.

### 3. Các chức năng chính
    - Quản lý người dùng:
        Admin có thể quản lý các Recruiter và Job Seeker.
        Người dùng có thể đăng ký và đăng nhập (SignUp/SignIn).
    - Quản lý công việc:
        Recruiter có thể đăng bài tuyển dụng (Job Posting).
        Job Seeker có thể ứng tuyển vào công việc (Job Application).
    - Xử lý dữ liệu:
        Sử dụng DTO để truyền dữ liệu giữa client và server.
        Sử dụng ModelMapper để ánh xạ giữa DTO và Entity.
### 4. Công nghệ sử dụng
    - Spring Boot:
        Dependency Injection, REST API, JPA (Hibernate).
    - Spring Security:
        Được loại bỏ cấu hình mặc định nhưng có thể được cấu hình lại để xử lý xác thực.
    - ModelMapper:
        Dùng để ánh xạ dữ liệu giữa DTO và Entity.
    - BCryptPasswordEncoder:
        Mã hóa mật khẩu người dùng.
### 5. Hướng dẫn chạy dự án
####     Backend:
            cd Server/Job-Portal-SpringBoot-Backend-main
        Chạy lệnh Maven để build dự án:
            mvn clean install
        Chạy ứng dụng:
            mvn spring-boot:run
        Truy cập Swagger UI tại: http://localhost:8080/swagger-ui/index.html#/.
####     Frontend:
            cd Client/JobPortal-react-app-main
        Cài đặt dependencies:
            npm install
        Chạy ứng dụng:
            npm start
