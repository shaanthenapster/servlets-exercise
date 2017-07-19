package Servlets;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

/**
 * Created by shaan on 28/6/17.
 */
public class TestData {
    public static void main(String[] args) {
            int status = 0;
        Scanner scr = new Scanner(System.in);
            String name,email , number ,password;
            name = scr.next();
            email =  scr.next();
            number =  scr.next();
            password = scr.next();

            try {
                Connection con = DbClass.conn();
                System.out.println(DbClass.conn());
                PreparedStatement pstm = con.prepareStatement("insert into User(uname,umail,unumber,upwd) VALUES(?,?,?,?)");
                pstm.setString(1,name);
                pstm.setString(2,email);
                pstm.setString(3,number);
                pstm.setString(4,password);
                status = pstm.executeUpdate();
                con.close();
            }catch (Exception e){e.printStackTrace();}
            if(status > 0)
            {
                System.out.println("value inserted :");
            }
            else
                System.out.println("error");

    }
}
