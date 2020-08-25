package Behaviour;

import DataAccess.ConnectToFile;
import Entities.Student;
import IService.IService;
import java.util.ArrayList;
import java.util.List;

public class StudentMethod implements IService {
    public static List<Student> students = new ArrayList<>();
    static{
        try{
            List<Student> lists = ConnectToFile.readStudentFromFile("student.dat");
            if( lists!=null)students = lists;
        } catch(Exception e){
            System.out.println("lỗi k đọc file");
        }
    }

    @Override
    public void add(Object o) {
        Student c = (Student) o;
        students.add(c);
    }

    @Override
    public void update(int id, Object o) {
        Student c = (Student) o;
        for (Student student: students) {
            if (id == student.getStudentID()) {
                student.setFullName(c.getFullName());
                student.setAge(c.getAge());
                student.setAddress(c.getAddress());
                student.setHomeTown(c.getHomeTown());
                student.setMathScore(c.getMathScore());
                student.setLiteratureScore(c.getLiteratureScore());
                student.setEnglishScore(c.getEnglishScore());
                student.setAcademicGrade(c.getAcademicGrade());
            }
        }
    }
    @Override
    public void getAll() {
        for (Student student: students){
            System.out.println(student.toString());
        }
    }
    @Override
    public void delete(int id) {
        Student c = new Student();
        for (Student student: students){
            if (student.getStudentID() == id)
                c = student;
        }
        students.remove(c);
    }

    public double getHighestAvScore() {
        double highestAvScore = 0;
        for (Student student: students){
            if (student.getAverageScore() > highestAvScore)
                highestAvScore = student.getAverageScore();
        }
        return highestAvScore;
    }

    public Student getBestStudent(){
        for (Student student: students){
            if (student.getAverageScore() == getHighestAvScore())
                return student;
        }
        return null;
    }
}
