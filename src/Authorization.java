import java.io.*;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Authorization {


    private String login;
    private String password;
    private String nameChief;
    private List <Employee> employees;
    private List <Department> departments;

    public void setEmployees(List<Employee> employees) {this.employees = employees;}

    public void setDepartments(List<Department> departments) {this.departments = departments;}

    public void readData () {
        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("Employees.bin"))){
            List <Employee> employees = (List<Employee>)objectInputStream.readObject();
            this.employees = employees;}
        catch(IOException | ClassNotFoundException ex){System.out.println(ex.getMessage());}

        /*System.out.println("Список сотрудников в Authorization: " + employees);*/
    }

        public void readDataDep () {
        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("Departaments.bin"))){
            List <Department> departments = (List<Department>)objectInputStream.readObject();
            this.departments = departments;}
        catch(IOException | ClassNotFoundException ex){
            System.out.println(ex.getMessage());}

        /*System.out.println("Список отделов в Authorization: " + departments);*/
    }
    public List<Employee> getEmployees() {      //ПЕРЕДАЧА СПИСКА ИЗ ФАЙЛА в Program
        return employees;
    }


    public boolean signIn() {
        readData();
        readDataDep();
        Scanner ScanRegStr = new Scanner(System.in);
        while (login != "back to menu") {
            System.out.println("Введите логин и пароль для входа в систему: ");
            System.out.print("логин: ");
            login = ScanRegStr.nextLine();
            System.out.print("пароль: ");
            password = ScanRegStr.nextLine();
            if (verificationAuthorization(login, password) != null) {
                System.out.println("Вы успешно авторизованы!");
                return true;}
            if (verificationAuthorization(login, password) == null) {
                System.out.println("Неверный логин или пароль");}}
        return false;
    }


    public void registration() {                        //РЕГИСТРАЦИЯ НОВОГО ПОЛЬЗОВАТЕЛЯ
        ReadAndSave readAndSave = new ReadAndSave();
        readData();
        readDataDep();
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
        while (proverka == true) {
            System.out.println("выберете ваш пол: " +
                    "\n1 - мужской" +
                    "\n2 - женский");
            int num = ScanRegInt.nextInt();
            if (num == 1)
                proverka = false;
            if (num == 2) {
                gender = false;
                proverka = false;}
            if (num != 1 && num != 2)
                System.out.println("пол указан некорректно!");}
        System.out.print("номер мобильного телефона: ");
        numberPh  = ScanRegStr.nextLine();
        proverka = true;
        position = null;
        while (proverka == true) {
            System.out.print("занимаемую должность: " +
                    "\n1. Руководитель;" +
                    "\n2. Специалист;" +
                    "\n3. Рабочий." +
                    "\nОтвет - ");
            int num = ScanRegInt.nextInt();
            if (num == 1) {
                System.out.println("Данная вакансия на данный момент закрыта, повторите ввод занимаемой должности");}
            if (num == 2) {
                position = "Специалист";
                proverka = false;}
            if (num == 3) {
                position = "Рабочий";
                proverka = false;}
            if (num != 1 && num != 2 && num != 3)System.out.println("должность указана некорректно!");}
        proverka = true;
        nameDep = null;
        while (proverka == true) {
            System.out.print("название отдела: " +
                    "\n1. Бухгалтерия;" +
                    "\n2. IT;" +
                    "\n3. Производство." +
                    "\nОтвет - ");
            int num = ScanRegInt.nextInt();
            if (num == 1) {
                nameDep = "Бухгалтерия";
                proverka = false;}
            if (num == 2) {
                nameDep = "IT";
                proverka = false;}
            if (num == 3) {
                nameDep = "Производство";
                proverka = false;}
            if (num != 1 && num != 2 && num != 3)System.out.println("отдел указан некорректно!");
        }
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
                employees.add(new Employee (nameEmpl, dateOfBirth, gender, numberPh, position, nameDep, formedDepartaments(nameDep), new Date(), salary, login, password));
                System.out.println("Учётная запись успешно создана!");
                System.out.println(employees);
                readAndSave.saveData(employees);}
            else System.out.println("Логин занят или пользователь уже существует!");}
        System.out.println("После сохранения!!!\n"+employees);
    }


    public void deleteProfile () {                                  //УДАЛЕНИЕ учётной записи
        ReadAndSave readAndSave = new ReadAndSave();
        Scanner ScanRegStr = new Scanner(System.in);
        Scanner ScanRegInt = new Scanner(System.in);
        readData();
        readDataDep();
        int otvet = 0;
        boolean proverka = true;
        while (login != "back to menu") {
            System.out.println("Авторизируйтесь для удаления своей учётной записи: ");
            System.out.print("логин: ");
            login = ScanRegStr.nextLine();
            System.out.print("пароль: ");
            password = ScanRegStr.nextLine();
            if (verificationAuthorization(login, password) != null) {
                System.out.print("Уверены, что хотите удалить учётную запись?" +
                        "\nОтвет (\"1\" - удалить, \"2\" - возврат в меню): ");
                while (proverka == true) {
                    otvet = ScanRegInt.nextInt();
                    if (otvet == 1) {
                        employees.remove(verificationAuthorization(login, password));
                        readAndSave.saveData(employees);
                        readAndSave.saveDataDep(departments);
                        proverka = false;}
                    if (otvet == 2)
                        break;}
            }
        }
    }


                            //Проверка, имеется ли уже такой логин в системе
    public boolean verificationRegistration (String login) {
        for (Employee employee : employees) {
            if (employee.getLogin().equals(login))
                return true;
            else return false;
        }
        return false;
    }

                            //Проверка имени руковдителя по отделу, чтобы внести его для подчинённых сотрудников
    public String formedDepartaments(String nameDep) {
        readData();
        for (Employee employee : employees) {
            if (employee.getNameDep().equals(nameDep) && employee.getPosition().equals("Руководитель")) {
                nameChief = employee.getNameEmpl();
                return nameChief;}
        }
        return null;
    }


                            //Проверка логина и пароля от учётной записи
    public Employee verificationAuthorization (String login, String password) {
        readData();
        readDataDep();
        for (Employee employee : employees) {
            if (employee.getLogin().equals(login) && employee.getPassword().equals(password))
                return employee;}
        return null;
    }

}
