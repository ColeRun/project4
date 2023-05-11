package edu.guilford;

import java.util.Random;

public class Student {
    private String studentName;
    private int studentID;
    private double guilfordCredits;
    private double transferCredits;
    private double examCredits;
    private boolean studyAway;
    private boolean inSeason;
    private double GPA;
    private boolean workStudy;
    private boolean finAid;
    private boolean athlete;
    private boolean onCampus;
    private boolean Honors;
    private String guilfordSport;

    public String getGuilfordSport() {
        return guilfordSport;
    }

    public void setGuilfordSport(String guilfordSport) {
        this.guilfordSport = guilfordSport;
    }

    public boolean isInSeason() {
        return inSeason;
    }

    public void setInSeason(boolean inSeason) {
        this.inSeason = inSeason;
    }

    public boolean isFinAid() {
        return finAid;
    }

    public void setFinAid(boolean finAid) {
        this.finAid = finAid;
    }

    public boolean isAthlete() {
        return athlete;
    }

    public void setAthlete(boolean athlete) {
        this.athlete = athlete;
    }

    public boolean isOnCampus() {
        return onCampus;
    }

    public void setOnCampus(boolean onCampus) {
        this.onCampus = onCampus;
    }

    public boolean isHonors() {
        return Honors;
    }

    public void setHonors(boolean Honors) {
        this.Honors = Honors;
    }

    public double getGPA() {
        return GPA;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }

    public boolean isWorkStudy() {
        return workStudy;
    }

    public void setWorkStudy(boolean workStudy) {
        this.workStudy = workStudy;
    }

    public Student() {
        this.studentName = studentName;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public double getGuilfordCredits() {
        return guilfordCredits;
    }

    public void setGuilfordCredits(double guilfordCredits) {
        this.guilfordCredits = guilfordCredits;
    }

    public double getTransferCredits() {
        return transferCredits;
    }

    public void setTransferCredits(double transferCredits) {
        this.transferCredits = transferCredits;
    }

    public double getExamCredits() {
        return examCredits;
    }

    public void setExamCredits(double examCredits) {
        this.examCredits = examCredits;
    }

    public boolean isStudyAway() {
        return studyAway;
    }

    public void setStudyAway(boolean studyAway) {
        this.studyAway = studyAway;
    }

    public Student(String studentName, int studentID,
            double guilfordCredits, double transferCredits, double examCredits,
            boolean studyAway, boolean athlete, boolean inSeason,
            String guilfordSport, double GPA, boolean workStudy, boolean finAid, boolean onCampus, boolean Honors) {
        this.studentName = studentName;
        this.studentID = studentID;
        this.guilfordCredits = guilfordCredits;
        this.transferCredits = transferCredits;
        this.examCredits = examCredits;
        this.studyAway = studyAway;
        this.GPA = GPA;
        this.workStudy = workStudy;
        this.finAid = finAid;
        this.athlete = athlete;
        this.onCampus = onCampus;
        this.Honors = Honors;
    }

    public double calcTotalCredits() {
        double totalCredits;
        totalCredits = guilfordCredits + examCredits + transferCredits;
        return totalCredits;
    }

    public double calculateGradePoints() {
        double gradePoints;
        gradePoints = GPA * guilfordCredits;

        return gradePoints;
    }

    @Override
    public String toString() {
        String output;

        output = "Student Name: " + studentName + "\n"
                + "Student ID: " + studentID + "\n"
                + "Guilford Credits: " + String.format("%.2f", guilfordCredits) + "\n"
                + "Transfer Credits: " + String.format("%.2f", transferCredits) + "\n"
                + "Exam Credits: " + String.format("%.2f", examCredits) + "\n"
                + "Total Credits: " + (guilfordCredits + examCredits + transferCredits) + "\n"
                + "Study Away: " + studyAway + "\n"
                + "GPA: " + String.format("%.2f", GPA) + "\n"
                + "Work Study : " + workStudy + "\n"
                + "Finacial Aid? " + finAid + "\n"
                + "Current athlete? " + athlete + "\n"
                + "Living on Campus? " + onCampus + "\n"
                + "Honors? " + Honors;

        return output;
    }
    // State whether the number of Guilford credits the student has is greater than 88  

    public boolean analyzeGuilfordCredits() {
        boolean highCredits;
        highCredits = guilfordCredits > 80;
        return highCredits;
    } 
    // Evaluate whether the student has completed more than 88 Guilford credits and is an athlete  

    public boolean analyzeGuilfordCreditsAthlete() {
        boolean highCreditsAthlete;
        highCreditsAthlete = (guilfordCredits > 88) && (athlete == true);
        return highCreditsAthlete;
    }

    public boolean analyzeGPAStudyAway() {
        boolean GPAstudyAway;
        GPAstudyAway = (GPA > 3.5) || (studyAway == true);
        return GPAstudyAway;
    }
    Random randGenerator = new Random();

    public double calculatePoints() {
        double totalPoints = 0;
        double totalCredits = calcTotalCredits();
        if (totalCredits >= 88) {
            totalPoints = 4;
        } else if (totalCredits >= 56) {
            totalPoints = 3;
        } else if (totalCredits >= 24) {
            totalPoints = 4;
        } else if (totalCredits < 24) {
            totalPoints = 1;
        }
        if (studyAway) {
            int pointnumber = randGenerator.nextInt(1, 3);
            if (pointnumber == 1) {
                totalPoints = 5;
            } else {
                totalPoints = 4;
            }
        }
        return totalPoints;
        // I simply put the else if into tiers for their respective points, then implimented my groups personal choice to give athlete special bonuses
    }

}
