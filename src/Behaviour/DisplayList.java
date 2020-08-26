package Behaviour;

import Entities.Student;
import Entities.Teacher;

import java.util.List;

public class DisplayList {
    public static void displayStudent(List<Student> students) {
            System.out.println("\n--------------Employee List---------------\n");
            System.out.printf("%-5s%-20s%-15s%-15s%-15s%-15s%-15s%-15s%-15s%n", "ID","FullName","Age",
                    "Address","HomeTown","MathScore","LiteratureScore","EnglishScore","AcademicGrade");
            for(Student t : students) {
                System.out.printf("%-5s%-15s%-15s%-15s%-15s%-15s%-15s%-15s%-15s%n",t.getStudentID(),t.getFullName(),t.getAge(),
                        t.getAddress(),t.getHomeTown(),t.getMathScore(),t.getLiteratureScore(),t.getEnglishScore(),t.getAcademicGrade());
            }
        }
    public static void displayTeacher(List<Teacher> teachers) {
        System.out.println("\n--------------Employee List---------------\n");
        System.out.printf("%-5s%-20s%-15s%-15s%-15s%-15s%-15s%-15s%n", "ID","FullName","Age",
                "Address","HomeTown","YearIn","CurrentYear","Specialization");
        for(Teacher tc : teachers) {
            System.out.printf("%-5s%-20s%-15s%-15s%-15s%-15s%-15s%-15s%n",tc.getTeacherID(),tc.getFullName(),tc.getAge(),
                    tc.getAddress(),tc.getHomeTown(),tc.getYearIn(),tc.getCurrentYear(),tc.getSpecialization());
        }
    }
}
