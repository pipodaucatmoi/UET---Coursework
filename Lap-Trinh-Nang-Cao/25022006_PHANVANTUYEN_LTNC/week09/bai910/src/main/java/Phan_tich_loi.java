/*
1. Phân tích các lỗi (The 3 Broken Pieces)
Sau khi bạn push code lên lần đầu, pipeline chắc chắn sẽ báo đỏ. Dưới đây là 3 lỗi chính được cài cắm sẵn:
Lỗi 1: Dependency không tồn tại (Logback 9.9.9)
File: pom.xml
Dòng: <version>9.9.9</version>
Log bằng chứng: [ERROR] Failed to execute goal on project shipping-app: Could not resolve dependencies for project com.lab:shipping-app:jar:1.0-SNAPSHOT: Could not find artifact ch.qos.logback:logback-classic:jar:9.9.9
Nguyên nhân: Phiên bản 9.9.9 của Logback không tồn tại trên Maven Central. Đây là lỗi "ảo" thường gặp khi copy-paste version sai.
Lỗi 2: Plugin Maven Surefire quá cũ
File: pom.xml
Dòng: <version>2.12.4</version> (plugin maven-surefire-plugin)
Log bằng chứng: [INFO] No tests were executed! hoặc lỗi không nhận diện được JUnit 5.
Nguyên nhân: Phiên bản 2.12.4 quá cũ, không hỗ trợ JUnit 5 (Jupiter). Cần nâng cấp lên 3.x để các bài test @Test có thể chạy được.
Lỗi 3: Lỗi logic trong Code (NullPointerException tiềm ẩn)
File: ShippingCalculator.java
Dòng: if (type.equals("EXPRESS"))
Log bằng chứng: java.lang.NullPointerException: Cannot invoke "String.equals(Object)" because "type" is null (nếu có test case truyền null). Hoặc đơn giản là bài test testExpress sẽ fail vì logic tính toán:
Test mong đợi: $45000$
Thực tế: $5 * 5000 + 20000 = 45000$ (Dòng này đúng nhưng nếu đổi weight hoặc type sẽ dễ lỗi).
Thực tế lỗi ẩn: Nếu type truyền vào là null, app sẽ văng NullPointerException ngay lập tức.


 */