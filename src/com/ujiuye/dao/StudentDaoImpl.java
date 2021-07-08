package com.ujiuye.dao;

import com.ujiuye.bean.Student;
import com.ujiuye.util.ThreadDruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class StudentDaoImpl implements StudentDao {
    private QueryRunner qr = new QueryRunner(ThreadDruidUtils.getDataSource());
    @Override
    public List<Student> getStudentDao() {

        String sql = "select * from student ";
        List<Student> sList = null;
        try {
            sList = qr.query(sql, new BeanListHandler<>(Student.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sList;
    }

    @Override
    public Student getDao(Student student) {
        String sql="select * from student where sname=?";
        Student query = null;
        try {
            query = qr.query(sql, new BeanHandler<>(Student.class), student.getSname());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return query;
    }
}
