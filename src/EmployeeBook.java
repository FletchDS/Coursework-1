public class EmployeeBook {
    private static int id = -1;
    private Employee[] employees;

    EmployeeBook(){
        employees = new Employee[10];
    }

    EmployeeBook(Employee[] employees){
        this.employees = employees;
    }

    public boolean addNewEmployee(String firstName, String lastName,
                                  String patronymic, int department, double salary) {
        int newEmployeeId = -1;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                newEmployeeId = i;
                break;
            }
        }

        if (newEmployeeId == -1) {
            return false;
        } else {
            employees[newEmployeeId] = new Employee(firstName, lastName, patronymic, department, salary);
            return true;
        }
    }

    public void removeEmployee(int id) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getId() == id) {
                employees[id] = null;
                return;
            }
        }
    }

    public Employee getEmployeeById(int id) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getId() == id) {
                return employees[id];
            }
        }
        return null;
    }

    public static int getNewId() {
        id += 1;
        return (id);
    }

    public String getEmployeeArrayToString() {
        String result = "";

        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                result += employees[i].toString() + "\n";
            }
        }

        return result;
    }

    public String getEmployeeDepartmentArrayToString(int department) {
        String result = "";

        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getDepartment() == department) {
                result += employees[i].toString() + "\n";
            }
        }

        return result;
    }

    public double getAmountOfSalaryPerMonth() {
        double result = 0;

        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                result += employees[i].getSalary();
            }
        }

        return Math.round(result * 100.0) / 100.0;
    }

    public double getAmountOfSalaryPerMonthInDepartment(int department) {
        double result = 0;

        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getDepartment() == department) {
                result += employees[i].getSalary();
            }
        }

        return result;
    }

    public String getEmployeeWithMinimumSalary() {
        int resultId = -1;

        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                resultId = i;
                break;
            }
        }

        for (int i = resultId + 1; i < employees.length; i++) {
            if (employees[i] != null) {
                if (employees[i].getSalary() < employees[resultId].getSalary()) {
                    resultId = i;
                }
            }
        }

        return employees[resultId].toString();
    }

    public String getEmployeeWithMinimumSalaryInDepartment(int department) {
        int resultId = -1;

        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getDepartment() == department) {
                resultId = i;
                break;
            }
        }

        for (int i = resultId + 1; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getDepartment() == department) {
                if (employees[i].getSalary() < employees[resultId].getSalary()) {
                    resultId = i;
                }
            }
        }

        return employees[resultId].toString();
    }

    public String getEmployeeWithMaximumSalary() {
        int resultId = -1;

        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                resultId = i;
                break;
            }
        }

        for (int i = resultId + 1; i < employees.length; i++) {
            if (employees[i] != null) {
                if (employees[i].getSalary() > employees[resultId].getSalary()) {
                    resultId = i;
                }
            }
        }

        return employees[resultId].toString();
    }

    public String getEmployeeWithMaximumSalaryInDepartment(int department) {
        int resultId = -1;

        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getDepartment() == department) {
                resultId = i;
                break;
            }
        }

        for (int i = resultId + 1; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getDepartment() == department) {
                if (employees[i].getSalary() > employees[resultId].getSalary()) {
                    resultId = i;
                }
            }
        }

        return employees[resultId].toString();
    }

    public double getAverageAmountOfSalaryPerMonth() {

        return (Math.round((getAmountOfSalaryPerMonth() / (id + 1)) * 100.0) / 100.0);
    }

    public double getAverageAmountOfSalaryPerMonthInDepartment(int department) {
        int employeeCount = 0;

        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getDepartment() == department) {
                employeeCount += 1;
            }
        }

        return (Math.round((getAmountOfSalaryPerMonthInDepartment(department) / employeeCount) * 100.0) / 100.0);
    }

    public String getFullEmployeeName(int employeeId) {
        return employees[employeeId].getFirstName() + " " +
                employees[employeeId].getLastName() + " " +
                employees[employeeId].getPatronymic();
    }

    public void indexSalaryPercentage(int percent) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                double employeeNewSalary = employees[i].getSalary();
                employeeNewSalary = employeeNewSalary + (employeeNewSalary * ((double) percent / 100));

                employees[i].setSalary(employeeNewSalary);
            }
        }
    }

    public void indexSalaryPercentageInDepartment(int percent, int department) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getDepartment() == department) {
                double employeeNewSalary = employees[i].getSalary();
                employeeNewSalary = employeeNewSalary + (employeeNewSalary * ((double) percent / 100));

                employees[i].setSalary(employeeNewSalary);
            }
        }
    }

    public String getEmployeesWithLessSalary(int salary) {
        String result = "";

        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getSalary() < salary) {
                result += employees[i].toStringWithoutDepartment() + "\n";
            }
        }

        return result;
    }

    public String getEmployeesWithGreaterSalary(int salary) {
        String result = "";

        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getSalary() >= salary) {
                result += employees[i].toStringWithoutDepartment() + "\n";
            }
        }

        return result;
    }
    //employees with less salary
    //employees with greater  salary
}
