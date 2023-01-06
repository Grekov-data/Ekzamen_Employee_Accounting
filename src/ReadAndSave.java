import java.io.*;
import java.util.List;

public class ReadAndSave {

    private List <Employee> employees;

                                                //ЧТЕНИЕ списка сотрудников из ФАЙЛА
    public void readData () {
        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("Employees.bin"))){
            List <Employee> employees = (List<Employee>)objectInputStream.readObject();
            this.employees = employees;
        }
        catch(IOException | ClassNotFoundException ex){
            System.out.println(ex.getMessage());
        };
        System.out.println("Список в ReadAndSave: " + employees);
    }


                                                //Передача списка сотрудников, считанного из файла, в Program
    public List<Employee> getEmployees() {      //ПЕРЕДАЧА СПИСКА ИЗ ФАЙЛА в Program
        return employees;
    }


                                                //ЗАПИСЬ СПИСКА СОТРУДНИКОВ В ФАЙЛ
    public void saveData (List<Employee> employees) {
        String fileName = "Employees.bin";
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream(fileName))){
            objectOutputStream.writeObject(employees);
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }


    }
}
