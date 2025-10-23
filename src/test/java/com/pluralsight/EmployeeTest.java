package com.pluralsight;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    @Test
    void totalPay() {
        //Regular hours
        //Arrange
        Employee employee1 = new Employee(102, "Butterfly", "Personality hire", 100.0, 4);

        //Act
        employee1.punchIn(10.00);
        employee1.punchOut(14.00);

        double expectedPay = 4.00 * 100.0;

        //Assert
        assertEquals(expectedPay, employee1.getTotalPay(), "Total pay should match hours x pay rate");
    }

    @Test
    void punchInAndOut() {
        //Arrange
        Employee employee1 = new Employee(101, "Mercy", "Front Desk", 80.0, 8);

        //Act
        employee1.punchIn(9.0);
        employee1.punchOut(18.0);

        //Assert
        assertTrue(employee1.getHoursWorked() >= 0 );


    }
}