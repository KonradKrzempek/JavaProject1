import java.util.Comparator;

public class MyComparator implements Comparator<Student> {

    @Override
    public int compare(Student st1, Student st2) {
        return Double.compare(st1.getPoints(), st2.getPoints());
        }
}

