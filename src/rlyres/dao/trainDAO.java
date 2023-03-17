/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rlyres.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import rlyres.dbutil.DBconnection;
import rlyres.pojo.trainPojo;

/**
 *
 * @author lenovo
 */
public class trainDAO {
    public static List<trainPojo> gettrainDetails() throws SQLException
    {
        Connection conn=DBconnection.getConnection();
        Statement st= conn.createStatement();
        ResultSet rs=st.executeQuery("select * from trains where status='Y' order by train_no");
        ArrayList <trainPojo> al=new ArrayList<>();
        while(rs.next())
        {
           trainPojo p = new trainPojo();
           p.setTrainno(rs.getInt(1));
           p.setFrom(rs.getString(2));
           p.setTo(rs.getString(3));
           p.setFirstfare(rs.getInt(4));
           p.setSecondfare(rs.getInt(5));
           p.setThirdfare(rs.getInt(6));
           al.add(p);
        }
        return al;
    }
}
