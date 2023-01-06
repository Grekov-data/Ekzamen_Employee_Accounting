import java.util.List;

public class Program {
    public static void main(String[] args) {
        ReadAndSave readAndSave = new ReadAndSave();

                    //ЧТЕНИЕ файла и передача списка сотрудников через класс ReadAndSave в Main
        readAndSave.readData();
        List <Employee> employees = readAndSave.getEmployees();
        System.out.println(employees);






















        
                    //ЗАПИСЬ списка сотрудников в файл
        readAndSave.saveData(employees);
    }
}