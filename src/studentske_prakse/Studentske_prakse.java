/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package studentske_prakse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author student2
 */
public class Studentske_prakse {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/studentske_prakse";
        String user = "root";
        String password = "";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            System.out.println("Uspesno uspostavljena veza");

            String query = "SELECT * FROM smer";
            try (Statement statement = connection.createStatement();
                 ResultSet rs = statement.executeQuery(query)) {

                while (rs.next()) {
                    int ID = rs.getInt("ID");
                    String ime = rs.getString("naziv");
                    System.out.println(ime);
                }
            } catch (SQLException e) {
                System.err.println("Error executing query: " + e.getMessage());
            }
        } catch (SQLException e) {
            System.err.println("Error connecting to the database: " + e.getMessage());
        }
    
    }
}
