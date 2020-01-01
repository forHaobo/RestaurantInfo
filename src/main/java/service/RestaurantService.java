package service;

import daomain.PageBean;
import daomain.Restaurant;

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
}
