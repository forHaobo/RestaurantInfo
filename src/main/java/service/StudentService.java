package service;

import daomain.Student;

/**
 * @outhor li
 * @create 2019-12-31 12:12
 */
public interface StudentService {
    /**
     * 用户登录
     */
    public Student login(Student student);
}
