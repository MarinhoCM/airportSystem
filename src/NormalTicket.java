/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @author MarinhoCM
 */
public class normalTicket extends typeTicket {

    private int baggage = 10;
    private float refund;

    public normalTicket(int passenger, boolean connection, String seat, float refund) {
        super(passenger, connection);
        setSeat(seat);
        this.refund = refund;
    }

    public int getBaggage() {
        return baggage;
    }

    public void setBaggage(int baggage) {
        this.baggage += baggage;
    }

    public float getRefund() {
        return refund;
    }

    public void setRefund(float refund) {
        this.refund = refund;
    }

}
