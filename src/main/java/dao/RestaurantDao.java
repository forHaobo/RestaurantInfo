package dao;

import daomain.Expenses;
import daomain.Restaurant;

import java.util.List;

/**
 * @outhor li
 * @create 2020-01-01 21:30
 */
public interface RestaurantDao {
    /**
     * 查询总记录数
     */
    public int findTotalCount();
    /**
     * 根据页码查询页面信息
     */
    public List<Restaurant> findByPage(int start);
    public List<Restaurant> findByPageRank(int start);

    /**
     * 根据rnum查询
     */
    public Restaurant findByRnum(int rnum);
    /**
     * 设置餐厅收入
     * @param rnum
     * @param rmoney
     */
    void addMoney(int rnum, int rmoney);

    /**
     * 设置消费记录
     * @param snum
     * @param rnum
     * @param rname
     */
    void setExpenses(String snum, int rnum, String rname);

    /**
     * 查询消费记录
     * @param snum
     * @return
     */
    List<Expenses> findPageBySnum(String snum, int start);
    List<Expenses> findBySnum(String snum);
}
