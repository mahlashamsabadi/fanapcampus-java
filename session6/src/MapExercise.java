import java.util.HashMap;
import java.util.Map;

public class MapExercise {
    public static void main(String[] args) {
        Country country1 = new Country("Iran","IRN", 87_920_000);
        Country country2 = new Country("Germany","DEU", 83_200_000);
        Country country3 = new Country("Italy","ITA", 59_110_000);

        Map<String , Country> countryMap = new HashMap<>();
        countryMap.put(country1.code , country1);
        countryMap.put(country2.code , country2);
        countryMap.put(country3.code , country3);

        for (String str:countryMap.keySet()) {
            System.out.println(countryMap.get(str));
        }
        Country country = countryMap.get("ITA");
        System.out.println("ITA is the code of: "+ country.name
                +" with population "+ country.population);
    }
}
class Country{
    String name;
    String code;
    long population;

    public Country(String name, String code, long population) {
        this.name = name;
        this.code = code;
        this.population = population;
    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", population=" + population +
                '}';
    }
}
