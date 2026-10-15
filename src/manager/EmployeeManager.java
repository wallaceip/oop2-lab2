package manager;

import problemdomain.*;

import java.io.*;
import java.util.*;

public class EmployeeManager {
    //constants
    private final String FILE_NAME = "res/employees.txt";
    //attributes
    private ArrayList<Employee> employees;
    private Scanner keyboard = new Scanner(System.in);

    public EmployeeManager() {
        loadEmployeeList();
        calculateAverageWeeklySalary();
        findHighestWagesPerson();
        findLowestSalariedPerson();
        calculateSalariedPercentage();
        calculateWagesPercentage();
        calculatePartTimePercentage();
    }

    private void loadEmployeeList() {
        employees = new ArrayList<>();
        try (Scanner inFile = new Scanner(new File(FILE_NAME))) {
            while (inFile.hasNextLine()) {
                String line = inFile.nextLine();
                // Note: Check if your employees.txt uses ";" or "," as the delimiter
                String[] parts = line.split(":");
                String id = parts[0];
                char firstDigit = id.charAt(0);

                switch (firstDigit) {
                    case '0':
                    case '1':
                    case '2':
                    case '3':
                    case '4':
                        Salaried salaried = new Salaried(
                                parts[0], parts[1], parts[2], parts[3],
                                Long.parseLong(parts[4]), parts[5], parts[6],
                                Double.parseDouble(parts[7]));
                        employees.add(salaried);
                        break;

                    case '5':
                    case '6':
                    case '7':
                        Wages wages = new Wages(
                                parts[0], parts[1], parts[2], parts[3],
                                Long.parseLong(parts[4]), parts[5], parts[6],
                                Double.parseDouble(parts[7]), Double.parseDouble(parts[8]));
                        employees.add(wages);
                        break;

                    case '8':
                    case '9':
                        PartTime partTime = new PartTime(
                                parts[0], parts[1], parts[2], parts[3],
                                Long.parseLong(parts[4]), parts[5], parts[6],
                                Double.parseDouble(parts[7]),  Double.parseDouble(parts[8]));
                        employees.add(partTime);
                        break;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void calculateAverageWeeklySalary() {
        double totalWeeklySalary = 0;
        for (Employee employee : employees) {
            totalWeeklySalary += employee.getPay();
        }
        double averageWeeklySalary = totalWeeklySalary / employees.size();
        System.out.println("The average pay for all employees is: " + averageWeeklySalary);
    }

    public void findHighestWagesPerson() {
        double highestPay = 0;
        String highestWagesPerson = null;
        for (Employee employee : employees) {
            if (highestPay < employee.getPay() && (employee instanceof Wages)) {
                highestPay = employee.getPay();
                highestWagesPerson = employee.getName();
            }
        }
        System.out.println("The Wages employee with the highest pay is: " + highestWagesPerson);
    }

    public void findLowestSalariedPerson() {
        double lowestPay = Double.MAX_VALUE;
        String lowestSalariedPerson = null;
        for (Employee employee : employees) {
            if (lowestPay > employee.getPay() && (employee instanceof Salaried)) {
                lowestPay = employee.getPay();
                lowestSalariedPerson = employee.getName();
            }
        }
        System.out.println("The Salaried employee with the lowest pay is: " + lowestSalariedPerson);
    }

    public void calculateSalariedPercentage() {
        int salariedCount = 0;
        for (Employee employee : employees) {
            if (employee instanceof Salaried) {
                salariedCount++;
            }
        }
        double salariedPercentage = ((double)salariedCount * 100 / employees.size());
        System.out.println("Percentage of Salaried employee is: " + salariedPercentage + "%");
    }

    public void calculateWagesPercentage() {
        int wagesCount = 0;
        for (Employee employee : employees) {
            if (employee instanceof Wages) {
                wagesCount++;
            }
        }
        double wagesPercentage = ((double) wagesCount * 100 / employees.size());
        System.out.println("Percentage of Wages employee is: " + wagesPercentage + "%");
    }

    public void calculatePartTimePercentage() {
        int partTimeCount = 0;
        for (Employee employee : employees) {
            if (employee instanceof PartTime) {
                partTimeCount++;
            }
        }
        double partTimePercentage = ((double) partTimeCount * 100 / employees.size());
        System.out.println("Percentage of Part Time employee is: " + partTimePercentage + "%");
    }
}
