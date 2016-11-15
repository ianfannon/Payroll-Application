/*
 * A program to calculate a seven day payroll.
 * Created: 11/14/2016
 * Programmer: Ian James Fannon
 */
package payroll.employee;

import java.text.NumberFormat;
import java.util.InputMismatchException;
import java.util.Scanner;
import payroll.weekdays.WeekDays;

/**
 *
 * @author Ian James Fannon
 */
public class Employee implements Employees{

    private double grossPay;
    private final double[] dailyHours;
    private double netPay;
    private double deductions;
    private double payRate;
    private double overTimePay;
    private double hours;
    private double overTimeHours;
    private double fedTax;
    private double stateTax;
    private double socialSecurity;
    private double medicare;
    private String name;
    private NumberFormat format;
    
    public Employee() {
        this.grossPay = 0.0;
        this.dailyHours = new double[7];
        this.netPay = 0.0;
        this.deductions = 0.0;
        this.payRate = 0.0;
        this.overTimePay = 0.0;
        this.hours = 0.0;
        this.overTimeHours = 0.0;
        this.fedTax = 0.0;
        this.stateTax = 0.0;
        this.socialSecurity = 0.0;
        this.medicare = 0.0;
        this.name = "";
        this.format = NumberFormat.getCurrencyInstance();
    }
    
    @Override
    public double getGrossPay() {
        return grossPay;
    }

    @Override
    public double[] getDailyHours() {
        return dailyHours;
    }

    @Override
    public double getDeductions() {
        return deductions;
    }

    @Override
    public double getNetPay() {
        return netPay;
    }

    @Override
    public double getPayRate() {
        return payRate;
    }

    @Override
    public double getOverTime() {
        return overTimePay;
    }

    @Override
    public double getHours() {
        return hours;
    }
    
    @Override
    public void setInput() {
        try {
            int count = 0;
            Scanner input = new Scanner(System.in);
            do {
                System.out.print("Enter employee's full name: ");
                name = input.nextLine();
            } while (!name.matches("([a-zA-Z ]+)"));
            do {
                do {
                    System.out.print("Enter hourly pay rate: ");
                    payRate = input.nextDouble();
                    count++;
                    System.out.print("Enter hours worked on " + WeekDays.SUNDAY.getDays() + ": ");
                    dailyHours[0] = input.nextDouble();
                    count++;
                    System.out.print("Enter hours worked on " + WeekDays.MONDAY.getDays() + ": ");
                    dailyHours[1] = input.nextDouble();
                    count++;
                    System.out.print("Enter hours worked on " + WeekDays.TUESDAY.getDays() + ": ");
                    dailyHours[2] = input.nextDouble();
                    count++;
                    System.out.print("Enter hours worked on " + WeekDays.WEDNESDAY.getDays() + ": ");
                    dailyHours[3] = input.nextDouble();
                    count++;
                    System.out.print("Enter hours worked on " + WeekDays.THURSDAY.getDays() + ": ");
                    dailyHours[4] = input.nextDouble();
                    count++;
                    System.out.print("Enter hours worked on " + WeekDays.FRIDAY.getDays() + ": ");
                    dailyHours[5] = input.nextDouble();
                    count++;
                    System.out.print("Enter hours worked on " + WeekDays.SATURDAY.getDays() + ": ");
                    dailyHours[6] = input.nextDouble();
                } while (payRate <= 0.0 && payRate >= 200.00 && dailyHours[count - 1] <= 0.0 && dailyHours[count - 1] >= 24);    
            } while (count == 6);
        } catch(InputMismatchException | NumberFormatException ex) {
            System.out.println("Invalid Input " + ex.getMessage());
        }
    }

    @Override
    public void checkHours(double newPayRate, double[] newDailyHours) {
        for (int index = 0; index < dailyHours.length; index++) {
            hours = hours + dailyHours[index];
        }
        if (hours <= 40.00) {
            grossPay = hours * newPayRate; 
        } else if (hours > 40.00) {
            overTimeHours = hours - 40.00;
            overTimePay = payRate * (1.5 * overTimeHours);
            grossPay = (payRate * 40.00) + overTimePay;
        }
        fedTax = grossPay * FEDERAL_TAX;
        stateTax = grossPay * STATE_TAX;
        socialSecurity = grossPay * SOCIAL_SECURITY;
        medicare = grossPay * MEDICARE;
        deductions = fedTax + stateTax + socialSecurity + medicare;
        netPay = grossPay - deductions;
    }

    @Override
    public void printPay(double newGrossPay, double newHours, double newDeductions, double newNetPay, double newOverTime, double newPayRate) {
        if (newHours <= 40.00) {
            System.out.println("-------------Payroll Summary-------------");
            System.out.printf("\nEmployee: %S\n", name);
            System.out.printf("Gross Pay: %S\n", format.format(newGrossPay));
            System.out.printf("Total Hours: %2f\n", newHours);
            System.out.printf("Total Deductions: %S\n", format.format(newDeductions));
            System.out.printf("Federal Tax: %S\nState Tax: %S\nSocial Security: %S\nMedicare: %S\n", format.format(fedTax), format.format(stateTax),
                    format.format(socialSecurity), format.format(medicare));
            System.out.printf("Net Pay: %S", format.format(newNetPay));
        } else if (newHours > 40.00) {
            System.out.println("-------------Payroll Summary-------------");
            System.out.printf("\nEmployee: %S\n", name);
            System.out.printf("\nOver Time Pay: %S\n", format.format(newOverTime));
            System.out.printf("Gross Pay: %S\n", format.format(newGrossPay));
            System.out.printf("Total Hours: %2f\n", newHours);
            System.out.printf("Over Time Hours %2f\n", overTimeHours);
            System.out.printf("Total Deductions: %S\n", format.format(newDeductions));
            System.out.printf("Federal Tax: %S\nState Tax: %S\nSocial Security: %S\nMedicare: %S\n", format.format(fedTax), format.format(stateTax),
                    format.format(socialSecurity), format.format(medicare));
            System.out.printf("Net Pay: %S", format.format(newNetPay));
        }
    }
    
}
