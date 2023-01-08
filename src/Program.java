import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.sql.Struct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        ReadAndSave readAndSave = new ReadAndSave();
        Authorization authorization = new Authorization();
        Report report = new Report();

        Scanner ScanAction = new Scanner(System.in);
        Scanner ScanActionString = new Scanner(System.in);


        //ТЕСТОВОЕ ДОБАВЛЕНИЕ ПОЛЬЗОВАТЕЛЯ!!!


        List<Employee> employees = new ArrayList<>(/*(List.of(
                new Employee("Головенко Анатолий Павлович", "01.01.1965", true, "88000000000", "Руководитель", "Управление", "Головенко Анатолий Павлович", new Date(), 500000, "Golovenko", "pass"),
                new Employee("Фрилинг Денис Александрович", "01.01.1970", true, "89005553535", "Руководитель", "Производство", "Головенко Анатолий Павлович", new Date(), 250000, "Friling", "pass"),
                new Employee("Гендик Дарья Алексеевна", "02.02.1975", false, "88005553535", "Руководитель", "Бухгалтерия", "Головенко Анатолий Павлович", new Date(), 260000, "Gendik", "pass"),
                new Employee("Воробьев Евгений Геннадьевич", "03.03.1980", true, "87005553535", "Руководитель", "IT", "Головенко Анатолий Павлович", new Date(), 270000, "Vorob'ev", "pass"),
                new Employee("Тюкалов Борис", "04.04.1990", true, "87005553540", "Специалист", "Производство", "Фрилинг Денис Александрович", new Date(), 100000, "Tukalov", "pass"),
                new Employee("Прохоров Антон", "04.04.1990", true, "87005553541", "Специалист", "Производство", "Фрилинг Денис Александрович", new Date(), 90000, "Prohorov", "pass"),
                new Employee("Тиков Ярослав", "04.04.1990", true, "87005553542", "Рабочий", "Производство", "Фрилинг Денис Александрович", new Date(), 50000, "Tikov", "pass"),
                new Employee("Возняк Евгения", "04.04.1990", false, "87005553551", "Специалист", "Бухгалтерия", "Гендик Дарья Алексеевна", new Date(), 105000, "Voznyak", "pass"),
                new Employee("Полняков Сергей", "04.04.1990", true, "87005553561", "Специалист", "IT", "Воробьев Евгений Геннадьевич", new Date(), 110000, "Polnyakov", "pass"),
                new Employee("Поляков Николай", "04.04.1990", true, "87005553562", "Специалист", "IT", "Воробьев Евгений Геннадьевич", new Date(), 110000, "Polyakov", "pass")

        ))*/);
        /*readAndSave.saveData(employees);*/


        //ЧТЕНИЕ файла и передача списка сотрудников через класс ReadAndSave в Main
        /*readAndSave.readData();
        authorization.readData();*/
        /*employees = readAndSave.getEmployees();*/


        /*List <Department> departments = new ArrayList<>(List.of(
                new Department("Управление"),
                new Department("Производство"),
                new Department("Бухгалтерия"),
                new Department("IT")
        ));*/
        /*System.out.println("ДЕПАРТАМЕНТЫ"+departments);*/


        /*System.out.println("Список из Main: "+employees);*/

        /*List <Employee> employees = readAndSave.getEmployees();*/
        /*System.out.println("Список в Program: " + employees);*/
        int action = 0;
        System.out.println("\tДОБРО ПОЖАЛОВАТЬ!");
        while (action != 7) {
            readAndSave.readData();         //Передача списка СОТРУДНИКОВ из файла в класс ReadAndSave для дальнейшей работы с ним
            readAndSave.readDataDep();      //Передача списка ОТДЕЛОВ из файла в класс ReadAndSave для дальнейшей работы с ним
            authorization.readData();       //Передача списка СОТРУДНИКОВ из файла в класс Authorization для дальнейшей работы с ним
            authorization.readDataDep();    //Передача списка ОТДЕЛОВ из файла в класс Authorization для дальнейшей работы с ним


            System.out.print("\tВыберете необходимое действие: " +
                    "\n1. Авторизироваться;" +
                    "\n2. Регистрация нового сотрудника;" +
                    "\n3. Удаление учётной записи;" +
                    "\n4. Изменение данных о сотрудниках;" +
                    "\n5. Просмотр отчётов;" +
                    "\n6. Поиск по задаваемым параметрам;" +
                    "\n7. Завершение сеанса." +
                    "\nВыполнить - ");
            action = ScanAction.nextInt();
            if (action > 7 || action < 1) {
                System.out.println("Введена некорректная команда! Повторите!\n");
                continue;
            }

            if (action == 1)
                authorization.signIn();

            if (action == 2)
                authorization.registration();

            if (action == 3)
                authorization.deleteProfile();

            if (action == 5) {
                readAndSave.readData();
                readAndSave.readDataDep();
                authorization.readData();
                authorization.readDataDep();
                report.readData();
                report.readDataDep();
                int action2 = 0;
                while (action2 != 6) {
                    System.out.print("\n\nВыберете желаемый отчёт:" +
                            "\n1. Структура организации;" +
                            "\n2. Средняя ЗП по организации;" +
                            "\n3. Средняя ЗП по отделам;" +
                            "\n4. ТОП-10 самых высокооплачиваемых сотрудников;" +
                            "\n5. ТОП-10 самых преданных сотрудников;" +
                            "\n6. Выход." +
                            "\nВыполнить - ");
                    action2 = ScanAction.nextInt();
                    if (action2 == 1) report.allEmployees();
                    if (action2 == 2) report.averageSalary();
                    if (action2 == 3) report.avarageSalaryDep();
                    if (action2 == 4) report.maxSalary();
                    if (action2 == 5) report.maxExperience();
                }
            }

            if (action == 6) {
                readAndSave.readData();
                readAndSave.readDataDep();
                authorization.readData();
                authorization.readDataDep();
                report.readData();
                report.readDataDep();
                int action2 = 0;
                String action3 = null;
                while (action2 != 5) {
                    System.out.print("\n\nВыберете желаемый параметр для поиска:" +
                            "\n1. по ФИО;" +
                            "\n2. по должности;" +
                            "\n3. по названию отдела;" +
                            "\n4. по ФИО руководителя;" +
                            "\n5. Выход." +
                            "\nВыполнить - ");
                    action2 = ScanAction.nextInt();
                    if (action2 == 5)
                        continue;
                    System.out.print("Задайте параметр для поиска: ");
                    action3 = ScanActionString.nextLine();
                    report.searchEmployees(action2, action3);
                }
                /*readAndSave.saveDataDep(departments);*/
            }

            //ЗАПИСЬ списка сотрудников в файл
            /*readAndSave.saveData(employees);*/
        }
    }
}