import java.util.List;

public class Main {

    public static void main(String[] args) {
        Student s1 = new Student("Jan", "Kowalski", StudentCondition.odrabiajacy ,  2000, 5);
        Student s2 = new Student("Mieszko", "Pierwszy", StudentCondition.nieobecny ,  2000, 9);
        Student s3 = new Student("Robert", "Maklowicz", StudentCondition.chory ,  2001, 20);
        Student s4 = new Student("Robert", "Lewandowski", StudentCondition.chory ,  2001, 10);
        Student s5 = new Student("Sebastian", "Jakistam", StudentCondition.odrabiajacy ,  2002, 0);

        System.out.println("\nMetoda print: ");
        s1.print();

        System.out.println("\n\naddStudent: Dodawanie studentow do grup");
        Class grupa = new Class("grupa", 5);
        grupa.addStudent(s1);
        grupa.addStudent(s2);
        grupa.addStudent(s3);
        grupa.addStudent(s4);
        grupa.addStudent(s5);

        System.out.println("\n\nInterfejs Comparable: " + s1.Imie+ " " + s1.Nazwisko + " porowanie z: " +
                s2.Imie + " " + s2.Nazwisko + ":");
        System.out.println(s1.compareTo(s2));

        System.out.println("\naddPoints: ");
        grupa.addPoints(s1, 14);
        s1.print();

        System.out.println("\ngetStudent: ");//usniecie z grupy studenta z 0 punktow
        grupa.getStudent(s5);
        grupa.getStudent(s4);

        System.out.println("\nchangeCondition: ");
        grupa.changeCondition(s1, StudentCondition.chory);
        s1.print();

        System.out.println("\nremovePoints: ");
        grupa.removePoints(s1, 4);
        s1.print();

        System.out.println("\nsearch: ");
        grupa.search("Lewandowski").print();

        System.out.println("\nsearchPartial");
        String czesc = "ow";
        List<Student> lista = grupa.searchPartial(czesc);
        for(Student st : lista) {
            System.out.println("Student  z częścią '" + czesc + "' w nazwisku: " + st.Imie + " " + st.Nazwisko);
        }

        System.out.println("\nCountByCondition: ");
        System.out.println("Ilosc " + StudentCondition.odrabiajacy + ": " + grupa.countByCondition(StudentCondition.odrabiajacy));
        System.out.println("Ilosc " + StudentCondition.nieobecny + ": " + grupa.countByCondition(StudentCondition.nieobecny));
        System.out.println("Ilosc " + StudentCondition.chory + ": " + grupa.countByCondition(StudentCondition.chory));

        grupa.summary();

        System.out.println("\nsortByName"); //alfabetycznie
        grupa.sortByName();
        grupa.summary();

        System.out.println("\nsortByPoints"); //malejaco
        grupa.sortByPoints();
        grupa.summary();

        System.out.println("\nColletions.max():");
        grupa.max().print();

        ClassContainer container = new ClassContainer();
        container.addClass("grTest1", 4);
        container.addClass("grTest2", 4);
        container.addClass("grTest3", 4);

        System.out.println("\nremoveClass: ");
        container.removeClass("grTest3");

        System.out.println("\nfindEmpty:");
        List<Class> listaPuste = container.findEmpty();
        for(Class o : listaPuste) {
            System.out.println("grupa: " + o.getNazwaGrupy());
        }

        System.out.println("\ncontainer.Summary:");
        container.summary();

        container.map.get("grTest1").addStudent(s1);
        container.summary();

        System.out.println("\nPrzykladowe kody bledow: ");

        Class grupa2 = new Class("grupa2", 2);
        grupa2.addStudent(s1);
        grupa2.addStudent(s1);
        grupa2.addStudent(s2);
        grupa2.addStudent(s3);
        grupa2.search("Zaliczenie");

    }
}
