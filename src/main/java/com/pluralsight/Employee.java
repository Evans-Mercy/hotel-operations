package com.pluralsight;

import java.time.LocalDateTime;

public class Employee {

    //backing variables
    private int employeeId;
    private String name;
    private String department;
    private double payRate;
    private double hoursWorked;

    private double punchInTime; //tracks when they punch in

    public Employee(int employeeId, String name, String department, double payRate, double hoursWorked) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.payRate = payRate;
        this.hoursWorked = 0;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getPayRate() {
        return payRate;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    //punch in
    public void punchIn(double time){
        punchInTime = time;
        System.out.printf("%s punched in at %.2f%n", name, punchInTime);
    }

    //punch out
    public void punchOut(double time){
        double hours = time - punchInTime;
        hoursWorked += hours;
        System.out.printf("%s punched out at %.2f | Worked %.2f hours%n", name, time, hours);
    }

    //Overloaded methods
    public void punchIn() {
        LocalDateTime now = LocalDateTime.now();
        double time = now.getHour() + (now.getMinute()/60.0);
        punchIn(time);
    }

    public void punchOut() {
        LocalDateTime now = LocalDateTime.now();
        double time = now.getHour() + (now.getMinute()/60.0);
        punchOut(time);
    }


    //Regular Hours
    public double getRegularHours() {
        if (hoursWorked > 40) {
            return 40;
        } else {
            return hoursWorked;
        }
    }

    //Overtime hours
    public double getOvertimeHours () {
        if (hoursWorked > 40) {
            return hoursWorked - 40;
        } else {
            return 0;
        }
    }

    //Total pay
    public double getTotalPay () {
        double totalPay;

        if (hoursWorked <= 40) {
            totalPay = hoursWorked * payRate;
        } else {
            double regularPay = 40 * payRate;
            double overTimeHours = hoursWorked - 40;
            double overTimePay = overTimeHours * (payRate * 1.5);
            totalPay = regularPay + overTimePay;
        }
        return totalPay;
    }
}
