/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @author ALUNO
 */
public class typeTicket {

    private String seat;
    private int passenger;
    private boolean connection;

    public typeTicket(int passenger, boolean connection) {
        this.passenger = passenger;
        this.connection = connection;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public int getPassenger() {
        return passenger;
    }

    public void setPassenger(int passenger) {
        this.passenger = passenger;
    }

    public boolean isConnection() {
        return connection;
    }

    public void setConnection(boolean connection) {
        this.connection = connection;
    }


}
