import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class GroupingExampleWithStream {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("employee1","8188834234"));
        employees.add(new Employee("employee2","8188834223"));
        employees.add(new Employee("employee3","8188834212"));
        employees.add(new Employee("employee4","8188834267"));
        employees.add(new Employee("employee5","828834289"));
        employees.add(new Employee("employee6","8288834245"));
        employees.add(new Employee("employee7","8288834276"));
        employees.add(new Employee("employee8","8288834224"));
        employees.add(new Employee("employee9","8288834267"));
        employees.add(new Employee("employee10","8288834223"));
        employees.add(new Employee("employee11","8388834276"));
        employees.add(new Employee("employee12","8388834244"));
        employees.add(new Employee("employee13","8388834234"));
        employees.add(new Employee("employee14","8488834283"));
        employees.add(new Employee("employee15","8488834228"));
        employees.add(new Employee("employee16","8488834245"));
        employees.add(new Employee("employee17","8988834297"));
        employees.add(new Employee("employee18","8988834224"));
        employees.add(new Employee("employee19","8988834265"));
        employees.add(new Employee("employee20","8988834277"));
        employees.add(new Employee("employee21","8988834225"));

        Map<Boolean, Long> collect = employees.stream()
                .collect(Collectors.groupingBy(i -> i.getPostalCode().substring(0, 2)
                        , Collectors.counting()))
                .entrySet().stream().collect(Collectors.partitioningBy(
                        i -> i.getValue() >= 5
                        , Collectors.counting()));
        System.out.println(collect);

    }
}

class Employee{
    private String name;
    private String postalCode;

    public Employee(String name, String postalCode) {
        this.name = name;
        this.postalCode = postalCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                '}';
    }
}
