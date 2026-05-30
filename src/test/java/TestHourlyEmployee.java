import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import student.HourlyEmployee;

public class TestHourlyEmployee {

    @Test
    public void testGetName() {
        HourlyEmployee employee = new HourlyEmployee(
                "Caroline", "001", 15.0, 0.0, 0.0, 0.0
        );
        assertEquals("Caroline", employee.getName());
    }
}
