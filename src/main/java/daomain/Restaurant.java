package daomain;

/**
 * @outhor li
 * @create 2019-12-30 11:33
 */
public class Restaurant {
    private String rnum;
    private String rname;
    private int rmoney;
    private int rsum;
    private String image;

    public String getRnum() {
        return rnum;
    }

    public void setRnum(String rnum) {
        this.rnum = rnum;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public int getRmoney() {
        return rmoney;
    }

    public void setRmoney(int rmoney) {
        this.rmoney = rmoney;
    }

    public int getRsum() {
        return rsum;
    }

    public void setRsum(int rsum) {
        this.rsum = rsum;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "rnum=" + rnum +
                ", rname='" + rname + '\'' +
                ", rmoney=" + rmoney +
                ", rsum=" + rsum +
                '}';
    }
}
