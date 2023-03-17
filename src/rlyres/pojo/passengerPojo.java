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
public class passengerPojo {

    public passengerPojo() {
    }

    public passengerPojo(String pname, long mobno, String ticketno, int tno, String coach, int tamount) {
        this.pname = pname;
        this.mobno = mobno;
        this.ticketno = ticketno;
        this.tno = tno;
        this.coach = coach;
        this.tamount = tamount;
    }

    

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public long getMobno() {
        return mobno;
    }

    public void setMobno(long mobno) {
        this.mobno = mobno;
    }

    

    public String getTicketno() {
        return ticketno;
    }

    public void setTicketno(String ticketno) {
        this.ticketno = ticketno;
    }
    String pname;
    long mobno;
    String ticketno;
    int tno;
    String coach;
    int tamount;

    public int getTno() {
        return tno;
    }

    public void setTno(int tno) {
        this.tno = tno;
    }

    public String getCoach() {
        return coach;
    }

    public void setCoach(String coach) {
        this.coach = coach;
    }

    public int getTamount() {
        return tamount;
    }

    public void setTamount(int tamount) {
        this.tamount = tamount;
    }
}
