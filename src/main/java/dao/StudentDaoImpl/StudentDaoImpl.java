package dao.StudentDaoImpl;

import dao.StudentDao;
import daomain.Student;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JDBCUtils;

/**
 * @outhor li
 * @create 2019-12-31 12:18
 */
public class StudentDaoImpl implements StudentDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    /**
     * 按用户名和密码查询
     * @param snum
     * @param password
     * @return
     */
    @Override
    public Student findStudentByIdAndPassword(String snum, String password) {
        Student student = null;
        try {
            String sql = "select * from student where snum = ? and password = ?";
            student = template.queryForObject(sql, new BeanPropertyRowMapper<Student>(Student.class), snum, password);
        }catch (Exception e){
            System.out.println("该用户不存在");
        }
        return student;
    }

    /**
     * 按照学号查询
     * @param snum
     * @return
     */
    @Override
    public Student findStudentBySnum(String snum) {
        Student student = null;
        try {
            String sql = "select * from student where snum = ?";
            student = template.queryForObject(sql, new BeanPropertyRowMapper<Student>(Student.class), snum);
        }catch (Exception e){
            System.out.println("该用户不存在");
        }
        return student;
    }


    /**
     * 用户注册
     * @param student
     */
    @Override
    public void saveStudent(Student student) {
        String sql = "insert into student(snum, password, sname, cmoney, able) value(?, ?, ?, ?, ?)";
        template.update(sql, student.getSnum(), student.getPassword(), student.getSname(), 0, 1);
    }

    /**
     * 用户充值
     * @param snum
     * @param money
     */
    @Override
    public void recharge(String snum, int money) {
        String sql = "update student set cmoney = ? where snum = ?";
        template.update(sql, money, snum);
    }
}
