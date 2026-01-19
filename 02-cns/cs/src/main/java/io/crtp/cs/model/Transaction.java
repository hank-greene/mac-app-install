package io.crtp.cs.model;

public class Transaction {

    private String note = "not set";
    private String ammountStr = "not set";
    private Double ammount = -1.0; 

    public void setNote( String n ) { note = n; }
    public String getNote() { return note; }

    public void setAmmountStr ( String a ) { ammountStr = a; }
    public String getAmmountStr() { return ammountStr; }

    public void setAmmount ( Double d ) { ammount = d; }
    public Double getAmmount() { return ammount; }
}
