package daomain;

/**
 * @outhor li
 * @create 2019-12-30 11:36
 */
public class Expenses {
    private String rnum;
    private String snum;
    private String emsg;

    public String getRnum() {
        return rnum;
    }

    public void setRnum(String rnum) {
        this.rnum = rnum;
    }

    public String getSnum() {
        return snum;
    }

    public void setSnum(String snum) {
        this.snum = snum;
    }

    public String getEmsg() {
        return emsg;
    }

    public void setEmsg(String emsg) {
        this.emsg = emsg;
    }

    @Override
    public String toString() {
        return "Expenses{" +
                "rnum='" + rnum + '\'' +
                ", snum='" + snum + '\'' +
                '}';
    }
}
