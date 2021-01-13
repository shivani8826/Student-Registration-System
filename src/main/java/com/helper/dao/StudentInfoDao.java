package com.helper.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class StudentInfoDao {

    @Autowired
    @Qualifier("hibernate4AnnotatedSessionFactory")
    private SessionFactory sessionFactory;


    public void save(StudentInfo p) {
        Session session = this.sessionFactory.openSession();
        session.save(p);
        session.close();
    }

    public Integer getID(StudentInfo studentInfo){
        return studentInfo.getStudentID();
    }

    public String getPassword(Integer id){
        Session session = this.sessionFactory.openSession();
        StudentInfo temp = (StudentInfo) session.get(StudentInfo.class,id);
        if(temp==null)
            return "null";
        String password = temp.getPassword();
        session.close();
        return password;
    }



}
