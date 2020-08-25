package Entities;

import java.io.Serializable;

public class Teacher implements Serializable {
    private int teacherID;
    private String fullName;
    private int age;
    private String address;
    private String homeTown;
    private int yearIn;
    private int currentYear;
    private String specialization;

    public int getTeacherID() {
        return teacherID;
    }

    public Teacher() {
    }

    public Teacher(String fullName, int age, String address, String homeTown, int yearIn, int currentYear, String specialization) {
        this.fullName = fullName;
        this.age = age;
        this.address = address;
        this.homeTown = homeTown;
        this.yearIn = yearIn;
        this.currentYear = currentYear;
        this.specialization = specialization;
    }

    public Teacher(int teacherID, String fullName, int age, String address, String homeTown,
                   int yearIn, int currentYear, String specialization) {
        this.teacherID = ++teacherID;
        this.fullName = fullName;
        this.age = age;
        this.address = address;
        this.homeTown = homeTown;
        this.yearIn = yearIn;
        this.currentYear = currentYear;
        this.specialization = specialization;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHomeTown() {
        return homeTown;
    }

    public void setHomeTown(String homeTown) {
        this.homeTown = homeTown;
    }

    public int getYearIn() {
        return yearIn;
    }

    public void setYearIn(int yearIn) {
        this.yearIn = yearIn;
    }

    public int getCurrentYear() {
        return currentYear;
    }

    public void setCurrentYear(int currentYear) {
        this.currentYear = currentYear;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
    public int getYearExp(){
        return currentYear - yearIn;
    }

    @Override
    public String toString() {
        return  "teacherID: " + teacherID +
                ", fullName: '" + fullName + '\'' +
                ", age: " + age +
                ", address: '" + address + '\'' +
                ", homeTown: '" + homeTown + '\'' +
                ", yearIn: " + yearIn +
                ", currentYear: " + currentYear +
                ", specialization: '" + specialization + '\'';
    }
}
