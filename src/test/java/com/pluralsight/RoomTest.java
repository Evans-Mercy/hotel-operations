package com.pluralsight;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {

    @org.junit.jupiter.api.Test
    void checkIn() {
        //room is occupied and dirty
        //Arrange
        Room room1 = new Room(2, 120., false, false);

        //Act
        room1.checkIn();

        //Assert
        assertTrue(room1.isOccupied(), "Room is occupied after check-in");
        assertTrue(room1.isDirty(), "Room is dirty after check-in");

    }

    @org.junit.jupiter.api.Test
    void checkOut() {
        //Arrange
        Room room1 = new Room(2, 100.0, false, false);
        room1.checkIn();

        //Act
        room1.checkOut();

        //Assert
        assertFalse(room1.isOccupied(), "Room should not be occupied after checkout");
        assertFalse(room1.isDirty(), "Room should still be dirty after checkout.");

    }

    @org.junit.jupiter.api.Test
    void cleanRoom() {
        //Arrange
        Room room1 = new Room(1, 200.0, false, true);

        //Act
        room1.cleanRoom();

        //Assert
        assertFalse(room1.isDirty(), "Room should be clean.");
    }
}