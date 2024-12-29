public class Main {
    public static void main(String[] args) {
        EmployeeBook employeeBook = new EmployeeBook();

        employeeBook.addNewEmployee("Нечаев", "Степан", "Антонович", 1, 54_125.63);
        employeeBook.addNewEmployee("Григорьев ", "Ибрагил ", "Семёнович", 1, 72_643.12);
        employeeBook.addNewEmployee("Фомина", "Эдилия", "Валерьевна", 1, 47_272.39);
        employeeBook.addNewEmployee("Лобанова", "Богдана", "Максовна", 2, 55_927.28);
        employeeBook.addNewEmployee("Попов", "Яков", "Дмитрьевич", 2, 67_534.93);
        employeeBook.addNewEmployee("Лыткина", "Дана", "Михайловна", 2, 44_771.09);


        System.out.println("Сотрудники \n" + employeeBook.getEmployeeArrayToString());

        System.out.println("Сумма затрат на ЗП за месяц \n" + employeeBook.getAmountOfSalaryPerMonth());

        System.out.println("\nСотрудник с минимальной ЗП \n" + employeeBook.getEmployeeWithMinimumSalary());

        System.out.println("\nСотрудник с максимальной ЗП \n" + employeeBook.getEmployeeWithMaximumSalary());

        System.out.println("\nСреднее значение ЗП \n" + employeeBook.getAverageAmountOfSalaryPerMonth());

        System.out.println("\nПолное имя сотрудника с id = 2 " + employeeBook.getFullEmployeeName(2));

        employeeBook.indexSalaryPercentage(10);
        System.out.println("\nСотрудники после проиндексирования зарплат на 10% \n" + employeeBook.getEmployeeArrayToString());

        System.out.println("Сотрудник с минимальной ЗП в отделе 2 \n" + employeeBook.getEmployeeWithMinimumSalaryInDepartment(2));

        System.out.println("\nСотрудник с максимальной ЗП в отделе 2 \n" + employeeBook.getEmployeeWithMaximumSalaryInDepartment(2));

        System.out.println("\nСумма затрат на ЗП за месяц в отделе 2 \n" + employeeBook.getAmountOfSalaryPerMonthInDepartment(2));

        System.out.println("\nСреднее значение ЗП в отделе 2 \n" + employeeBook.getAverageAmountOfSalaryPerMonthInDepartment(2));

        employeeBook.indexSalaryPercentageInDepartment(10, 2);
        System.out.println("\nСотрудники после проиндексирования зарплат на 10% во 2 отделе\n" + employeeBook.getEmployeeArrayToString());

        System.out.println("Сотрудники 2 отдела\n" + employeeBook.getEmployeeDepartmentArrayToString(2));

        System.out.println("Сотрудники с зарплатой меньше 60 000\n" + employeeBook.getEmployeesWithLessSalary(60_000));

        System.out.println("Сотрудники с зарплатой больше 60 000\n" + employeeBook.getEmployeesWithGreaterSalary(60_000));

        System.out.println("Сотрудники с id 3\n" + employeeBook.getEmployeeById(3));

        employeeBook.removeEmployee(3);
        System.out.println("\nСотрудник с id 3 удален\n");
        System.out.println("Сотрудники после удаления сотрудника\n" + employeeBook.getEmployeeArrayToString());
    }
}