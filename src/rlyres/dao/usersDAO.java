/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rlyres.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import rlyres.dbutil.DBconnection;
import rlyres.pojo.UserProfile;
import rlyres.pojo.usersPojo;

/**
 *
 * @author lenovo
 */
public class usersDAO {
   public static boolean validateUser(usersPojo user)throws SQLException
    {
        Connection conn=DBconnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("select * from users where userid=? and password=?");
        ps.setString(1,user.getUserid());
        ps.setString(2,user.getPassword());
        ResultSet rs= ps.executeQuery();
        if(rs.next())
                {
                  String username=rs.getString(3); 
                  UserProfile.setUsername(username);
                  return true;
                }
        return false;
    }
   public static boolean addDetails(String name,String id,String pwd) throws SQLException
   {
       Connection conn=DBconnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("insert into users values (?,?,?)");
        ps.setString(1,id);
        ps.setString(2,name);
        ps.setString(3,pwd);
        int result=ps.executeUpdate();
        return result==1;
   }
//    public static boolean isUserPresent(String empid) throws SQLException
//    {
//       Connection conn=DBconnection.getConnection();
//       PreparedStatement ps=conn.prepareStatement("select 1 from users where empid=?"); 
//       ps.setString(1, empid);
//       ResultSet rs=ps.executeQuery();
//       return rs.next();
//    }  
}
