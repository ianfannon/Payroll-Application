/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package payroll.weekdays;

/**
 *
 * @author Ian James Fannon
 */
public enum WeekDays {
    SUNDAY("Sunday"), MONDAY("Monday"), TUESDAY("Tuesday"), WEDNESDAY("Wednesday"), THURSDAY("Thursday"), FRIDAY("Friday"), SATURDAY("Saturday");
    
    String days = "";
    int totalHoursOfDay;
    
    WeekDays(String newDays) {
        days = newDays;
    }
    
    public String getDays() {
        return days;
    }
}
