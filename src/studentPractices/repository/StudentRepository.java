/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentPractices.repository;


import java.sql.*;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import studentPractices.domain.Student;

/**
 *
 * @author petar
 */
public class StudentRepository {
    DatabaseConnection databaseConnection = new DatabaseConnection();
    
      public List<Student> getAll(){
        List<Student> students = new LinkedList<>();
        String query = "select * from student";
        
        
        try {
            databaseConnection.createConnection();
            Statement statement = databaseConnection.connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            
            while (rs.next()) {
                    int studentID = rs.getInt("studentID");
                    String name = rs.getString("ime");
                    String surname = rs.getString("prezime");
                    String address = rs.getString("adresa");
                    String number = rs.getString("telefon");
                    String index = rs.getString("indeks");
                    int majorID = rs.getInt("smerID");
                    int moduleID = rs.getInt("modulID");
                    Student student = new Student(studentID,  name,  surname,  address,  number,  index,  majorID,  moduleID);
                    students.add(student);
                }
            rs.close();
            statement.close();
            databaseConnection.connection.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return students;
    }
}
