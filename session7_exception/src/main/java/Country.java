import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Country {
    static Logger logger = LogManager.getLogger(Country.class);
    private String name;
    private String code;
    private long population;

    public Country(String name, String code, long population) {
        this.name = name;
        this.code = code;
        this.population = population;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public String getName() {
        return name;
    }

    public String getCode() throws CodeNotFoundException {
        if (this.code.trim().equals("")) {
            logger.error("code of country " + this.getName() + " is empty");
            throw new CodeNotFoundException("the code of this country could not found");
        }
        return code;
    }
}
