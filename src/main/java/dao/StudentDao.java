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
    public Student findStudentByIdAndPassword(String snum, String password);
    /**
     * 按学号查
     */
    public Student findStudentBySnum(String snum);
    /**
     * 用户注册
     */
    public void saveStudent(Student student);
    /**
     * 用户充值
     */
    public void recharge(String snum, int money);
}
