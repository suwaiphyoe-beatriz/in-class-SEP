import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class SpeedConverterTest {

    @Test
    public void testCalculateSpeedNormal() {
        assertEquals(10.0, SpeedConverter.calculateSpeed(100, 10), 0.0001);
        assertEquals(5.0, SpeedConverter.calculateSpeed(50, 10), 0.0001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCalculateSpeedZeroTime() {
        SpeedConverter.calculateSpeed(100, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCalculateSpeedNegativeTime() {
        SpeedConverter.calculateSpeed(100, -5);
    }
}