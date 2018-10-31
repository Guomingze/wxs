package cn.pojo;


public class Order {

  private Integer oid;
  private User ouser;
  private Menu omenu;
  private double omoney;
  private Integer otype;
  private String o1;
  private String o2;
  private String o3;

  public Integer getOid() {
    return this.oid;
  }

  public void setOid(Integer oid) {
    this.oid = oid;
  }

  public User getOuser() {
    return this.ouser;
  }

  public void setOuser(User ouser) {
    this.ouser = ouser;
  }

  public Menu getOmenu() {
    return this.omenu;
  }

  public void setOmenu(Menu omenu) {
    this.omenu = omenu;
  }

  public double getOmoney() {
    return this.omoney;
  }

  public void setOmoney(double omoney) {
    this.omoney = omoney;
  }

  public Integer getOtype() {
    return this.otype;
  }

  public void setOtype(Integer otype) {
    this.otype = otype;
  }

  public String getO1() {
    return this.o1;
  }

  public void setO1(String o1) {
    this.o1 = o1;
  }

  public String getO2() {
    return this.o2;
  }

  public void setO2(String o2) {
    this.o2 = o2;
  }

  public String getO3() {
    return this.o3;
  }

  public void setO3(String o3) {
    this.o3 = o3;
  }
}
