package service.impl;

import dao.StudentDao;
import dao.StudentDaoImpl.StudentDaoImpl;
import daomain.Student;
import service.StudentService;

/**
 * @outhor li
 * @create 2019-12-31 12:13
 */
public class StudentServiceImpl implements StudentService {
    private StudentDao studentDao = new StudentDaoImpl();
    /**
     * 登录功能
     * @param student
     * @return
     */
    @Override
    public Student login(Student student) {
        return studentDao.findStudentByIdAndPassword(student.getSnum(), student.getPassword());
    }

    /**
     * 用户注册功能
     * @param student
     */
    @Override
    public boolean regist(Student student) {
        //看有无重负用户
        Student student1 = studentDao.findStudentBySnum(student.getSnum());
        if (student1 != null){
            return false;
        }
        studentDao.saveStudent(student);
        return true;
    }

    /**
     * 用户充值
     * @param student
     */
    @Override
    public void recharge(Student student, int money) {
        studentDao.recharge(student.getSnum(), money);
    }
}
