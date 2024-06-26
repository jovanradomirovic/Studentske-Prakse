/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentPractices.repository;


import java.sql.*;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import studentPractices.domain.Practices;

/**
 *
 * @author radom
 */
public class PracticesRepository {
    DatabaseConnection databaseConnection = new DatabaseConnection();
    
     
    public List<Practices> getAll(){
        List<Practices> practices = new LinkedList<>();
        String query = "select * from praksa";
        
        
        try {
            databaseConnection.createConnection();
            Statement statement = databaseConnection.connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            
            while (rs.next()) {
                    int practiseID = rs.getInt("praksaID");
                    String position = rs.getString("pozicija");
                    Date startDate = rs.getDate("datumPocetka");
                    Date endDate = rs.getDate("datumZavrsetka");
                    int companyID = rs.getInt("kompanijaID");
                    int yearID = rs.getInt("godinaID");
                    int cityID = rs.getInt("mestoID");
                    int studentID = rs.getInt("studentID");
                    int contractID = rs.getInt("ugovorID");
                    Practices practice = new Practices(practiseID, position, startDate.toLocalDate(), endDate.toLocalDate(), companyID, yearID, cityID, studentID, contractID);
                    practices.add(practice);
                }
            rs.close();
            statement.close();
            databaseConnection.connection.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return practices;
    }
}
