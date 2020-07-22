package Application;

import Entities.Department;
import Entities.Enums.WorkerLevel;
import Entities.HourContratct;
import Entities.Worker;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class ProgramWorker {
    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        Scanner input = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Enter department's name: ");
        String departmentName = input.nextLine();

        System.out.println("Enter worker data: ");
        System.out.print("Name: ");
        String workerName = input.nextLine();

        System.out.print("Level: ");
        String workerLevel = input.nextLine();

        System.out.print("Base salary: ");
        double baseSalary = input.nextDouble();

        Worker worker = new Worker(
                workerName,
                WorkerLevel.valueOf(workerLevel),
                baseSalary,
                new Department(departmentName)
        );

        System.out.println("How many contracts to this worker ?");
        int numberOfContracts = input.nextInt();

        for (int i = 0; i < numberOfContracts; i++) {
            System.out.printf("Enter contract #%d data: %n", i + 1);
            System.out.print("Date (DD/MM/YYY): ");
            Date contractDate = sdf.parse(input.next());

            System.out.print("Value per hour: ");
            double valuePerHour = input.nextDouble();

            System.out.print("Duration (hours): ");
            int hours = input.nextInt();

            HourContratct contract = new HourContratct(
                    contractDate,
                    valuePerHour,
                    hours);

            worker.addContract(contract);
        }

        System.out.println();
        System.out.print("Enter with month and year to calculate income (MM/YYYY): ");

        String monthAndYear = input.next();
        int month = Integer.parseInt(monthAndYear.substring(0, 2));
        int year = Integer.parseInt(monthAndYear.substring(3));

        System.out.println("Name: " + worker.getName());
        System.out.println("Department: " + worker.getDepartment().getName());
        System.out.println("Income for " +
                monthAndYear +
                ": " + worker.income(year, month));



    }
}
