/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentPractices.repository;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import studentPractices.domain.Company;

/**
 *
 * @author petar
 */
public class CompanyRepository {
    DatabaseConnection databaseConnection = new DatabaseConnection();
    public List<Company> getAll(){
        List<Company> companies = new LinkedList<>();
        String query = "select * FROM kompanija";
        
        
        try {
            databaseConnection.createConnection();
            Statement statement = databaseConnection.connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            
            while (rs.next()) {
                    String name = rs.getString("naziv");
                    String number = rs.getString("telefon");
                    int companyID = rs.getInt("ID");
                    int registrationNumber = rs.getInt("maticni_broj");
                    int cityID = rs.getInt("mestoID");
                    int taxIDNumber = rs.getInt("PIB");
                    Company company= new Company(companyID,name,number,cityID,registrationNumber,taxIDNumber);
                    companies.add(company);
                }
            rs.close();
            statement.close();
            databaseConnection.connection.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return companies;
    }
}

