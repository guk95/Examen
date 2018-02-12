/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen1.Model;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.Types;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 *
 * @author Mario
 */
public class ChatBox extends Thread {

    SQL sql;

    public ChatBox() {
        this.sql = new SQL();

    }

    @Override
    public void run() {

    }

    /**
     * Toma la fecha y le da el formto especificado
     *
     * @param
     * @return la fecha actual con el formato especificado
     */
    public String getDate() {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd hh:mm:ss");

        return dateFormat.format(date);
    }
       public String getTime() {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm:ss");
        return dateFormat.format(date);
    }

    /**
     * Lee los ultimos 10 mensajes la base de datos.
     *
     * @param
     * @return return un ResulSet
     */
    public ResultSet readDB() {
        ArrayList<Object> objs = new ArrayList<>();
        ResultSet rs = sql.SELECT("Select `Displayname`,`Message`,`Date`"
                + " From `ChatBox` group by `IdMessage` desc limit 10; ", objs);
        return rs;
    }

    /**
     * Añade un mesaje a la base de datos.
     *
     * @param Displayname, Message
     * @return return true si se agrego correctament y false sino
     */
    public boolean sendtoDB(String Displayname, String Message) {
        ArrayList<Object> objs = new ArrayList<>();
        objs.addAll(Arrays.asList(Displayname, Message, getDate()));

        try {
            boolean result = sql.exec("INSERT INTO `ChatBox` "
                    + "(`Displayname`, `Message`,`Date` ) "
                    + "VALUES (?, ?, CAST(? AS DATETIME))", objs);
            return true;

        } catch (Exception e) {
            System.out.println("error  " + e);
            return false;
        }

    }

}
