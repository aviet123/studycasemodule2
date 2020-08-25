package DataAccess;

import Entities.Student;
import Entities.Teacher;

import java.io.*;
import java.util.List;


public class ConnectToFile {


    public static void writeObjectToFile(Object Obj,String filepath){
        try{
            FileOutputStream ops = new FileOutputStream(filepath,false);
            ObjectOutputStream oos = new ObjectOutputStream(ops);
            oos.writeObject(Obj);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static List<Student> readStudentFromFile(String filepath) throws Exception {
            FileInputStream fileIn = new FileInputStream(filepath);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            List<Student> list = (List<Student>) objectIn.readObject();
            objectIn.close();
            return list;
    }
    public static List<Teacher> readTeacherFromFile(String filepath) throws Exception{
            FileInputStream fileIn = new FileInputStream(filepath);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            List<Teacher> list = (List<Teacher>) objectIn.readObject();
            objectIn.close();
            return list;
    }
}
