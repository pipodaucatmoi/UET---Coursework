package com.mathutils;

public class Main_bai7 {
    public static void main(String[] args) {
        // Lỗi 1: Tên biến không viết theo kiểu camelCase
        // Lỗi 2: Thiếu khoảng trắng quanh toán tử '=' và '+'
        int so_nguyen_A = 5 + 10;

        // Lỗi 3: Thiếu dấu cách sau dấu phẩy
        System.out.println("Ket qua:" + so_nguyen_A);

        // Lỗi 4: Thiếu dấu ngoặc nhọn cho khối lệnh if
        if (so_nguyen_A > 0)
            System.out.println("So duong");
    }
}