import java.io.*;
import java.util.List;

public class ReadAndSave {

    private List <Employee> employees;

    public void readData () {
                                                //ЧТЕНИЕ ФАЙЛА
        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("Employees.bin"))){
            List <Employee> employees = (List<Employee>)objectInputStream.readObject();
            this.employees = employees;
        }
        catch(IOException | ClassNotFoundException ex){
            System.out.println(ex.getMessage());
        };
    }

    public List<Employee> getEmployees() {      //ПЕРЕДАЧА СПИСКА ИЗ ФАЙЛА В Main
        return employees;
    }

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
