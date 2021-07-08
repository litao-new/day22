package com.ujiuye.service;

import com.ujiuye.bean.Student;
import com.ujiuye.dao.StudentDaoImpl;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    @Override
    public List<Student> getStudentService(Student student) {
        StudentDaoImpl studentDao = new StudentDaoImpl();
        List<Student> sDao = studentDao.getStudentDao();
        return sDao;
    }

    @Override
    public Student getService(Student student) {
        StudentDaoImpl studentDao = new StudentDaoImpl();
        Student dao = studentDao.getDao(student);
        return dao;
    }
}
