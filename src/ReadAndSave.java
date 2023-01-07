import java.io.*;
import java.util.List;

public class ReadAndSave {
    private List <Employee> employees;
    private List <Department> departments;


                                //Передача списка сотрудников, считанного из файла, в Program
    public List<Employee> getEmployees() {      //ПЕРЕДАЧА СПИСКА ИЗ ФАЙЛА в Program
        return employees;
    }
    public List<Department> getDepartments() {return departments;}


    //ЧТЕНИЕ списка сотрудников из ФАЙЛА
    public void readData () {
        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("Employees.bin"))){
            List <Employee> employees = (List<Employee>)objectInputStream.readObject();
            this.employees = employees;}
        catch(IOException | ClassNotFoundException ex){
            System.out.println(ex.getMessage());}

        System.out.println("Список сотрудников в ReadAndSave: " + employees);
    }

        public void readDataDep () {
            try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("Departaments.bin"))){
                List <Department> departments = (List<Department>)objectInputStream.readObject();
                this.departments = departments;}
            catch(IOException | ClassNotFoundException ex){
                System.out.println(ex.getMessage());}

            System.out.println("Список отделов в ReadAndSave: " + departments);
        }


                                                //ЗАПИСЬ СПИСКА СОТРУДНИКОВ В ФАЙЛ
    public void saveData (List<Employee> employees) {
        String fileName = "Employees.bin";
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream(fileName))){
            objectOutputStream.writeObject(employees);
        }
        catch (IOException ex) {System.out.println(ex.getMessage());}
    }


    public void saveDataDep (List<Department> departments) {
        String fileName = "Departaments.bin";
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream(fileName))) {
            objectOutputStream.writeObject(departments);
        } catch (IOException ex) {System.out.println(ex.getMessage());}}
}
