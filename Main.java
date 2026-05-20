import java.util.Scanner;

public class Main {

    // Method to convert grade letter to grade point
    public static double getGradePoint(String grade) {
        switch (grade.toUpperCase()) {
            case "O":
                return 10.0;
            case "A+":
                return 9.0;
            case "A":
                return 8.0;
            case "B+":
                return 7.0;
            case "B":
                return 6.0;
            case "C":
                return 5.0;
            default:
                return 0.0;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("===================================");
        System.out.println("      CGPA CALCULATOR SYSTEM");
        System.out.println("===================================");

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Number of Subjects: ");
        int subjects = sc.nextInt();

        String[] subjectNames = new String[subjects];
        String[] grades = new String[subjects];
        double[] credits = new double[subjects];
        double[] gradePoints = new double[subjects];

        double totalCredits = 0;
        double weightedSum = 0;

        // Input Section
        for (int i = 0; i < subjects; i++) {

            sc.nextLine(); // clear buffer

            System.out.println("\n---------- Subject " + (i + 1) + " ----------");

            System.out.print("Enter Subject Name: ");
            subjectNames[i] = sc.nextLine();

            System.out.print("Enter Grade (O, A+, A, B+, B, C): ");
            grades[i] = sc.nextLine();

            System.out.print("Enter Credit: ");
            credits[i] = sc.nextDouble();

            gradePoints[i] = getGradePoint(grades[i]);

            weightedSum += gradePoints[i] * credits[i];
            totalCredits += credits[i];
        }

        // CGPA Calculation
        double cgpa = weightedSum / totalCredits;

        // Display Result
        System.out.println("\n===================================");
        System.out.println("         STUDENT REPORT");
        System.out.println("===================================");

        System.out.println("Student Name : " + name);

        System.out.println("\n-----------------------------------------------------------");
        System.out.printf("%-20s %-10s %-10s %-10s\n",
                "Subject", "Grade", "Credit", "Point");
        System.out.println("-----------------------------------------------------------");

        for (int i = 0; i < subjects; i++) {
            System.out.printf("%-20s %-10s %-10.1f %-10.1f\n",
                    subjectNames[i],
                    grades[i],
                    credits[i],
                    gradePoints[i]);
        }

        System.out.println("-----------------------------------------------------------");

        System.out.printf("Total Credits : %.1f\n", totalCredits);
        System.out.printf("CGPA          : %.2f\n", cgpa);

        // Performance Message
        System.out.print("Performance   : ");

        if (cgpa >= 9) {
            System.out.println("Outstanding");
        } else if (cgpa >= 8) {
            System.out.println("Excellent");
        } else if (cgpa >= 7) {
            System.out.println("Very Good");
        } else if (cgpa >= 6) {
            System.out.println("Good");
        } else {
            System.out.println("Needs Improvement");
        }

        System.out.println("===================================");

        sc.close();
    }
}