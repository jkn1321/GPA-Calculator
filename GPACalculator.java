import java.util.Scanner;

public class GPACalculator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double totalPoints = 0;
        int totalCredits = 0;

        int subjects;
        do {
            System.out.print("Enter number of subjects: ");
            subjects = sc.nextInt();
            if (subjects <= 0) {
                System.out.println(" - Number of subjects must be greater than 0!\n");
            }
        } while (subjects <= 0);

        for (int i = 1; i <= subjects; i++) {

            System.out.println("\nSubject " + i);

            String subjectName;
            do {
                System.out.print("Enter Subject Name: ");
                subjectName = sc.next();
                if (subjectName.trim().isEmpty()) {
                    System.out.println(" - Subject name cannot be empty!\n");
                }
            } while (subjectName.trim().isEmpty());

            String grade;
            double gradePoint = 0;
            String status = "";
            boolean validGrade;

            do {
                System.out.print("Enter grade: ");
                grade = sc.next().toUpperCase();
                validGrade = true;

                // Convert grade to grade point
                switch (grade) {
                    case "A+":
                        gradePoint = 4.00;
                        status = "Pass";
                        break;
                    case "A":
                        gradePoint = 4.00;
                        status = "Pass";
                        break;
                    case "A-":
                        gradePoint = 3.70;
                        status = "Pass";
                        break;
                    case "B+":
                        gradePoint = 3.30;
                        status = "Pass";
                        break;
                    case "B":
                        gradePoint = 3.00;
                        status = "Pass";
                        break;
                    case "B-":
                        gradePoint = 2.70;
                        status = "Pass";
                        break;
                    case "C+":
                        gradePoint = 2.30;
                        status = "Pass";
                        break;
                    case "C":
                        gradePoint = 2.00;
                        status = "Pass";
                        break;
                    case "C-":
                        gradePoint = 1.70;
                        status = "Repeat";
                        break;
                    case "D+":
                        gradePoint = 1.30;
                        status = "Repeat";
                        break;
                    case "D":
                        gradePoint = 1.00;
                        status = "Repeat";
                        break;
                    case "E":
                        gradePoint = 0.00;
                        status = "Repeat";
                        break;
                    case "F":
                        gradePoint = 0.00;
                        status = "Repeat";
                        break;
                    case "MC":
                        gradePoint = 0.00;
                        status = "MC";
                        break;
                    default:
                        System.out.println("\nInvalid grade entered!\n");
                        validGrade = false;
                        break;
                }
            } while (!validGrade);

            int credit;
            do {
                System.out.print("Enter credit value: ");
                credit = sc.nextInt();
                if (credit <= 0) {
                    System.out.println(" - Credit value must be greater than 0!\n");
                }
            } while (credit <= 0);

            System.out.println("Status: " + status);

            totalPoints += gradePoint * credit;
            System.out.println("\nTotal Points: " + totalPoints);
            totalCredits += credit;
            System.out.println("Total Credits: " + totalCredits);
        }

        double gpa = totalPoints / totalCredits;

        System.out.println("\nYour GPA is: " + gpa);

        sc.close();
    }
}
