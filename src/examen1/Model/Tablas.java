package examen1.Model;


import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;

public class Tablas {

    SQL sql;

    public Tablas() {
        this.sql = new SQL();
    }

    public boolean UpdateAnyTable(String tableName, ArrayList Columnas, ArrayList NewData) {

        return true;
    }

    public boolean CreateUser(String Name, String DisplayName, String PassWord) {
        ArrayList<Object> objs = new ArrayList<>();
        objs.addAll(Arrays.asList(Name, DisplayName, PassWord));

        boolean result = sql.exec("INSERT INTO `Examen_Mario_Login` "
                + "(`Username`,`Password`,`DisplayName` ) "
                + "VALUES (?, ?, ?)", objs);
        if (result) {
            return true;
        } else {
            return false;
        }
    }

    public boolean Login(String Username, String Password) {
        ArrayList<Object> objs = new ArrayList<Object>();
        objs.addAll(Arrays.asList(Username, Password));
        ResultSet rs = sql.SELECT("Select `Username`,`Password` from `Examen_Mario_Login`Where `Username`=? and `Password`=? ", objs);
        if (sql.Exists(rs)) {
            return true;
        } else {
            return false;
        }

    }
}
