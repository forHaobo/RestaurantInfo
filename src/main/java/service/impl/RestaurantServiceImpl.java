package service.impl;

import dao.RestaurantDao;
import dao.StudentDaoImpl.RestaurantDaoImpl;
import daomain.Expenses;
import daomain.PageBean;
import daomain.Restaurant;
import daomain.Student;
import service.RestaurantService;

import java.util.List;

/**
 * @outhor li
 * @create 2020-01-01 21:22
 */
public class RestaurantServiceImpl implements RestaurantService {
    RestaurantDao restaurantDao = new RestaurantDaoImpl();
    private String snum;
    private int money;

    /**
     * 根据页码查询当前页
     * @param currentPage
     * @param pageSize
     * @return
     * private int totalCount; //   总记录数
     *     private int totalPage; //总页数
     *     private int currentPage; //当前页码
     *     private int pageSize; //每页显示条数
     *     private List<T> list; //   每页显示集合数
     */
    @Override
    public PageBean<Restaurant> pageQueryFood(int currentPage, int pageSize) {
        PageBean<Restaurant> pageBean = new PageBean<Restaurant>();
        //封装pageBean基本属性
        pageBean.setCurrentPage(currentPage);
        pageBean.setPageSize(pageSize);
        //总记录数
        int totalCount = restaurantDao.findTotalCount();
        pageBean.setTotalCount(totalCount);
        //当前页数据集合
        int start = (currentPage - 1)*pageSize;//开始的记录数
        List<Restaurant> page = restaurantDao.findByPage(start);
        pageBean.setList(page);
        //总页数
        int totalPage = totalCount % pageSize == 0? totalCount / pageSize :(totalCount / pageSize) + 1;
        pageBean.setTotalPage(totalPage);
        return pageBean;
    }
    @Override
    public PageBean<Restaurant> pageQueryFoodRank(int currentPage, int pageSize) {
        PageBean<Restaurant> pageBean = new PageBean<Restaurant>();
        //封装pageBean基本属性
        pageBean.setCurrentPage(currentPage);
        pageBean.setPageSize(pageSize);
        //总记录数
        int totalCount = restaurantDao.findTotalCount();
        pageBean.setTotalCount(totalCount);
        //当前页数据集合
        int start = (currentPage - 1)*pageSize;//开始的记录数
        List<Restaurant> page = restaurantDao.findByPageRank(start);
        pageBean.setList(page);
        //总页数
        int totalPage = totalCount % pageSize == 0? totalCount / pageSize :(totalCount / pageSize) + 1;
        pageBean.setTotalPage(totalPage);
        return pageBean;
    }

    /**
     * 设置餐厅收入
     * @param rnum
     * @param rmoney
     */
    @Override
    public void addMoney(int rnum, int rmoney) {
        //查询现有钱数
        rmoney = rmoney + restaurantDao.findByRnum(rnum).getRsum();
        restaurantDao.addMoney(rnum, rmoney);
    }

    /**
     * 设置购买消费记录
     * @param snum
     * @param rnum
     */
    @Override
    public void setExpenses(String snum, int rnum) {
        Restaurant restaurant = restaurantDao.findByRnum(rnum);
        String rname = restaurant.getRname();
        restaurantDao.setExpenses(snum, rnum, "买了"+rname);
    }
    /**
     * 设置充值消费记录
     * @param snum
     * @param money
     */
    @Override
    public void setInExpenses(String snum, int money) {
        String msg = "充值" + money;
        restaurantDao.setExpenses(snum, 0, msg);
    }

    /**
     * 分页查询消费记录
     * @param student
     * @return
     */
    @Override
    public List<Expenses> findPageBySnum(Student student,int currentPage) {

        return restaurantDao.findPageBySnum(student.getSnum(), currentPage);
    }

    /**
     * 查询消费记录
     * @param student
     * @return
     */
    @Override
    public List<Expenses> findBySnum(Student student) {

        return restaurantDao.findBySnum(student.getSnum());
    }


}
