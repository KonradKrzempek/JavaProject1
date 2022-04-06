import java.util.Comparator;

public class Student implements Comparable<Student> {
    public String Imie;
    public String Nazwisko;
    private StudentCondition stan;
    private int Uro;
    private double Pkt;

    public Student(String imie, String nazwisko, StudentCondition stanStudenta, int rokUrodzenia, double iloscPunktow) {
        this.Imie = imie;
        this.Nazwisko = nazwisko;
        this.stan = stanStudenta;
        this.Uro = rokUrodzenia;
        this.Pkt = iloscPunktow;

        System.out.println("Utworzono profil studenta " + imie + " " + nazwisko);
    }

    public void print() {
        System.out.print("\nWszystkie dane studenta: ");
        System.out.println(Imie + " " + Nazwisko);
        System.out.print("stan: " + stan);
        System.out.print(", data urodzenia: " + Uro);
        System.out.print(", ilosc punktow: " + Pkt +"\n");
    }


    public double getPoints() {
        return this.Pkt;
    }

    public void addPoints(double points) {
        this.Pkt += points;
    }

    public void substractPoints(double points) {
        this.Pkt -= points;
    }

    public StudentCondition getCondition() {return this.stan;}

    public void changeCondition(StudentCondition s) {
        this.stan = s;
    }

    @Override
    public int compareTo(Student st) {

        return this.Nazwisko.compareTo(st.Nazwisko);
    }
}