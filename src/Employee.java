import java.io.Serializable;
import java.util.Date;

public class Employee implements Serializable{

    private String nameEmpl;    //ФИО сотрудника
    private String dateOfBirth;   //Дата рождения
    private boolean gender;    //Пол сотрудника
    private String numberPh;      //Номер телефона
    private String position;   //Должность
    private String nameDep;     //Название отдела
    private String nameChief;   //ФИО начальника отдела
    private Date dateEmpl;      //Дата приёма на работу
    private int salary;        //Зарплата
    private String nameGend;

    public Employee(String nameEml, String dateOfBirth, boolean gender, String numberPh, String position, String nameDep, String nameChief, Date dateEmpl, int salary) {
        this.nameEmpl = nameEml;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.numberPh = numberPh;
        this.position = position;
        this.nameDep = nameDep;
        this.nameChief = nameChief;
        this.dateEmpl = dateEmpl;
        this.salary = salary;
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

    public String checkGender (boolean gender) {
        this.gender=gender;
        if (gender)
            nameGend = "мусжкой";
        else nameGend = "женский";
        return nameGend;
    }

    public String toString() {
        checkGender(gender);
        return "Отдел - " +nameDep+ ", возглавляет " +nameChief+
                "\n" +nameEmpl+ " ("+dateOfBirth+ ", " +nameGend+ " пол) - " +position+ ". Принят " +dateEmpl+ ", ЗП = " +salary+ "руб.";
    }

}
