/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package studentPractices.main;
import studentPractices.repository.MajorRepository;
import studentPractices.repository.PracticesRepository;
/**
 *
 * @author student2
 */
public class StudentPractices {

    public static void main(String[] args) {
        PracticesRepository test = new PracticesRepository();
        System.out.println(test.getAll().get(0).getEndDate());
    }
}
