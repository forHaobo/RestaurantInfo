package web.servlet;

import daomain.ResultInfo;
import daomain.Student;
import org.apache.commons.beanutils.BeanUtils;
import service.StudentService;
import service.impl.StudentServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @outhor li
 * @create 2019-12-31 12:03
 */
@WebServlet("/student/*")
public class StudentServlet extends BaseServlet {
    private StudentService studentService = new StudentServiceImpl();
    /**
     * 登录功能
     */
    public void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //结果集对象
        ResultInfo resultInfo = new ResultInfo();
        //获取验证码
        String verifycode = request.getParameter("verifycode");
        //标准验证码
        String checkCode = (String) request.getSession().getAttribute("CHECKCODE_SERVER");
        //验证码只能使用一次，获取后删除
        request.getSession().removeAttribute("CHECKCODE_SERVER");
        //判断验证码
        if (verifycode == null || !verifycode.equalsIgnoreCase(checkCode)){
            resultInfo.setFlag(false);
            resultInfo.setErrorMsg("验证码错误");
            writeValue(resultInfo, response);
            return;
        }

        //1.获取用户名和密码数据
        Map<String, String[]> parameterMap = request.getParameterMap();
        //2.封装student对象
        Student student = new Student();
        try {
            BeanUtils.populate(student, parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        //3.调用Service查询
        Student loginStudent = studentService.login(student);

        if ( loginStudent == null){
            //用户名或密码不存在
            resultInfo.setFlag(false);
            resultInfo.setErrorMsg("用户名或密码不存在");
        }else {
            //登录成功
            resultInfo.setFlag(true);
            resultInfo.setData(loginStudent);
            //标记
            request.getSession().setAttribute("student",student);
        }

        writeValue(resultInfo, response);
    }

    /**
     * 注册功能
     */
    public void regist(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Student student = new Student();
        ResultInfo resultInfo = new ResultInfo();
        //1.获取页面参数并封装对象
        Map<String, String[]> parameterMap = request.getParameterMap();
        try {
            BeanUtils.populate(student, parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //2.调用service保存用户
        boolean regist = studentService.regist(student);
        //3.封装并写回页面
        if (regist){
            resultInfo.setFlag(regist);
        }else {
            resultInfo.setFlag(regist);
            resultInfo.setErrorMsg("该用户已经存在");
        }
        writeValue(resultInfo, response);
    }

    /**
     * 学生信息展示
     */
    public void info(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //1.获取现在登录同学信息
        Student student = (Student) request.getSession().getAttribute("student");
        //查询
        Student login = studentService.login(student);
        //更新登录信息
        request.getSession().setAttribute("student", login);
        //2.将查询到的完整信息写回
        writeValue(login, response);
    }
    /**
     * 饭卡充值
     */
    public void recharge(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //1.获取现在同学登录信息
        Student student = (Student) request.getSession().getAttribute("student");
        //查询
        student = studentService.login(student);
        //更新登录信息
        request.getSession().setAttribute("student", student);
        //2.获取页面信息
        int money = Integer.parseInt(request.getParameter("recharge"));
        money = money + student.getCmoney();
        //3.调用service充值
        studentService.recharge(student, money);
        writeValue(money, response);
    }


}
