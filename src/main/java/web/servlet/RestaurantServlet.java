package web.servlet;

import daomain.PageBean;
import daomain.Restaurant;
import daomain.Student;
import service.RestaurantService;
import service.StudentService;
import service.impl.RestaurantServiceImpl;
import service.impl.StudentServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @outhor li
 * @create 2020-01-01 21:13
 */
@WebServlet("/restaurant/*")
public class RestaurantServlet extends BaseServlet {
    RestaurantService restaurantService = new RestaurantServiceImpl();
    StudentService studentService = new StudentServiceImpl();

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
        if (currentPageStr != null && currentPageStr.length() > 0) {
            currentPage = Integer.parseInt(currentPageStr);
        } else {
            currentPage = 1;
        }
        //3.调用service查询
        PageBean<Restaurant> pb = restaurantService.pageQueryFood(currentPage, pageSize);
        writeValue(pb, response);
    }

    /**
     * 购买操作
     */
    public void buy(HttpServletRequest request, HttpServletResponse response) {
        //1.获取现在同学登录信息
        Student student = (Student) request.getSession().getAttribute("student");
        //查询
        student = studentService.login(student);
        //更新登录信息
        request.getSession().setAttribute("student", student);
        //2.获取页面信息
        int rnum = Integer.parseInt(request.getParameter("rnum"));
        int rmoney = Integer.parseInt(request.getParameter("rmoney"));
        //3.1减去用户响应钱数
        int money = student.getCmoney() - rmoney;
        //3.2调用service设置用户钱数
        studentService.recharge(student, money);
        //4.1设置设置餐厅收入
        restaurantService.addMoney(rnum, rmoney);
        //5.1设置消费记录
        restaurantService.setExpenses(student.getSnum(), rnum);

    }

    /**
     * 分页展示食堂销量排名窗口
     */
    public void pageQueryFoodRank(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //1.设置参数
        //设置当前页
        String currentPageStr = request.getParameter("currentPage");
        //设置页面大小
        int pageSize = 5;
        //2.处理参数
        int currentPage = 0;//默认第一页
        if (currentPageStr != null && currentPageStr.length() > 0) {
            currentPage = Integer.parseInt(currentPageStr);
        } else {
            currentPage = 1;
        }
        //3.调用service查询
        PageBean<Restaurant> pb = restaurantService.pageQueryFoodRank(currentPage, pageSize);
        writeValue(pb, response);
    }
}
