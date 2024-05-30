/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package studentPractices.main;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import studentPractices.repository.MajorRepository;
/**
 *
 * @author student2
 */
public class StudentPractices {

    public static void main(String[] args) {
        MajorRepository test = new MajorRepository();
        System.out.println(test.getAll().get(0).getName());
    }
}
