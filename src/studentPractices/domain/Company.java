/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentPractices.domain;

/**
 *
 * @author student2
 */
public class Company {
    private int companyID;
    private String name;
    private String number;
    private int cityID;
    private int registrationNumber;
    private int taxIDNumber;

    public Company(int companyID, String name, String number, int cityID, int registrationNumber, int taxIDNumber) {
        this.companyID = companyID;
        this.name = name;
        this.number = number;
        this.cityID = cityID;
        this.registrationNumber = registrationNumber;
        this.taxIDNumber = taxIDNumber;
    }

    public int getCompanyID() {
        return companyID;
    }

    public void setCompanyID(int companyID) {
        this.companyID = companyID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getCityID() {
        return cityID;
    }

    public void setCityID(int cityID) {
        this.cityID = cityID;
    }

    public int getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(int registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public int getTaxIDNumber() {
        return taxIDNumber;
    }

    public void setTaxIDNumber(int taxIDNumber) {
        this.taxIDNumber = taxIDNumber;
    }
    
    
}
