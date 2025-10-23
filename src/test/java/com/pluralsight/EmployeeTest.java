package com.pluralsight;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

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