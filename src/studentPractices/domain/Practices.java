/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentPractices.domain;

import java.time.LocalDate;

/**
 *
 * @author radom
 */
public class Practices {
    private int practiceID;
    private String position;
    private LocalDate startDate;
    private LocalDate endDate;
    private int companyID;
    private int yearID;
    private int cityID;
    private int studentID;
    private int contractID;

    public Practices(String position, LocalDate startDate, LocalDate endDate, int companyID, int yearID, int cityID) {
        this.position = position;
        this.startDate = startDate;
        this.endDate = endDate;
        this.companyID = companyID;
        this.yearID = yearID;
        this.cityID = cityID;
    }

    public Practices() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getPracticeID() {
        return practiceID;
    }

    public void setPracticeID(int practiceID) {
        this.practiceID = practiceID;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public int getCompanyID() {
        return companyID;
    }

    public void setCompanyID(int companyID) {
        this.companyID = companyID;
    }

    public int getYearID() {
        return yearID;
    }

    public void setYearID(int yearID) {
        this.yearID = yearID;
    }

    public int getCityID() {
        return cityID;
    }

    public void setCityID(int cityID) {
        this.cityID = cityID;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public int getContractID() {
        return contractID;
    }

    public void setContractID(int contractID) {
        this.contractID = contractID;
    }
    
    
}
