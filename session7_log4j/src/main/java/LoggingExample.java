import java.util.List;

public class LoggingExample {

    public static void main(String[] args) {
        Employee employee1 = new Employee("name1","example1@gmail.com","1112345678",1);
        Employee employee2 = new Employee("name2","example2@gmail.com","1112345679",2);
        Employee employee3 = new Employee("name3","example3@gmail.com","1112345677",3);

        try {
            employee1.setName("name4");
            employee2.setNationalCode("1234567891");
            employee3.setEmail("email3@gmail.com");
            employee2.setEmail("email2");
        } catch (InvalidValueException e) {
            e.printStackTrace();

        }
        Employee employee4 = new Employee("name4","example4@gmail.com","1112345688",4);

    }
}


