package edu.guilford;

import java.util.Random;
import java.util.Scanner;
//import java.util.Arrays;
//import something here to make a linear sort
//

public class StudentSort {
    public static void main(String[] args) {
        // make 100 student objects
        // ask the user for what the size of the array should be
        Scanner input = new Scanner(System.in);
        System.out.println("How many students do you want to make?");
        int size = input.nextInt();

        Student[] students = new Student[size];
        // fill those objects with random data
        for (int i = 0; i < students.length; i++) {
            students[i] = new Student();
            students[i].setStudentName("Student " + i);
            students[i].setStudentID(i);
            students[i].setGuilfordCredits(Math.random() * 100);
            students[i].setTransferCredits(Math.random() * 100);
            students[i].setExamCredits(Math.random() * 100);
            students[i].setStudyAway(Math.random() > .5);
            students[i].setInSeason(Math.random() > .5);
            students[i].setGPA(Math.random() * 4);
            students[i].setWorkStudy(Math.random() > .5);
            students[i].setFinAid(Math.random() > .5);
            students[i].setAthlete(Math.random() > .5);
            students[i].setOnCampus(Math.random() > .5);
            students[i].setHonors(Math.random() > .5);
            students[i].setGuilfordSport("Sport " + i);
        }
        // sort the students by GPA using a linear search
        // start a timer and record the time to sort
        long startTime = System.nanoTime();
        linearSort(students);
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println("Linear sort took " + duration / 1000000 + " milliseconds to sort " + size + " students.");
        // turn the nanoseconds into millisec
        //shuffle the students
        for (int i = 0; i < students.length; i++) {
            int random = (int) (Math.random() * students.length);
            Student temp = students[i];
            students[i] = students[random];
            students[random] = temp;
        }
        //search for a random target both linear and binary
        int target = (int) (Math.random() * size);
        startTime = System.nanoTime();
        linearSearch(students, target);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("Linear search took " + duration / 1000000 + " milliseconds to search for student " + target + ".");
        for (int i = 0; i < students.length; i++) {
            int random = (int) (Math.random() * students.length);
            Student temp = students[i];
            students[i] = students[random];
            students[random] = temp;
        }
        startTime = System.nanoTime();
        binarySearch(students, target);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("Binary search took " + duration / 1000000 + " milliseconds to search for student " + target + ".");


    }

    // linear sort
    public static void linearSort(Student[] students) {
        for (int i = 0; i < students.length; i++) {
            for (int j = i; j < students.length; j++) {
                if (students[i].getGPA() > students[j].getGPA()) {
                    Student temp = students[i];
                    students[i] = students[j];
                    students[j] = temp;
                }
            }
        }
    }

    //linear search 
    public static void linearSearch(Student[] students, int target) {
        for (int i = 0; i < students.length; i++) {
            if (students[i].getStudentID() == target) {
                System.out.println("Student " + target + " is at index " + i);
                break;
            }
        }
    }
    
//binary search
    public static void binarySearch(Student[] students, int target) {
        int low = 0;
        int high = students.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (students[mid].getStudentID() == target) {
                System.out.println("Student " + target + " is at index " + mid);
                break;
            } else if (students[mid].getStudentID() < target) {
                low = mid + 1;
            } else if (students[mid].getStudentID() > target) {
                high = mid - 1;
            }
        }


     }
    }



