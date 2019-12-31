package daomain;

/**
 * @outhor li
 * @create 2019-12-30 11:30
 */
public class Student {
    private String snum;
    private String password;
    private String sname;
    private int cmoney;
    private int able;//0表示不可用，1表示可用

    public String getSnum() {
        return snum;
    }

    public void setSnum(String snum) {
        this.snum = snum;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public int getCmoney() {
        return cmoney;
    }

    public void setCmoney(int cmoney) {
        this.cmoney = cmoney;
    }

    public int getAble() {
        return able;
    }

    public void setAble(int able) {
        this.able = able;
    }

    @Override
    public String toString() {
        return "Student{" +
                "snum='" + snum + '\'' +
                ", password='" + password + '\'' +
                ", sname='" + sname + '\'' +
                ", cmoney=" + cmoney +
                ", able=" + able +
                '}';
    }
}
