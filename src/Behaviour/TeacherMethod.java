package Behaviour;

import DataAccess.ConnectToFile;
import Entities.Teacher;
import IService.IService;
import java.util.ArrayList;
import java.util.List;

public class TeacherMethod implements IService {
    public static List<Teacher> teachers = new ArrayList<>();

    static{
        try{
            List<Teacher> lists = ConnectToFile.readTeacherFromFile("teacher.dat");
            if( lists!=null) teachers = lists;
        } catch(Exception e){
            System.out.println("lỗi k đọc file");
        }
    }

    @Override
    public void add(Object o) {
        Teacher c = (Teacher) o;
        teachers.add(c);
    }
    @Override
    public void update(int id, Object o) {
        Teacher c = (Teacher) o;
        for (Teacher teacher : teachers) {
            if (id == teacher.getTeacherID()) {
                teacher.setFullName(c.getFullName());
                teacher.setAge(c.getAge());
                teacher.setAddress(c.getAddress());
                teacher.setHomeTown(c.getHomeTown());
                teacher.setYearIn(c.getYearIn());
                teacher.setCurrentYear(c.getCurrentYear());
                teacher.setSpecialization(c.getSpecialization());
            }
        }
    }

    @Override
    public void getAll() {
        DisplayList.displayTeacher(teachers);
    }

    @Override
    public void delete(int id) {
        Teacher c = new Teacher();
        for (Teacher teacher : teachers){
            if (id == teacher.getTeacherID())
            c = teacher;
        }
        teachers.remove(c);
    }
    public int getHighestExp(){
        int maxExp = 0;
        for (Teacher t : teachers) {
            if (t.getYearExp() > maxExp)
                 maxExp = t.getYearExp();
        }
        return maxExp;
    }
    public Teacher searchLETeacher(){
        for (Teacher t : teachers){
            if (t.getYearExp() == getHighestExp())
                return t;
        }
        return null;
    }
    public Teacher searchSpecificTeacher(){
        for (Teacher teacher : teachers){
            if (teacher.getYearExp() > 5 && "Mathematics".equals(teacher.getSpecialization()))
                return teacher;
        }
        return null;
    }
}
