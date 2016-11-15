/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package payroll.employee;

/**
 *
 * @author Ian James Fannon
 */
public interface Employees {
    
    double FEDERAL_TAX = 0.11;
    double STATE_TAX = 0.04;
    double SOCIAL_SECURITY = 0.062;
    double MEDICARE = 0.11;
    
    public double getGrossPay();
    
    public double[] getDailyHours();
    
    public double getDeductions();
    
    public double getNetPay();
    
    public double getPayRate();
    
    public double getOverTime();
    
    public double getHours();
    
    public void setInput();
    
    public void checkHours(double newPayRate, double[] newDailyHours);
    
    public void printPay(double newGrossPay, double newHours, double newDeductions, double newNetPay, double newOverTime, double newPayRate);
}
