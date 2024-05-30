/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentPractices.domain;

import java.time.LocalDateTime;

/**
 *
 * @author student2
 */
public class Contract {
    private int ID;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private boolean isActive;
    private int companyID;

    public Contract(int ID, LocalDateTime startDate, LocalDateTime endDate, boolean isActive, int companyID) {
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

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
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
