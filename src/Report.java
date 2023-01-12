import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Report {

    private List <Employee> employees;
    private List <Department> departments;
    private String nameDep;



    public void readData () {
        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("Employees.bin"))){
            List<Employee> employees = (List<Employee>)objectInputStream.readObject();
            this.employees = employees;}
        catch(IOException | ClassNotFoundException ex){System.out.println(ex.getMessage());}

        /*System.out.println("Список сотрудников в Report: " + employees);*/
    }

    public void readDataDep () {
        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("Departaments.bin"))){
            List <Department> departments = (List<Department>)objectInputStream.readObject();
            this.departments = departments;}
        catch(IOException | ClassNotFoundException ex){
            System.out.println(ex.getMessage());}

        /*System.out.println("Список отделов в Report: " + departments);*/
        }


    public void allEmployees () {               //Отчёт по всем сотрудникам с указанием отделов
        readData();
        readDataDep();
        System.out.print("\n\t\t\t\t\t\t\t\tСТРУКТУРА ОРГАНИЗАЦИИ:");
        for (Department department : departments) {
            nameDep = department.getNameDep();
            System.out.print("\n"+department);
            for (Employee employee : employees) {
                if (employee.getNameDep().equals(nameDep)) {
                    System.out.print(employee);}}}
    }

    public void averageSalary () {              //Отчёт о средней ЗП по всей организации
        readData();
        readDataDep();
        int sum = 0, count = 0, otvet = 0;
        for (Employee employee : employees) {
            count++;
            sum = sum + employee.getSalary();}
        otvet = sum / count;
        System.out.println("Средняя заработная плата по организации = "+otvet);
    }

    public void avarageSalaryDep () {           //Отчёт о средней ЗП по каждому отделу
        readData();
        readDataDep();
        int otvet = 0;
        for (Department department : departments) {
            int sum = 0, count = 0;
            nameDep = department.getNameDep();
            System.out.print("\n" + department);
            for (Employee employee : employees) {
                count++;
                if (employee.getNameDep().equals(nameDep)) {
                    sum = sum + employee.getSalary();}}
            otvet = sum / count;
            System.out.print("\nСредняя заработная в отделе = " + otvet);}
    }

    public void maxSalary() {                   //Отчёт о 10 сотрудниках с максимально ЗП
        readData();
        readDataDep();
        System.out.println("Список сотрудников с MaxSalary:\n"+employees);
        System.out.println("ТОП-10 сотрудников с самой высокой ЗП: ");
        employees.stream()
                .sorted(Comparator.comparingInt(Employee::getSalary).reversed())
                .limit(10)
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    public void maxExperience() {
        readData();
        readDataDep();
        System.out.println("ТОП-10 сотрудников с самым большим стажем: ");
        employees.stream()
                .sorted(Comparator.comparingLong(e->e.getDateEmpl().getTime()))
                .limit(10)
                .forEach(System.out::println);
    }


    public void searchEmployees (int num, String name) {
        readData();
        readDataDep();
        if (num == 1) {
            employees.stream()
                    .filter(employee -> employee.getNameEmpl().equals(name))
                    .forEach(System.out::println);}
        if (num == 2) {
            employees.stream()
                    .filter(employee -> employee.getPosition().equals(name))
                    .forEach(System.out::println);}
        if (num == 3) {
            employees.stream()
                    .filter(employee -> employee.getNameDep().equals(name))
                    .forEach(System.out::println);}
        if (num == 4) {
            employees.stream()
                    .filter(employee -> employee.getNameChief().equals(name))
                    .forEach(System.out::println);}
    }
}
