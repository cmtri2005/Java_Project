# Phân tích BMI (Body Mass Index)

Chương trình Java phân tích dữ liệu BMI, tính toán thống kê và tạo mô hình dự đoán.

## Yêu cầu hệ thống

- Java Development Kit (JDK) 17 trở lên
- Maven (hoặc MVND)

## Cài đặt thư viện

### Cách 1: Sử dụng Maven/MVND (Khuyến nghị)
Maven sẽ tự động tải các thư viện cần thiết khi bạn chạy lệnh build.

### Cách 2: Tải thư viện thủ công
Nếu không sử dụng Maven, bạn cần tải các file JAR sau và đặt vào thư mục `lib/`:

1. JFreeChart:
   - Tải file `jfreechart-1.5.3.jar` từ: https://repo1.maven.org/maven2/org/jfree/jfreechart/1.5.3/jfreechart-1.5.3.jar
   - Tải file `jcommon-1.0.23.jar` từ: https://repo1.maven.org/maven2/org/jfree/jcommon/1.0.23/jcommon-1.0.23.jar

2. Đặt các file JAR vào thư mục `lib/`:
```bash
mkdir lib
# Copy các file JAR đã tải vào thư mục lib/
```

## Cách chạy chương trình

### Cách 1: Sử dụng Maven/MVND (Khuyến nghị)

1. Build project:
```bash
mvn clean install
# Hoặc nếu dùng MVND
mvnd clean install
```

2. Chạy file JAR:
```bash
java -jar target/JavaBMIAnalysis-1.0-SNAPSHOT-jar-with-dependencies.jar
```

### Cách 2: Chạy trực tiếp từ mã nguồn

1. Đảm bảo đã tải và đặt các thư viện vào thư mục `lib/` như hướng dẫn ở phần "Cài đặt thư viện"

2. Biên dịch các file Java:
```bash
javac -d target/classes -cp "lib/*" src/main/java/*.java
```

3. Chạy chương trình:
```bash
# Trên Windows:
java -cp "target/classes;lib/*" Main

# Trên Linux/Mac:
java -cp "target/classes:lib/*" Main
```

## Cấu trúc thư mục

```
JavaBMIAnalysis/
├── data/
│   └── bmi_data.csv      # File dữ liệu BMI
├── src/main/java/
│   ├── Main.java         # File chính
│   ├── BMIRecord.java    # Class lưu trữ thông tin BMI
│   ├── BMIReader.java    # Class đọc dữ liệu từ CSV
│   ├── BMIStats.java     # Class tính toán thống kê
│   ├── ChartGenerator.java # Class tạo biểu đồ
│   └── LinearRegressionModel.java # Class mô hình dự đoán
├── lib/                  # Thư viện phụ thuộc
├── pom.xml              # File cấu hình Maven
└── README.md            # File hướng dẫn này
```

## Tính năng

1. Đọc và phân tích dữ liệu BMI từ file CSV
2. Tính toán thống kê BMI theo giới tính:
   - Giá trị trung bình
   - Độ lệch chuẩn
   - Kích thước mẫu
3. Tạo mô hình hồi quy tuyến tính dự đoán BMI
4. Hiển thị kết quả phân tích và dự đoán mẫu

