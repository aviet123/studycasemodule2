package Entities;

import java.io.Serializable;

public class Student implements Serializable {
    private int studentID;
    private String fullName;
    private int age;
    private String address;
    private String homeTown;
    private float mathScore;
    private float literatureScore;
    private float englishScore;
    private String academicGrade;




    public Student() {
    }

    public Student(int studentID, String fullName, int age, String address, String homeTown,
                   float mathScore, float literatureScore, float englishScore) {
        this.studentID = ++studentID;
        this.fullName = fullName;
        this.age = age;
        this.address = address;
        this.homeTown = homeTown;
        this.mathScore = mathScore;
        this.literatureScore = literatureScore;
        this.englishScore = englishScore;
        this.academicGrade = getStudentPerformance();
    }

    public Student(String fullName, int age, String address, String homeTown, float mathScore,
                   float literalScore, float englishScore) {
        this.fullName = fullName;
        this.age = age;
        this.address = address;
        this.homeTown = homeTown;
        this.mathScore = mathScore;
        this.literatureScore = literalScore;
        this.englishScore = englishScore;
        this.academicGrade = getStudentPerformance();
    }

    public String getAcademicGrade() {
        return academicGrade;
    }

    public void setAcademicGrade(String academicGrade) {
        this.academicGrade = academicGrade;
    }

    public int getStudentID() {
        return studentID;
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

    public float getMathScore() {
        return mathScore;
    }

    public void setMathScore(float mathScore) {
        this.mathScore = mathScore;
    }

    public float getLiteratureScore() {
        return literatureScore;
    }

    public void setLiteratureScore(float literatureScore) {
        this.literatureScore = literatureScore;
    }

    public float getEnglishScore() {
        return englishScore;
    }

    public void setEnglishScore(float englishScore) {
        this.englishScore = englishScore;
    }

    public float getAverageScore(){
        return (mathScore + englishScore + literatureScore)/3;
    }

    public String getStudentPerformance(){
            if (getAverageScore() < 5.0)
                return "Weak";
            else if (getAverageScore() >= 5.0 && getAverageScore() < 7.0)
                return "Normal";
            else if (getAverageScore() >= 7.0 && getAverageScore() < 8.0)
                return "Good";
            else if (getAverageScore() >= 8.0 && getAverageScore() < 9.0)
                return "Very Good";
            else if (getAverageScore() == 10.0)
                return "Excellent";
            else
                return "your score is out of bound!!";
        }


    @Override
    public String toString() {
        return  "StudentID: " + studentID +
                "| FullName: '" + fullName + '\'' +
                "| Age: " + age +
                "| Address: '" + address + '\'' +
                "| HomeTown: '" + homeTown + '\'' +
                "| MathScore: " + mathScore +
                "| LiteratureScore: " + literatureScore +
                "| EnglishScore: " + englishScore +
                "| AcademicGrade: '" + academicGrade + '\'';
    }
}
