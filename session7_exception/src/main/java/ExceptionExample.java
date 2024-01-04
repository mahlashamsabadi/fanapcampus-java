import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class ExceptionExample {

    public static void main(String[] args) {
        Country country1 = new Country("Iran", "IRN", 80_000_000);
        Country country2 = new Country("Italy", "", 81_000_000);
        Country country3 = new Country("Germany", "DEU", 82_000_000);
        Country country4 = new Country("Canada", "CAN", 83_000_000);
        Country country5 = new Country("Japan", "JAP", 125_700_000);
        List<Country> countries = new ArrayList<>();
        countries.add(country1);
        countries.add(country2);
        countries.add(country3);
        countries.add(country4);
        countries.add(country5);

        for (Country country : countries) {
            try {
                System.out.println(country.getCode());
            } catch (CodeNotFoundException e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }

    }
}

