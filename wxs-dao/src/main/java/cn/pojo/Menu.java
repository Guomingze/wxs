package cn.pojo;


public class Menu {

  private Integer mid;
  private String mname;
  private Double mprice;
  private Integer mdishes;
  private Integer mstate;
  private Integer frequency;
  private String m1;
  private String m2;
  private String m3;

  public Integer getFrequency() {
    return this.frequency;
  }

  public void setFrequency(Integer frequency) {
    this.frequency = frequency;
  }

  public Integer getMid() {
    return mid;
  }

  public void setMid(Integer mid) {
    this.mid = mid;
  }

  public String getMname() {
    return mname;
  }

  public void setMname(String mname) {
    this.mname = mname;
  }

  public double getMprice() {
    return mprice;
  }

  public void setMprice(double mprice) {
    this.mprice = mprice;
  }

  public Integer getMdishes() {
    return mdishes;
  }

  public void setMdishes(Integer mdishes) {
    this.mdishes = mdishes;
  }

  public Integer getMstate() {
    return mstate;
  }

  public void setMstate(Integer mstate) {
    this.mstate = mstate;
  }

  public String getM1() {
    return m1;
  }

  public void setM1(String m1) {
    this.m1 = m1;
  }

  public String getM2() {
    return m2;
  }

  public void setM2(String m2) {
    this.m2 = m2;
  }

  public String getM3() {
    return m3;
  }

  public void setM3(String m3) {
    this.m3 = m3;
  }
  /*public String toString(){
    return  "menu{" +
            "mid" + mid +
            ",mname" + mname
  }*/
}
