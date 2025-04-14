# Hướng dẫn đẩy code lên GitHub

## Bước 1: Cài đặt Git
1. Tải và cài đặt Git từ trang chủ: https://git-scm.com/downloads
2. Mở Command Prompt hoặc PowerShell và kiểm tra cài đặt:
```bash
git --version
```

## Bước 2: Cấu hình Git
```bash
git config --global user.name "Tên của bạn"
git config --global user.email "email@example.com"
```

## Bước 3: Tạo repository trên GitHub
1. Đăng nhập vào GitHub
2. Click nút "+" ở góc phải trên cùng
3. Chọn "New repository"
4. Đặt tên repository (ví dụ: JavaBMIAnalysis)
5. Chọn "Public" hoặc "Private"
6. KHÔNG chọn "Initialize this repository with a README"
7. Click "Create repository"

## Bước 4: Khởi tạo Git trong project
```bash
# Di chuyển vào thư mục project
cd C:\Users\trica\Downloads\JavaBMIAnalysis

# Khởi tạo Git repository
git init

# Thêm tất cả các file vào staging area
git add .

# Commit các thay đổi
git commit -m "Initial commit: BMI Analysis project"
```

## Bước 5: Kết nối với GitHub và push code
```bash
# Thêm remote repository (thay YOUR_USERNAME bằng tên GitHub của bạn)
git remote add origin https://github.com/YOUR_USERNAME/JavaBMIAnalysis.git

# Push code lên GitHub
git push -u origin main
```

## Bước 6: Kiểm tra
1. Truy cập repository trên GitHub
2. Kiểm tra xem tất cả các file đã được upload chưa

## Lưu ý
- Nếu gặp lỗi xác thực, bạn cần tạo Personal Access Token trên GitHub:
  1. Vào Settings > Developer settings > Personal access tokens
  2. Tạo token mới với quyền repo
  3. Sử dụng token thay cho mật khẩu khi push code

- Nếu muốn cập nhật code sau này:
```bash
git add .
git commit -m "Mô tả thay đổi"
git push
``` 