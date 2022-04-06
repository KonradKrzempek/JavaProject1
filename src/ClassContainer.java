import java.sql.Array;
import java.util.*;

public class ClassContainer {
    Map<String, Class> map = new TreeMap<>();

    public void addClass(String nazwaGr, int size) {
        map.put(nazwaGr, new Class(nazwaGr, size));
        System.out.println("Dodano do kontenera: " + nazwaGr);
    }

    public void removeClass(String nazwaGrupy) {
        map.remove(nazwaGrupy);
        System.out.println("Usunieto z kontenera: " + nazwaGrupy);
    }

    public List<Class> findEmpty() {
        List<Class> lista = new ArrayList<>();
        for(String klucz : map.keySet()) {
            if(map.get(klucz).getIloscStudentow() == 0) {
                lista.add(map.get(klucz));
            }
        }
        return lista;
    }

    public void summary() {
        System.out.println("\nSummary: ");
        for(String klucz : map.keySet()) {
            double zapelnienie = (double) map.get(klucz).getIloscStudentow() / map.get(klucz).getMax();
            System.out.println(klucz + ", zapelnienie: " + zapelnienie * 100 + "%");
        }
    }
}

