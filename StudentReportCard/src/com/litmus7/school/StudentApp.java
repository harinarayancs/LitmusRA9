package com.litmus7.school;

import com.litmus7.school.dto.Student;
import java.util.Scanner;

public class StudentApp {
    public static void main(String a[]) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("How many students do you want to enter? ");
        int count = scanner.nextInt();

        Student students[] = new Student[count];

        for (int i = 0; i < count; i++) {
            System.out.println("\nEnter details for Student " + (i + 1));
            students[i] = new Student();
            students[i].inputDetails();
        }

        System.out.println("\n===== All Report Cards =====");
        for (Student student : students) {
            student.printReportCard();
        }

        scanner.close();
    }
}
