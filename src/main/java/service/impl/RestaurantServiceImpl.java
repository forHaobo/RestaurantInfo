package service.impl;

import dao.RestaurantDao;
import dao.StudentDaoImpl.RestaurantDaoImpl;
import daomain.PageBean;
import daomain.Restaurant;
import service.RestaurantService;

import java.util.List;

/**
 * @outhor li
 * @create 2020-01-01 21:22
 */
public class RestaurantServiceImpl implements RestaurantService {
    RestaurantDao restaurantDao = new RestaurantDaoImpl();

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
}
