import java.util.Objects;

public class Employee {
    private final int id;
    private String firstName;
    private String lastName;
    private String patronymic;
    private int department;
    private double salary;

    Employee() {
        this.id = EmployeeBook.getNewId();
    }

    Employee(String firstName, String lastName, String patronymic, int department, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.department = department;
        this.id = EmployeeBook.getNewId();
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setDepartment(int department) {
        if (department < 1 || department > 5) {
            throw new IllegalArgumentException("Отдел должен быть в диапазоне от 1 до 5.");
        }
        this.department = department;
    }

    public int getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = Math.round(salary * 100.0) / 100.0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return department == employee.department && Double.compare(salary, employee.salary) == 0 && Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName) && Objects.equals(patronymic, employee.patronymic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, patronymic, department, salary);
    }

    @Override
    public String toString() {
        return firstName + " " +
                lastName + " " +
                patronymic + " " +
                "{id=" + id +
                ", отдел=" + department +
                ", зарплата=" + salary +
                '}';
    }

    public String toStringWithoutDepartment() {
        return firstName + " " +
                lastName + " " +
                patronymic + " " +
                "{id=" + id +
                ", зарплата=" + salary +
                '}';
    }
}
