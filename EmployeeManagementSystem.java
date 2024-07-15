import java.util.ArrayList;
import java.util.Scanner;

class Employee {
    private String name;
    private int id;
    private double salary;

    public Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }
//get keyword are used to return the value of variable name
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public double getSalary() {
        return salary;
    }
//set keyword are used to set the value to variable used this keyword to refer current object
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public void setName(String name){
        this.name=name;
    }


    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + "]";
    }
}

class EmployeeManagementSystem {
    private ArrayList<Employee> emp = new ArrayList<>();
    private int nextId = 1;

    public void addEmployee(String name, double salary) {
        Employee employee = new Employee(name, nextId, salary);
        emp.add(employee);
        nextId++;
        System.out.println("Employee added: " + employee.toString());
    }
    public void removeEmployee(int id){
      
      for(Employee i:emp){
        if(i.getId()==id){
            emp.remove(i);
            System.out.println("Employee with ID "+id+" remove successfully.");
            return;
        }
      }
      System.out.println("Employee with ID " + id + " not found.");
    }

    public void displayAllEmployees() {
        if(emp.isEmpty()){
            System.out.println("No employees found.");
        }else{
           for (int i=0;i<emp.size();i++) {
            System.out.println(emp.get(i).toString());
           }

        }
      
    }

    public static void main(String[] args) {
        EmployeeManagementSystem ems = new EmployeeManagementSystem();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nEmployee Management System Menu:");
            System.out.println("1. Add Employee");
            System.out.println("2. Display All Employees");
            System.out.println("3. Delete Employee From List");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter employee name: ");
                    String name = sc.next();
                    System.out.print("Enter employee salary: ");
                    double salary = sc.nextDouble();
                    ems.addEmployee(name, salary);
                    break;

                case 2:
                    ems.displayAllEmployees();
                    break;

                case 3:
                    System.out.print("Enter Employee Id =");
                    int removeid=sc.nextInt();
                    ems.removeEmployee(removeid);
                    break;
                case 4:
                    System.out.println("Exiting Employee Management System. Goodbye!");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
//Employee management system project using java ,opps, arraylist, managing employee 