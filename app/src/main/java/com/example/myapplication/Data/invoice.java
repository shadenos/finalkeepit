package com.example.myapplication.Data;

public class invoice {

    private String name;
    private String PDate;
    private String EDate;


    public invoice(String name, String PDate, String EDate) {
        this.name = name;
        this.PDate = PDate;
        this.EDate = EDate;
    }

    public String getName() {
        return name;
    }

    public String getPDate() {
        return PDate;
    }

    public String getEDate() {
        return EDate;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setPDate(String PDate) {
        this.PDate = PDate;
    }

    public void setEDate(String EDate) {
        this.EDate = EDate;
    }
}
