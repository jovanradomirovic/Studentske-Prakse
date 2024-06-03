/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentPractices.domain;

import java.time.LocalDate;

/**
 *
 * @author student2
 */
public class Contract {
    private int ID;
    private LocalDate startDate;
    private LocalDate endDate;
    private boolean isActive;
    private int companyID;

    public Contract(int ID, LocalDate startDate, LocalDate endDate, boolean isActive, int companyID) {
        this.ID = ID;
        this.startDate = startDate;
        this.endDate = endDate;
        this.isActive = isActive;
        this.companyID = companyID;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
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

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public int getCompanyID() {
        return companyID;
    }

    public void setCompanyID(int companyID) {
        this.companyID = companyID;
    }
    
}
