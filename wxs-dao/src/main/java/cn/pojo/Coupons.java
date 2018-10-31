package cn.pojo;


public class Coupons<lnteger> {

    private Integer cid;
    private Integer cname;
    private lnteger ctype;
    private double cmoney;
    private String c1;
    private String c2;
    private String c3;

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getCname() {
        return cname;
    }

    public void setCname(Integer cname) {
        this.cname = cname;
    }

    public long getCid() {
        return cid;
    }

    public lnteger getCtype() {
        return this.ctype;
    }

    public void setCtype(lnteger ctype) {
        this.ctype = ctype;
    }

    public double getCmoney() {
        return cmoney;
    }

    public void setCmoney(double cmoney) {
        this.cmoney = cmoney;
    }


    public String getC1() {
        return c1;
    }

    public void setC1(String c1) {
        this.c1 = c1;
    }


    public String getC2() {
        return c2;
    }

    public void setC2(String c2) {
        this.c2 = c2;
    }


    public String getC3() {
        return c3;
    }

    public void setC3(String c3) {
        this.c3 = c3;
    }

}
