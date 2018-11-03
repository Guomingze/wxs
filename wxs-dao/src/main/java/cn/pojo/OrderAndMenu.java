package cn.pojo;


public class OrderAndMenu {
    private Integer oamid;
    private Integer oamnumber;
    private double oamoney;
    private String oam1;
    private String oam2;
    private String oam3;
    private Menu menuList;
    private Order order;

    public double getOamoney() {
        return this.oamoney;
    }

    public void setOamoney(double oamoney) {
        this.oamoney = oamoney;
    }

    public Menu getMenuList() {
        return menuList;
    }

    public void setMenuList(Menu menuList) {
        this.menuList = menuList;
    }

    public Integer getOamid() {
        return oamid;
    }

    public void setOamid(Integer oamid) {
        this.oamid = oamid;
    }

    public Order getOrder() {
        return this.order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Integer getOamnumber() {
        return oamnumber;
    }

    public void setOamnumber(Integer oamnumber) {
        this.oamnumber = oamnumber;
    }

    public String getOam1() {
        return oam1;
    }

    public void setOam1(String oam1) {
        this.oam1 = oam1;
    }

    public String getOam2() {
        return oam2;
    }

    public void setOam2(String oam2) {
        this.oam2 = oam2;
    }

    public String getOam3() {
        return oam3;
    }

    public void setOam3(String oam3) {
        this.oam3 = oam3;
    }

    @Override
    public String toString() {
        return "OrderAndMenu{" +
                "oamid=" + oamid +
                ", oamnumber=" + oamnumber +
                ", oamoney=" + oamoney +
                ", oam1='" + oam1 + '\'' +
                ", oam2='" + oam2 + '\'' +
                ", oam3='" + oam3 + '\'' +
                ", menuList=" + menuList +
                ", order=" + order +
                '}';
    }
}
