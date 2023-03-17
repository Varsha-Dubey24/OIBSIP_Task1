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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import rlyres.dbutil.DBconnection;
import rlyres.pojo.passengerPojo;

/**
 *
 * @author lenovo
 */
public class passengerDAO {
    public static String getNextTrainNo() throws SQLException 
    {
        Connection conn=DBconnection.getConnection();
        Statement st= conn.createStatement();
        ResultSet rs=st.executeQuery("select max(TICKETNO) from passenger");
        rs.next();
        String ticketno=rs.getString(1);
        if(ticketno==null){
            return "T101";
        }
        int empno=Integer.parseInt(ticketno.substring(1));
        empno=empno+1;
        return "T"+empno;
    }
    public static int getamount(String t,String c) throws SQLException
    {
        Connection conn=DBconnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("select * from trains where FROM_CITY=? and TO_CITY=?");
        ps.setString(1, t.substring(0,t.indexOf('-')-1));
        ps.setString(2,t.substring(t.indexOf('-')+2,t.length()));
        ResultSet rs=ps.executeQuery();
        rs.next();
        
        int fare;
        if(c.equals("FIRST_AC_FARE"))
            fare=rs.getInt(4);
        else if(c.equals("SECOND_AC_FARE"))
            fare=rs.getInt(5);
                    else
            fare=rs.getInt(6);
        return fare;
    }
    public static int Train_No(String t) throws SQLException
    {
        Connection conn=DBconnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("select train_no from trains where FROM_CITY=? and TO_CITY=?");
        ps.setString(1, t.substring(0,t.indexOf('-')-1));
        ps.setString(2,t.substring(t.indexOf('-')+2,t.length()));
        ResultSet rs=ps.executeQuery();
        rs.next();
        
        int trainno;
        trainno=rs.getInt(1);
        return trainno;
    }
    public static boolean addProduct(passengerPojo p)throws SQLException
    {
        Connection conn=DBconnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("insert into passenger values (?,?,?,?,?,?)");
        ps.setString(1,p.getPname());
        ps.setString(2,p.getTicketno()+"");
        ps.setLong(3,p.getMobno());
        ps.setString(4,p.getCoach());
        ps.setDouble(5,p.getTno());
        ps.setInt(6,p.getTamount());
        return ps.executeUpdate()==1;
    }
    public static Map<String,String>  getAllTicketNo() throws SQLException
    {
        Connection conn=DBconnection.getConnection();
        Statement st= conn.createStatement();
        ResultSet rs=st.executeQuery("select ticketno,pname from passenger order by ticketno");
        HashMap<String,String> tList=new HashMap<>();
        while(rs.next())
                {
                    String tno=rs.getString(1);
                    String name=rs.getString(2);
                    tList.put(tno,name);
                }
        return tList;
    }
    public static boolean deleteTicket(String ticketno) throws SQLException
  {
       Connection conn=DBconnection.getConnection();
      PreparedStatement ps=conn.prepareStatement("Delete from passenger where ticketno=?");
      ps.setString(1,ticketno);
      return ps.executeUpdate()==1;   
  }
    public static passengerPojo getTicketDetails(String str) throws SQLException
    {
        passengerPojo p=new passengerPojo();
        Connection conn=DBconnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("select * from passenger where ticketno=?");
        ps.setString(1, str);
        ResultSet rs=ps.executeQuery();
        rs.next();
        
        p.setPname(rs.getString(1));
        p.setTicketno(rs.getString(2));
        //System.out.println(rs.getLong(3));
        p.setMobno(rs.getLong(3));
        p.setCoach(rs.getString(4));
        p.setTno(rs.getInt(5));
        p.setTamount(rs.getInt(6));
        return p;
    }
}
