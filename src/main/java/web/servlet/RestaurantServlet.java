package web.servlet;

import daomain.PageBean;
import daomain.Restaurant;
import service.RestaurantService;
import service.impl.RestaurantServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @outhor li
 * @create 2020-01-01 21:13
 */
@WebServlet("/restaurant/*")
public class RestaurantServlet extends BaseServlet{
    RestaurantService restaurantService = new RestaurantServiceImpl();
    /**
     * 分页展示食堂窗口
     */
    public void pageQueryFood(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //1.设置参数
        //设置当前页
        String currentPageStr = request.getParameter("currentPage");
        //设置页面大小
        int pageSize = 5;
        //2.处理参数
        int currentPage = 0;//默认第一页
        if (currentPageStr != null && currentPageStr.length() > 0){
            currentPage = Integer.parseInt(currentPageStr);
        }else {
            currentPage = 1;
        }
        //3.调用service查询
        PageBean<Restaurant> pb = restaurantService.pageQueryFood(currentPage, pageSize);
        writeValue(pb, response);
    }
}
