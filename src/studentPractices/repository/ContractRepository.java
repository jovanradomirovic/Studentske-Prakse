/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentPractices.repository;

import java.sql.*;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import studentPractices.domain.Contract;

/**
 *
 * @author petar
 */
public class ContractRepository {
    DatabaseConnection databaseConnection = new DatabaseConnection();
    
      public List<Contract> getAll(){
        List<Contract> contracts = new LinkedList<>();
        String query = "select * from ugovor";
        
        
        try {
            databaseConnection.createConnection();
            Statement statement = databaseConnection.connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            
            while (rs.next()) {
                    int ID = rs.getInt("ID");
                    Date startDate = rs.getDate("datumPocetka");
                    Date endDate = rs.getDate("datumZavrsetka");
                    boolean isActive = rs.getBoolean("jeAktivan");
                    int companyID = rs.getInt("kompanijaID");
                    Contract contract = new Contract(ID,startDate.toLocalDate(),endDate.toLocalDate(),isActive,companyID);
                    contracts.add(contract);
                }
            rs.close();
            statement.close();
            databaseConnection.connection.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return contracts;
    }
}
