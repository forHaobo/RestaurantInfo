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
        System.out.println(student);
        //3.调用Service查询
        Student loginStudent = studentService.login(student);

        ResultInfo resultInfo = new ResultInfo();
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
}
