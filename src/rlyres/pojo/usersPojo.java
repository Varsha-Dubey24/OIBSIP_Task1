/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rlyres.pojo;

/**
 *
 * @author lenovo
 */
public class usersPojo {
    @Override
    public String toString() {
        return "users{" + "userid=" + userid + ", password=" + password + ", username=" + username + '}';
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    private String userid;
  private String password;
  private String username;
}
