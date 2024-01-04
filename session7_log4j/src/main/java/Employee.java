import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Employee{
    public static Logger logger = LogManager.getLogger(Employee.class);
    private String name;
    private String email;
    private String nationalCode;
    private final Integer id;

    public Employee(String name, String email, String nationalCode, Integer id) {
        this.name = name;
        this.email = email;
        this.nationalCode = nationalCode;
        this.id = id;
        logger.debug("employee with id "+this.id+
                     " , name "+this.name+" , email "+ this.email +" created.");
    }
    public Employee(Integer id) {
        this.id=id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws InvalidValueException {
        if (name.trim().equals("")){
            logger.error(String.format("name of employee [%d] couldn't change from [%s] to [%s] because it was invalid"
                    ,this.id,this.name,name));
            throw new InvalidValueException("The name is not valid");
        }
        String preName = this.name;
        this.name = name;
        logger.debug(String.format("name of employee [%d] changed from [%s] to [%s]",this.id,preName,this.name));

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws InvalidValueException {
        if (email.trim().equals("") || !email.contains("@")){
            logger.error(String.format("email of employee [%d] couldn't change from [%s] to [%s] because it was invalid"
            ,this.id,this.email,email));
            throw new InvalidValueException("The email is not valid");
        }
        String preEmail = this.email;
        this.email = email;
        logger.debug(String.format("email of employee [%d] changed from [%s] to [%s]",this.id,preEmail,this.email));
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(String nationalCode) throws InvalidValueException {
        if (nationalCode.trim().equals("") || nationalCode.length() != 10){
            logger.error(String.format("nationalCode of employee [%d] couldn't change from [%s] to [%s] because it was invalid"
                    ,this.id,this.nationalCode,nationalCode));
            throw new InvalidValueException("The nationalCode is not valid");
        }
        String preNationalCode = this.nationalCode;
        this.nationalCode = nationalCode;

        logger.debug(String.format("nationalCode of employee [%d] changed from [%s] to [%s]",this.id,preNationalCode,this.nationalCode));
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", nationalCode='" + nationalCode + '\'' +
                ", id=" + id +
                '}';
    }
}
