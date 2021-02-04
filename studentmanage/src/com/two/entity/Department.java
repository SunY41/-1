package com.two.entity;

public class Department {
    private String dno;
    private String dname;

    public Department(String dno, String dname) {
        this.dno = dno;
        this.dname = dname;
    }

    public Department() {
    }

    public String getDno() {
        return dno;
    }

    public void setDno(String dno) {
        this.dno = dno;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    @Override
    public String toString() {
        return "Department{" +
                "dno='" + dno + '\'' +
                ", dname='" + dname + '\'' +
                '}';
    }
}
