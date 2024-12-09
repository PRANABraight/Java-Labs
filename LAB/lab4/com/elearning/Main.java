package com.elearning;

import java.util.Scanner;
import com.elearning.course.ProgrammingCourse;
import com.elearning.course.TestPreparationCourse;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Enter a Programming Course:");
        String progCourseName = scan.nextLine();

        System.out.println("Enter a Course code:");
        String progCourseCode = scan.nextLine();

        System.out.println("Enter a Programming Language:");
        String language = scan.nextLine();

        ProgrammingCourse jCourse = new ProgrammingCourse(progCourseName, progCourseCode, language);

        System.out.println("Enter a Course Detail:");
        String det = scan.nextLine();
        jCourse.addCourseDetail(det);
        jCourse.displayCourseInfo();

        System.out.println();

        System.out.println("Enter a Test Course Name:");
        String testCourseName = scan.nextLine();

        System.out.println("Enter a Test Course Code:");
        String testCourseCode = scan.nextLine();

        System.out.println("Enter a Test Type:");
        String testType = scan.nextLine();

        TestPreparationCourse tPrep = new TestPreparationCourse(testCourseName, testCourseCode, testType);

        System.out.println("Enter Test details: ");
        String data = scan.nextLine();
        tPrep.addCourseDetail(data);
        tPrep.displayCourseInfo();

        scan.close();

    }
}



