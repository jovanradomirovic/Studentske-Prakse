/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentPractices.domain;

/**
 *
 * @author student2
 */
public class Student {
    private int studentID;
    private String name;
    private String surname;
    private String address;
    private String number;
    private String index;
    private int majorID;
    private int moduleID;

    public Student(int studentID, String name, String surname, String address, String number, String index, int majorID, int moduleID) {
        this.studentID = studentID;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.number = number;
        this.index = index;
        this.majorID = majorID;
        this.moduleID = moduleID;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public int getMajorID() {
        return majorID;
    }

    public void setMajorID(int majorID) {
        this.majorID = majorID;
    }

    public int getModuleID() {
        return moduleID;
    }

    public void setModuleID(int moduleID) {
        this.moduleID = moduleID;
    }
    
}
