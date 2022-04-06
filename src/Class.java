import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Class {
    private String nazwaGrupy;
    private List<Student> listaSt;
    private int maxIlosc;

    public String getNazwaGrupy() {
        return nazwaGrupy;
    }

    public int getIloscStudentow() {
        return listaSt.size();
    }

    public int getMax() {
        return maxIlosc;
    }


    public Class(String nazwaGr, int maxIlosc) {
        this.nazwaGrupy = nazwaGr;
        this.maxIlosc = maxIlosc;

        this.listaSt = new ArrayList<>();
        System.out.println("\nStworzono grupe " + nazwaGr + "(" + maxIlosc + ")");
    }

    public void addStudent(Student student){
        if(listaSt.size() >= this.maxIlosc) {
            System.err.println("Przekroczono limit studentow w grupie");
            return;
        }

        for(Student student1 : listaSt) {
            if(student1.compareTo(student) == 0) { // studenci mają takie same nazwiska
                System.err.println("Student o takim nazwisku juz jest w tej grupie");
                return;
            }
        }

        listaSt.add(student);
        System.out.println("Dodano studenta " + student.Imie + " " + student.Nazwisko + " do grupy " + this.nazwaGrupy);
    }

    public void addPoints(Student student, double points) {
        System.out.println("+" + points + " pkt dla studenta: " + student.Imie + " " + student.Nazwisko);
        student.addPoints(points);
    }

    public void getStudent(Student student) {
        if(student.getPoints() == 0) {
            listaSt.remove(student);
            System.out.println("Usunieto studenta " + student.Imie + " " + student.Nazwisko + " z grupy " + this.nazwaGrupy);
            return;
        }
        System.out.println("Nie usunieto studenta " + student.Imie + " " + student.Nazwisko + " z grupy " + this.nazwaGrupy);
    }

    public void changeCondition(Student student, StudentCondition newCondition) {
        student.changeCondition(newCondition);
        System.out.println("Condition studenta " + student.Imie + " " + student.Nazwisko + " zmienione na " + newCondition);
    }

    public void removePoints(Student student, double points) {
        student.substractPoints(points);
        System.out.println("Studentowi " + student.Imie + " " + student.Nazwisko+ " odjeto: "+points + " pkt");
    }

    public Student search(String nazwisko) {
        for(Student student1 : listaSt) {
            if(student1.Nazwisko.equals(nazwisko)) {
                System.out.println("Znaleziono studenta o nazwisku " + nazwisko);
                return student1;
            }
        }

        System.err.println("Nie znaleziono studenta o nazwisku " + nazwisko);
        return null;
    }

    public ArrayList<Student> searchPartial(String partOfName) {
        ArrayList<Student> nowaLista = new ArrayList<>();

        for(Student student1 : listaSt) {
            for(int i = 0; i < student1.Nazwisko.length() - partOfName.length(); i++) {
                if(student1.Nazwisko.regionMatches(i,partOfName,0,partOfName.length())) {
                    nowaLista.add(student1);
                    break;
                }
            }
        }

        return nowaLista;
    }

    public int countByCondition(StudentCondition s) {
        int result = 0;
        for(Student student1 : listaSt) {
            if(student1.getCondition() == s) {
                result++;
            }
        }
        return result;
    }



    public void sortByName() {
        Collections.sort(listaSt);
    }

    public void sortByPoints() {
        MyComparator comp = new MyComparator();
        Collections.sort(listaSt, comp);

    }

    public Student max() { // TODO Collections.max
        return Collections.max(listaSt);
    }

    public void summary() {
        System.out.println("\nSummary grupy " + this.nazwaGrupy);
        for(Student student1 : listaSt) {
            student1.print();
        }
    }
}
