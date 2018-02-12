package examen1.Model;

/**
 *
 * @author Mario
 */
public class User {

    public static String Displayname;

    public User(String displayname){
    this.Displayname=displayname;
    }
    public User() {

    }

    public String getDisplayname() {
        return Displayname;
    }

    public void setDisplayname(String Displayname) {
        this.Displayname = Displayname;
    }


}
