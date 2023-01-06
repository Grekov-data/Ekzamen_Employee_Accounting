import java.io.Serializable;
import java.util.Date;

public class Employee implements Serializable{

    private String nameEmpl;    //ФИО сотрудника
    private String dateOfBirth;   //Дата рождения
    private boolean gender;    //Пол сотрудника (true - мужской, 0 - женский)
    private String numberPh;      //Номер телефона
    private String position;   //Должность
    private String nameDep;     //Название отдела
    private String nameChief;   //ФИО начальника отдела
    private Date dateEmpl;      //Дата приёма на работу
    private int salary;        //Зарплата
    private String nameGend;   //Название пола сотрудника (исходя из переменной gender)
    private String login;
    private String password;

    public String getNameEmpl() {return nameEmpl;}
    public String getDateOfBirth() {return dateOfBirth;}
    public String getLogin() {return login;}

    public String getPassword() {return password;}

    public Employee(String nameEmpl, String dateOfBirth, boolean gender, String numberPh, String position,
                    String nameDep, String nameChief, Date dateEmpl, int salary, String login,
                    String password) {
        this.nameEmpl = nameEmpl;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.numberPh = numberPh;
        this.position = position;
        this.nameDep = nameDep;
        this.nameChief = nameChief;
        this.dateEmpl = dateEmpl;
        this.salary = salary;
        this.login = login;
        this.password = password;
    }

    public void setNameEmpl(String nameEmpl) {
        this.nameEmpl = nameEmpl;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public void setNumberPh(String numberPh) {
        this.numberPh = numberPh;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setNameDep(String nameDep) {
        this.nameDep = nameDep;
    }

    public void setNameChief(String nameChief) {
        this.nameChief = nameChief;
    }

    public void setDateEmpl(Date dateEmpl) {
        this.dateEmpl = dateEmpl;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setNameGend(String nameGend) {
        this.nameGend = nameGend;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String checkGender (boolean gender) {
        this.gender=gender;
        if (gender)
            nameGend = "мусжкой";
        else nameGend = "женский";
        return nameGend;
    }

    public String toString() {
        checkGender(gender);
        return "\nОтдел - " +nameDep+ ", возглавляет " +nameChief+
                "\n" +nameEmpl+ " ("+dateOfBirth+ ", " +nameGend+ " пол) - " +position+ ". Принят " +dateEmpl+ ", ЗП = " +salary+ "руб." + "\nЛогин: "+login;
    }

}
