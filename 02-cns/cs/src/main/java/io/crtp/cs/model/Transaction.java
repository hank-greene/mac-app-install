package io.crtp.cs.model;

public class Transaction {

    private String note = "not set";
    private String ammount = "not set";

    public void setNote( String n ) { note = n; }
    public String getNote() { return note; }

    public void setAmmount ( String a ) { ammount = a; }
    public String getAmmount() { return ammount; }
}
