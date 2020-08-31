package View;

import Behaviour.StudentMethod;
import Behaviour.TeacherMethod;
import DataAccess.ConnectToFile;
import Entities.Student;
import Entities.Teacher;

import java.util.Scanner;

public class View {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        StudentMethod studentmethod = new StudentMethod();
        TeacherMethod teacherMethod = new TeacherMethod();
        do {
            startApp:
            {
                System.out.println("1: Student Management");
                System.out.println("2: Teacher Management");
                System.out.println("0: Exit");
                System.out.println("Enter your choice: ");
                int choice;
                do {
                    try {
                        choice = Integer.parseInt(input.nextLine());
                        break;
                    }catch (Exception e){
                        System.out.println("Please enter again!!");
                    }
                }while (true);
                if (choice == 1) {
                    do {
                        selectAppStudent();
                        int choice2 = Integer.parseInt(input.nextLine());
                        switch (choice2) {
                            case 1:
                                addStudentToList(input, studentmethod);
                                break;
                            case 2:
                                System.out.println("Enter studentID to remove: ");
                                int id2 = Integer.parseInt(input.nextLine());
                                studentmethod.delete(id2);
                                break;
                            case 3:
                                editStudent(input, studentmethod);
                                break;
                            case 4:
                                studentmethod.getAll();
                                break;
                            case 5:
                                System.out.println("Highest Average Score is: " + studentmethod.getHighestAvScore());
                                break;
                            case 6:
                                System.out.println("Best Performance Student: " + studentmethod.getBestStudent());
                                break;
                            case 7:
                                ConnectToFile.writeObjectToFile(StudentMethod.students,"student.dat");
                                break;
                            default:
                                break startApp;
                        }
                    } while (true);
                } else if (choice == 2) {
                    do {
                        selectAppTeacher();
                        int choice2 = Integer.parseInt(input.nextLine());
                        switch (choice2){
                            case 1:
                                addTeacherToList(input, teacherMethod);
                                break;
                            case 2:
                                System.out.println("Enter teacherID to remove: ");
                                int id1 = Integer.parseInt(input.nextLine());
                                teacherMethod.delete(id1);
                                break;
                            case 3:
                                editTeacher(input, teacherMethod);
                                break;
                            case 4:
                                teacherMethod.getAll();
                                break;
                            case 5:
                                System.out.println("Teacher having longest exp is: "+ teacherMethod.searchLETeacher()
                                        +"with the exp is: " + teacherMethod.getHighestExp());
                                break;
                            case 6:
                                System.out.println("Teacher having more than 5 years exp and specialize in Math: "+ teacherMethod.searchSpecificTeacher());
                                break;
                            case 7:
                                ConnectToFile.writeObjectToFile(TeacherMethod.teachers,"teacher.dat");
                                break;
                            default:
                                break startApp;
                        }
                    }while(true);
                } else {
                    System.exit(0);
                }
            }
        } while (true);
    }

    private static void editTeacher(Scanner input, TeacherMethod teacherMethod) {
        System.out.println("Enter Id to change: ");
        int id;
        do {
            try {
                id = Integer.parseInt(input.nextLine());
                break;
            }catch (Exception e){
                System.out.println("Wrong format! Please enter again!!");
            }
        }while (true);
        String[] sp2 = {"Mathematics","Physical","Chemistry","Language","Literature"};
        System.out.println("Enter teacher's fullName: ");
        String fullNameEdit = input.nextLine();
        System.out.println("Enter teacher's age: ");
        int ageEdit;
        do {
            try {
                ageEdit = Integer.parseInt(input.nextLine());
                break;
            }catch (Exception e){
                System.out.println("Wrong format! Please enter again!!");
            }
        }while (true);
        System.out.println("Enter teacher's address: ");
        String addressEdit = input.nextLine();
        System.out.println("Enter teacher's hometown: ");
        String hometownEdit = input.nextLine();
        System.out.println("Enter yearIn need to edit: ");
        int yearInEdit;
        do {
            try {
                yearInEdit = Integer.parseInt(input.nextLine());
                break;
            }catch (Exception e){
                System.out.println("Wrong format! Please enter again!!");
            }
        }while (true);
        System.out.println("Enter current year teacher is teaching: ");
        int currentYearEdit;
        do {
            try {
                currentYearEdit = Integer.parseInt(input.nextLine());
                break;
            }catch (Exception e){
                System.out.println("Wrong format! Please enter again!!");
            }
        }while (true);
        System.out.println("Enter specialization of teacher: ");
        System.out.println("1. Mathematics \n2. Physical\n3. Chemistry\n4. Chemistry\n5. Literature");
        int selection2;
        do {
            try {
                selection2 = Integer.parseInt(input.nextLine());
                break;
            }catch (Exception e){
                System.out.println("Wrong format! Please enter again!!");
            }
        }while (true);
        String specializationEdit = sp2[selection2-1];
        teacherMethod.update(id,new Teacher(fullNameEdit,ageEdit,addressEdit,hometownEdit,yearInEdit,
                currentYearEdit,specializationEdit));
    }

    private static void addTeacherToList(Scanner input, TeacherMethod teacherMethod) {
        String[] sp = {"Mathematics","Physical","Chemistry","Language","Literature"};
        System.out.println("Enter teacher's fullName: ");
        String fullName = input.nextLine();
        System.out.println("Enter teacher's age: ");
        int age;
        do {
            try {
                age = Integer.parseInt(input.nextLine());
                break;
            }catch (Exception e){
                System.out.println("Wrong format! Please enter again!!");
            }
        }while (true);
        System.out.println("Enter teacher's address: ");
        String address = input.nextLine();
        System.out.println("Enter teacher's hometown: ");
        String hometown = input.nextLine();
        System.out.println("Enter year teacher get in: ");
        int yearIn;
        do {
            try {
                yearIn = Integer.parseInt(input.nextLine());
                break;
            }catch (Exception e){
                System.out.println("Wrong format! Please enter again!!");
            }
        }while (true);
        System.out.println("Enter current year teacher is teaching: ");
        int currentYear;
        do {
            try {
                currentYear = Integer.parseInt(input.nextLine());
                break;
            }catch (Exception e){
                System.out.println("Wrong format! Please enter again!!");
            }
        }while (true);
        System.out.println("Enter specialization of teacher: ");
        System.out.println("1. Mathematics \n2. Physical\n3. Chemistry\n4. Chemistry\n5. Literature");
        int selection;
        do {
            try {
                selection = Integer.parseInt(input.nextLine());
                break;
            }catch (Exception e){
                System.out.println("Wrong format! Please enter again!!");
            }
        }while (true);
        String specialization = sp[selection-1];
        int teacherID = teacherMethod.checkIDTeacherFromFile();
        teacherMethod.add(new Teacher(teacherID,fullName,age,address,hometown,yearIn,currentYear,specialization));
    }

    private static void editStudent(Scanner input, StudentMethod studentmethod) {
        System.out.println("Enter Id to change: ");
        int id;
        do {
            try {
                id = Integer.parseInt(input.nextLine());
                break;
            }catch (Exception e){
                System.out.println("Wrong format! Please enter again!!");
            }
        }while (true);
        System.out.println("Enter name needing to edit");
        String name = input.nextLine();
        System.out.println("Enter age needing to edit");
        int ageEdit;
        do {
            try {
                ageEdit = Integer.parseInt(input.nextLine());
                break;
            }catch (Exception e){
                System.out.println("Wrong format! Please enter again!!");
            }
        }while (true);
        System.out.println("Enter address needing to edit: ");
        String addressEdit = input.nextLine();
        System.out.println("Enter hometown needing to edit");
        String hometownEdit = input.nextLine();
        System.out.println("Enter math score needing to edit");
        float mathScoreEdit;
        do {
            try {
                mathScoreEdit = Float.parseFloat(input.nextLine());
                break;
            }catch (Exception e){
                System.out.println("Wrong format! Please enter again!!");
            }
        }while (true);
        System.out.println("Enter literature score needing to edit");
        float literatureScoreEdit;
        do {
            try {
                literatureScoreEdit = Float.parseFloat(input.nextLine());
                break;
            }catch (Exception e){
                System.out.println("Wrong format! Please enter again!!");
            }
        }while (true);
        System.out.println("Enter english score needing to edit");
        float englishScoreEdit;
        do {
            try {
                englishScoreEdit = Float.parseFloat(input.nextLine());
                break;
            }catch (Exception e){
                System.out.println("Wrong format! Please enter again!!");
            }
        }while (true);
        studentmethod.update(id,new Student(name,ageEdit,addressEdit,hometownEdit,
                mathScoreEdit,literatureScoreEdit,englishScoreEdit));
    }
    private static void addStudentToList(Scanner input, StudentMethod studentmethod) {
        System.out.println("Enter student's fullName: ");
        String fullName = input.nextLine();
        System.out.println("Enter student's age: ");
        int age;
        do {
            try {
                age = Integer.parseInt(input.nextLine());
                break;
            }catch (Exception e){
                System.out.println("Wrong format! Please enter again!!");
            }
        }while (true);
        System.out.println("Enter student's address: ");
        String address = input.nextLine();
        System.out.println("Enter student's hometown: ");
        String hometown = input.nextLine();
        System.out.println("Enter student's mathScore: ");
        float mathScore;
        do {
            try {
                mathScore = Float.parseFloat(input.nextLine());
                break;
            }catch (Exception e){
                System.out.println("Wrong format! Please enter again!!");
            }
        }while (true);
        System.out.println("Enter student's literatureScore: ");
        float literatureScore;
        do {
            try {
                literatureScore = Float.parseFloat(input.nextLine());
                break;
            }catch (Exception e){
                System.out.println("Wrong format! Please enter again!!");
            }
        }while (true);
        System.out.println("Enter student's englishScore: ");
        float englishScore;
        do {
            try {
                englishScore = Float.parseFloat(input.nextLine());
                break;
            }catch (Exception e){
                System.out.println("Wrong format! Please enter again!!");
            }
        }while (true);
        int studentID = studentmethod.checkIDFromFile();
        studentmethod.add(new Student(studentID,fullName,age,address,hometown,mathScore,literatureScore,englishScore));
    }

    private static void selectAppTeacher() {
        System.out.println("1: Add Teacher");
        System.out.println("2: Remove");
        System.out.println("3: Edit");
        System.out.println("4: Get All");
        System.out.println("5. Search teacher having longest exp:");
        System.out.println("6. Search for specific teacher ");
        System.out.println("7. Write to file");
        System.out.println("0: Back");
    }
    private static void selectAppStudent() {
        System.out.println("1: Add Student");
        System.out.println("2: Remove Student");
        System.out.println("3: Edit Student");
        System.out.println("4: Get All");
        System.out.println("5. Get Highest AverageScore");
        System.out.println("6. Get Best Performance Student ");
        System.out.println("7. Write to file");
        System.out.println("0: Back");
    }
}
