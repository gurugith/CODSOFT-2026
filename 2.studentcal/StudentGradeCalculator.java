import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter number of subjects: ");
            int n = sc.nextInt();

            int totalMarks = 0;

            for (int i = 1; i <= n; i++) {
                System.out.print("Enter marks for subject " + i + ": ");
                int marks = sc.nextInt();
                totalMarks += marks;
            }

            double average = (double) totalMarks / n;

            char grade;
            if (average >= 90) grade = 'A';
            else if (average >= 80) grade = 'B';
            else if (average >= 70) grade = 'C';
            else if (average >= 60) grade = 'D';
            else if (average >= 50) grade = 'E';
            else grade = 'F';

            System.out.println("Total: " + totalMarks);
            System.out.println("Average: " + average + "%");
            System.out.println("Grade: " + grade);
        }
    }
}
