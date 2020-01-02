package service;

import daomain.Expenses;
import daomain.PageBean;
import daomain.Restaurant;
import daomain.Student;

import java.util.List;

/**
 * @outhor li
 * @create 2020-01-01 21:22
 */
public interface RestaurantService {
    /**
     * 根据页码查询当前页
     * @param currentPage
     * @param pageSize
     * @return
     */
    PageBean<Restaurant> pageQueryFood(int currentPage, int pageSize);
    public PageBean<Restaurant> pageQueryFoodRank(int currentPage, int pageSize);
    /**
     * 设置餐厅收入
     */
    public void addMoney(int rnum, int rmoney);

    /**
     * 设置消费记录
     * @param snum
     * @param rnum
     */
    void setExpenses(String snum, int rnum);

    public void setInExpenses(String snum, int money);

    /**
     * 查询消费记录
     */
    List<Expenses> findPageBySnum(Student student,int currentPage);

    public List<Expenses> findBySnum(Student student);
}
