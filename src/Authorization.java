import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Authorization {

    private String nameEmpl;
    private String dateOfBirth;
    private String login;
    private String password;
    private List <Employee> employees;

    public void readData () {
        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("Employees.bin"))){
            List <Employee> employees = (List<Employee>)objectInputStream.readObject();
            this.employees = employees;
        }
        catch(IOException | ClassNotFoundException ex){
            System.out.println(ex.getMessage());
        };
        System.out.println("Список в Authorization: " + employees);
    }
    public List<Employee> getEmployees() {      //ПЕРЕДАЧА СПИСКА ИЗ ФАЙЛА в Program
        return employees;
    }


    public boolean signIn() {
        Scanner ScanRegStr = new Scanner(System.in);
        while (login != "back to menu") {
            System.out.println("Введите логин и пароль для входа в систему:" +
                    "\n(для возврата в меню введите \"back to menu\")");
            System.out.print("логин: ");
            login = ScanRegStr.nextLine();
            if (login == "back to menu")
                break;
            System.out.print("пароль: ");
            password = ScanRegStr.nextLine();
            if (verificationAuthorization(login, password) != null) {
                System.out.println("Вы успешно авторизованы");
                return true;
            }
            if (verificationAuthorization(login, password) == null) {
                System.out.println("Неверный логин или пароль");
            }
        }
        return false;
    }


    public void registration() {                        //РЕГИСТРАЦИЯ НОВОГО ПОЛЬЗОВАТЕЛЯ
        ReadAndSave readAndSave = new ReadAndSave();
        Scanner ScanRegStr = new Scanner(System.in);
        Scanner ScanRegInt = new Scanner(System.in);
        Scanner ScanRegLog = new Scanner(System.in);
        String nameEmpl, dateOfBirth, numberPh, position, nameDep, nameChief, login, password;
        boolean gender;
        int salary;
        System.out.println("\nПроизводится процесс регистрации. Пожалуйста, введите...");
        System.out.print("ваше ФИО: ");
        nameEmpl = ScanRegStr.nextLine();
        System.out.print("вашу дату рождения: ");
        dateOfBirth = ScanRegStr.nextLine();
        gender = true;
        boolean proverka = true;
        while (proverka) {
            System.out.println("выберете ваш пол: " +
                    "\n1 - мужской" +
                    "\n2 - женский");
            int num = ScanRegInt.nextInt();
            if (num == 0 || num == 1)
                proverka = false;
            else System.out.print("\nПол указан неверно!");
            if (num == 0)
                gender = false;
        }
        System.out.print("номер мобильного телефона: ");
        numberPh  = ScanRegStr.nextLine();
        System.out.print("занимаемую должность: ");
        position = ScanRegStr.nextLine();
        System.out.print("название отдела: ");
        nameDep = ScanRegStr.nextLine();
        System.out.print("заработную плату: ");
        salary = ScanRegInt.nextInt();
        proverka = true;
        while (proverka == true) {
            System.out.print("желаемый логин: ");
            login = ScanRegLog.nextLine();
            if (verificationRegistration(login)==false) {
                proverka = false;
                System.out.print("желаемый пароль: ");
                password = ScanRegStr.nextLine();
                employees.add(new Employee (nameEmpl, dateOfBirth, gender, numberPh, position, nameDep, "тестовый начальник", new Date(), salary, login, password));
                System.out.println("Учётная запись успешно создана!");
            }
            else System.out.println("Логин занят или пользователь уже существует!");
        }
        readAndSave.saveData(employees);
    }


    public void deleteProfile () {                                  //УДАЛЕНИЕ учётной записи
        ReadAndSave readAndSave = new ReadAndSave();
        Scanner ScanRegStr = new Scanner(System.in);
        Scanner ScanRegInt = new Scanner(System.in);
        int otvet = 0;
        boolean proverka = true;
        while (login != "back to menu") {
            System.out.println("Авторизируйтесь для удаления своей учётной записи: ");
            System.out.println("для возврата в меню введите \"back to menu\")");
            System.out.print("логин: ");
            login = ScanRegStr.nextLine();
            if (login == "back to menu") ;
            System.out.print("пароль: ");
            password = ScanRegStr.nextLine();
            if (verificationAuthorization(login, password) != null) {
                System.out.print("Уверены, что хотите удалить учётную запись?" +
                        "\nОтвет (\"да\" - удалить, \"нет\" - возврат в меню): ");
                while (proverka == true) {
                    otvet = ScanRegInt.nextInt();
                    if (otvet == 1) {
                        employees.remove(verificationAuthorization(login, password));
                        readAndSave.saveData(employees);
                        proverka = false;
                    }
                    if (otvet == 2)
                        break;
                }
            }
        }
    }


                            //Проверка, имеется ли уже такой логин в системе
    public boolean verificationRegistration (String login) {
        for (Employee employee : employees) {
            if (employee.getLogin().equals(login))
                return true;
        }
        return false;
    }


                            //Проверка логина и пароля от учётной записи
    public Employee verificationAuthorization (String login, String password) {
        for (Employee employee : employees) {
            if (employee.getLogin().equals(login) && employee.getPassword().equals(password))
                return employee;
        }
        return null;
    }

}
