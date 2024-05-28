/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentske_prakse.repository;

import java.util.List;
import studentske_prakse.domain.Smer;
import java.sql.*;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author radom
 */
public class SmerRepository {
    
    String url = "jdbc:mysql://localhost:3306/studentske_prakse";
    String user = "root";
    String password = "";
    private Connection connection;
    public SmerRepository() {
        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Uspesno uspostavljena veza");
        } catch (SQLException ex) {
            Logger.getLogger(SmerRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
    public List<Smer> getAll(){
        List<Smer> smerovi = new LinkedList<>();
        String query = "SELECT * FROM smer";
        
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            
            while (rs.next()) {
                    int ID = rs.getInt("ID");
                    String ime = rs.getString("naziv");
                    Smer smer = new Smer(ID, ime);
                    smerovi.add(smer);
                }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return smerovi;
    }
}
