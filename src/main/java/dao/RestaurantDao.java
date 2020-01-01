package dao;

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

}
