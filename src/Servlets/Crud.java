package Servlets;
import java.sql.*;
import java.lang.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by shaan on 26/6/17.
 */
public class Crud {
    public static int registerUser(Bean bean) {
        int status = 0;
        try {
            Connection con = DbClass.conn();
            System.out.println(DbClass.conn());
            PreparedStatement pstm = con.prepareStatement("insert into User(uname,umail,unumber,upwd) VALUES(?,?,?,?)");
            pstm.setString(1, bean.getUname());
            pstm.setString(2, bean.getUmail());
            pstm.setString(3, bean.getUnumber());
            pstm.setString(4, bean.getUpwd());
            status = pstm.executeUpdate();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public static Bean loginUser(Bean po) {
        ResultSet rs = null;
        PreparedStatement stmt = null;
        String searchQuery = "select * from User where umail = ? AND  upwd = ?";
        try {
            Connection con = DbClass.conn();
            stmt = con.prepareStatement(searchQuery);
            stmt.setString(1,po.getUmail());
            stmt.setString(2,po.getUpwd());
            System.out.println(po.getUmail());
            System.out.println(po.getUpwd());
            rs = stmt.executeQuery();
            boolean more = rs.next();
            if (!more) {
                System.out.println("not a valid user! sign up first");
                po.setValid(false);
            } else if (more) {
                String uname = rs.getString("uname");
                String upassword = rs.getString("upwd");
                int uid = rs.getInt("uid");
                System.out.println("Welcome " + uname +" "+"uid"+uid);
                po.setUname(uname);
                po.setUpwd(upassword);
                po.setUid(uid);
                po.setValid(true);
                rs.close();
                stmt.close();
                con.close();
            }

        } catch (Exception ex) {
            System.out.println("login failed" + ex);
            ex.printStackTrace();
        }
        return po;
    }
    public static int insertblog(Bean bean) {
        int status = 0;
        try {
            Connection con = DbClass.conn();
            System.out.println(DbClass.conn());
            PreparedStatement pstm = con.prepareStatement("insert into blogtable(uid,blog) VALUES(?,?)");
            pstm.setInt(1, bean.getUid());
            pstm.setString(2, bean.getBlog());
            status = pstm.executeUpdate();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }
    public static List<Bean> getAllRecords(){
        List<Bean> list=new ArrayList<>();

        try{
            Connection con= DbClass.conn();
            PreparedStatement ps=con.prepareStatement("select * from blogtable");
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Bean u=new Bean();
                u.setBlogid(rs.getInt("id"));
                u.setBlog(rs.getString("name"));
                list.add(u);
            }
        }catch(Exception e){System.out.println(e);}
        return list;
    }


}

