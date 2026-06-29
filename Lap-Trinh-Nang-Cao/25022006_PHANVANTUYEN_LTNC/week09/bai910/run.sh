# 1. Cài đặt các biến đường dẫn và phiên bản
ROOT_DIR=$(pwd)
SRC_DIR="$ROOT_DIR/src"
BUILD_DIR="$ROOT_DIR/build"
LIB_DIR="$ROOT_DIR/lib"

# Cập nhật lên JUnit 6 (Bản Standalone mới nhất)
JUNIT_VERSION="6.0.3"
JUNIT_JAR="junit-platform-console-standalone-$JUNIT_VERSION.jar"
JUNIT_URL="https://repo1.maven.org/maven2/org/junit/platform/junit-platform-console-standalone/$JUNIT_VERSION/$JUNIT_JAR"

# 2. Tạo các thư mục cần thiết
mkdir -p "$BUILD_DIR"
mkdir -p "$LIB_DIR"

# 3. Tải thư viện JUnit Standalone (nếu chưa có trong thư mục lib)
if [ ! -f "$LIB_DIR/$JUNIT_JAR" ]; then
    echo "Downloading JUnit 6 Standalone v$JUNIT_VERSION..."
    curl -s -o "$LIB_DIR/$JUNIT_JAR" "$JUNIT_URL"
    echo "Download Successfully!"
fi

# 4. Biên dịch code (Đưa file JAR vào classpath để javac hiểu @Test)
echo "Complying code..."
javac -cp "$LIB_DIR/$JUNIT_JAR" -d "$BUILD_DIR" "$SRC_DIR"/*.java

# 5. Chạy test thông qua file JAR của JUnit 6
echo "=== START RUNNING TEST BY JUNIT $JUNIT_VERSION ==="
java -jar "$LIB_DIR/$JUNIT_JAR" execute -cp "$BUILD_DIR" --scan-class-path
