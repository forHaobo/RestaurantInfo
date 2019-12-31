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
        return studentDao.findStudentById(student.getSnum(), student.getPassword());
    }
}
