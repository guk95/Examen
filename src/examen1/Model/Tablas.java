package examen1.Model;

import java.util.ArrayList;
import java.util.Arrays;

public class Tablas {

    public Tablas() {

    }

    public boolean UpdateAnyTable(String tableName, ArrayList Columnas, ArrayList NewData) {

        return true;
    }

    public boolean CreateUser(String Name, String DisplayName, String PassWord) {
        ArrayList<Object> objs = new ArrayList<>();
        objs.addAll(Arrays.asList(Name, DisplayName, PassWord));
        
        return true;
    }
;

}
