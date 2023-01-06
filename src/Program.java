import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        ReadAndSave readAndSave = new ReadAndSave();
        Authorization authorization = new Authorization();

        Scanner ScanAction = new Scanner(System.in);


                            //ТЕСТОВОЕ ДОБАВЛЕНИЕ ПОЛЬЗОВАТЕЛЯ!!!


                    //ЧТЕНИЕ файла и передача списка сотрудников через класс ReadAndSave в Main
        List <Employee> employees = readAndSave.getEmployees();
        readAndSave.readData();
        authorization.readData();
        /*List <Employee> employees = readAndSave.getEmployees();*/
        System.out.println("Список в Program: " + employees);
        int action = 0;
        System.out.print("\tДОБРО ПОЖАЛОВАТЬ!");
        while (action != 5) {
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
            if (action >7 || action <1) {
                System.out.println("Введена некорректная команда! Повторите!\n");
                continue;
            }

            if (action == 1)
                authorization.signIn();

            if (action == 2)
                authorization.registration();

            if (action == 3)
                authorization.deleteProfile();
        }


                    //ЗАПИСЬ списка сотрудников в файл
        /*readAndSave.saveData(employees);*/
    }
}