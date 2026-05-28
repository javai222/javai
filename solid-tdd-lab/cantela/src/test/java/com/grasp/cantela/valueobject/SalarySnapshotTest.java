package com.grasp.cantela.valueobject;

import com.grasp.cantela.Exception.NegativeAmountException;
import com.grasp.cantela.valueObject.SalarySnapshot;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// OOP: Immutability — Records have no mutators; state is fixed for the lifetime of the instance.
class SalarySnapshotTest {

    @Test
    void shouldRejectNegativeMonthlySalary() {
        NegativeAmountException nae = assertThrows(NegativeAmountException.class,
                () -> new SalarySnapshot(-1, 0));
        assertTrue(nae.getMessage().contains("Monthly salary"));
    }

    @Test
    void shouldRejectNegativeYearlySalary() {
        //Arrange and Act
        NegativeAmountException nae = assertThrows(NegativeAmountException.class,
                () -> new SalarySnapshot(0, -1));

        //Assert
        assertTrue(nae.getMessage().contains("Yearly salary"));
    }

    @Test
    void shouldGiveValidInputs() {
        //Arrange
        SalarySnapshot snapshot = new SalarySnapshot(1000, 12000);

        //Assert
        assertEquals(1000, snapshot.monthlySalary());
        assertEquals(12000, snapshot.yearlySalary());
    }
}
