import model.rental.DailyRental;
import model.rental.HourlyRental;
import model.rental.Rental;
import model.rental.WeeklyRental;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

@Test
public class RentalTest {

    private HourlyRental hourlyRental;
    private DailyRental dailyRental;
    private WeeklyRental weeklyRental;

    @BeforeClass
    public void init() {
        this.hourlyRental = new HourlyRental();
        this.dailyRental = new DailyRental();
        this.weeklyRental = new WeeklyRental();
    }

    @DataProvider
    private Object[][] rentalDataProvider() {
        return new Object[][] {
                {hourlyRental},
                {dailyRental},
                {weeklyRental}
        };
    }

    @Test(dataProvider = "rentalDataProvider")
    public void testPrice(Rental rental) {
        int rate = rental.getRate();

        assertEquals(rental.calculatePrice(5), rate * 5);
        assertEquals(rental.calculatePrice(0), 0);
    }
}
