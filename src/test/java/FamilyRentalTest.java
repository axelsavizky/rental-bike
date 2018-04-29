import model.rental.*;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.when;

@Test
public class FamilyRentalTest {
    private FamilyRental target;
    @Mock
    private DailyRental dailyRental;
    @Mock
    private HourlyRental hourlyRental;
    @Mock
    private WeeklyRental weeklyRental;

    @BeforeTest
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        target = new FamilyRental();

        when(this.dailyRental.calculatePrice(anyInt())).thenReturn(10);
        when(this.hourlyRental.calculatePrice(anyInt())).thenReturn(50);
        when(this.weeklyRental.calculatePrice(anyInt())).thenReturn(100);
    }

    @Test
    public void testFamilyPrice() {
        List<PairRentalTime> rentals = new ArrayList<>();
        rentals.add(new PairRentalTime(dailyRental, 3));
        rentals.add(new PairRentalTime(weeklyRental, 5));
        rentals.add(new PairRentalTime(hourlyRental, 20));
        rentals.add(new PairRentalTime(weeklyRental, 10));

        Assert.assertEquals(this.target.calculatePrice(rentals), 182.0);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testWrongArgument() {
        this.target.calculatePrice(new ArrayList<>());
    }

}
