import java.io.Serializable;
import java.util.List;

public class Department implements Serializable {

    private String nameDep;     //Название отдела
    private String nameChief;   //ФИО начальника отдела
    private boolean presChief;  //Наличие начальника в отделе

    public Department(String nameDep) {
        this.nameDep = nameDep;
    }


    public String getNameDep() {
        return nameDep;
    }

    public String getNameChief() {
        return nameChief;
    }

    public boolean isPresChief() {
        return presChief;
    }

    public void setNameDep(String nameDep) {
        this.nameDep = nameDep;
    }

    public void setNameChief(String nameChief) {
        this.nameChief = nameChief;
    }

    public void setPresChief(boolean presChief) {
        this.presChief = presChief;
    }


    public String toString() {
        Authorization authorization = new Authorization();
        nameChief = authorization.formedDepartaments(nameDep);
        return "\nОтдел - " + nameDep + ", возглавляет " + nameChief;}
}
