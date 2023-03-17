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
public class trainPojo {

    public trainPojo() {
    }

    public trainPojo(int trainno, String from, String to, int firstfare, int secondfare, int thirdfare, int total) {
        this.trainno = trainno;
        this.from = from;
        this.to = to;
        this.firstfare = firstfare;
        this.secondfare = secondfare;
        this.thirdfare = thirdfare;
        this.total = total;
    }

    public int getTrainno() {
        return trainno;
    }

    public void setTrainno(int trainno) {
        this.trainno = trainno;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public int getFirstfare() {
        return firstfare;
    }

    public void setFirstfare(int firstfare) {
        this.firstfare = firstfare;
    }

    public int getSecondfare() {
        return secondfare;
    }

    public void setSecondfare(int secondfare) {
        this.secondfare = secondfare;
    }

    public int getThirdfare() {
        return thirdfare;
    }

    public void setThirdfare(int thirdfare) {
        this.thirdfare = thirdfare;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    int trainno;
    String from;
    String to;
    int firstfare;
    int secondfare;
    int thirdfare;
    int total;
}
