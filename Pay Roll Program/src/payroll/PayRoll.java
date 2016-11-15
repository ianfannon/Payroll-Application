/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package payroll;

import payroll.employee.Employee;

/**
 *
 * @author Ian James Fannon
 */
public class PayRoll {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Employee worker = new Employee();
        worker.setInput();
        worker.checkHours(worker.getPayRate(), worker.getDailyHours());
        worker.printPay(worker.getGrossPay(), worker.getHours(), worker.getDeductions(), worker.getNetPay(), worker.getOverTime(), worker.getPayRate());
    }
    
}
