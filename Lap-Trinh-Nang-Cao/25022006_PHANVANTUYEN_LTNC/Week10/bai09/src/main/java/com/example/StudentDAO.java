package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StudentDAO {
    private static final String DB_URL = "jdbc:sqlite:students.db";

    public StudentDAO() {
        createTable();
    }

    private void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS students ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "full_name TEXT NOT NULL,"
                + "student_id TEXT NOT NULL,"
                + "major TEXT NOT NULL,"
                + "birth_date TEXT NOT NULL,"
                + "gender TEXT NOT NULL,"
                + "services TEXT NOT NULL"
                + ")";

        try (Connection connection = DriverManager.getConnection(DB_URL);
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void save(Student student) {
        String sql = "INSERT INTO students(full_name, student_id, major, birth_date, gender, services) "
                + "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(DB_URL);
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, student.getFullName());
            statement.setString(2, student.getStudentId());
            statement.setString(3, student.getMajor());
            statement.setString(4, student.getBirthDate());
            statement.setString(5, student.getGender());
            statement.setString(6, student.getServices());
            statement.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String loadAll() {
        String sql = "SELECT * FROM students ORDER BY id DESC";
        StringBuilder result = new StringBuilder();

        try (Connection connection = DriverManager.getConnection(DB_URL);
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet rs = statement.executeQuery()) {

            while (rs.next()) {
                result.append("Full name: ").append(rs.getString("full_name")).append("\n")
                        .append("Student ID: ").append(rs.getString("student_id")).append("\n")
                        .append("Major: ").append(rs.getString("major")).append("\n")
                        .append("Birth date: ").append(rs.getString("birth_date")).append("\n")
                        .append("Gender: ").append(rs.getString("gender")).append("\n")
                        .append("Services: ").append(rs.getString("services")).append("\n")
                        .append("-------------------------\n");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        if (result.isEmpty()) {
            return "No data found.";
        }

        return result.toString();
    }
}