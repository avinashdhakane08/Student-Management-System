package org.example;

import org.example.Config.DBConfig;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentService {

    public void addStudent(Student student) {
        String sql = """ 
                INSERT INTO students (name , email, course , mark) 
                VALUES(?,?,?,?)
                """;

        try (Connection connection = DBConfig.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)
        ) {

            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getEmail());
            preparedStatement.setString(3, student.getCourse());
            preparedStatement.setDouble(4, student.getMark());

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Student added successfully ");
            }

        } catch (SQLException e) {
            System.out.println("error " + e.getMessage());
        }

    }

    public void viewAllStudents() {

        String sql =
                """
                        SELECT id, name, email, course, mark FROM students
                        """;

        try (Connection connection = DBConfig.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {


            System.out.println();
            System.out.println("                       STUDENT RECORDS 2026");
            System.out.println("--------------------------------------------------------------------------");

            System.out.printf("%-5s %-20s %-30s %-15s %-10s%n",
                    "ID", "NAME", "EMAIL", "COURSE", "MARKS");

            System.out.println("--------------------------------------------------------------------------");

            while (resultSet.next()) {

                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String course = resultSet.getString("course");
                double mark = resultSet.getDouble("mark");

                System.out.printf("%-5d %-20s %-30s %-25s %-10.2f%n",
                        id, name, email, course,mark);
            }

            System.out.println("--------------------------------------------------------------------------");


        } catch (SQLException e) {
            System.out.println("Error " + e.getMessage());
        }
    }

    public void searchStudent(int id) {
        String sql = """
                SELECT * FROM students where id=?
                """;

        try (Connection connection = DBConfig.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    System.out.println();
                    System.out.println("Student found.");

                    System.out.println("ID: " + resultSet.getInt("id"));
                    System.out.println("name: " + resultSet.getString("name"));
                    System.out.println("email: " + resultSet.getString("email"));
                    System.out.println("course: " + resultSet.getString("course"));
                    System.out.println("mark: " + resultSet.getDouble("mark"));

                } else {
                    System.out.println("Student not found.");
                }

            }


        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }

    public void updateStudentDetails(Student student) {
        String sql = """
                UPDATE students 
                SET name =?, email=? ,course =?, mark =?
                WHERE id =?
                
                """;

        try (Connection connection = DBConfig.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {


            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getEmail());
            preparedStatement.setString(3, student.getCourse());
            preparedStatement.setDouble(4, student.getMark());
            preparedStatement.setInt(5, student.getId());

            int rowAffected = preparedStatement.executeUpdate();
            if (rowAffected > 0)
                System.out.println("Student updated successfully");
            else
                System.out.println("Student with ID " + student.getId() + " does not exist");


        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }

    public void deleteStudent(int id) {

        String sql = """
                DELETE FROM students 
                WHERE  id =?
                
                """;

        try (Connection connection = DBConfig.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {


            preparedStatement.setInt(1, id);
            int row = preparedStatement.executeUpdate();

            if (row > 0) {
                System.out.println("Student deleted successfully.");
            } else {
                System.out.println("Student with ID " + id + " does not exist.");
            }
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }

    }
}
