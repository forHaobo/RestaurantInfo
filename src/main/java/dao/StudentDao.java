package dao;

import daomain.Student;

/**
 * @outhor li
 * @create 2019-12-31 12:15
 */
public interface StudentDao {
    /**
     * 按照用户名查询密码
     */
    public Student findStudentById(String snum, String password);
}
