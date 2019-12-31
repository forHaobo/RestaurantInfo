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
     * 按用户名查询密码
     * @param snum
     * @param password
     * @return
     */
    @Override
    public Student findStudentById(String snum, String password) {
        Student student = null;
        try {
            String sql = "select * from student where snum = ? and password = ?";
            student = template.queryForObject(sql, new BeanPropertyRowMapper<Student>(Student.class), snum, password);
        }catch (Exception e){
            System.out.println("该用户不存在");
        }
        return student;
    }
}
