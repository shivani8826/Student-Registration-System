package com.helper.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.lang.annotation.Native;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

@Repository
@Transactional
public class CourseDetailDao {

    private static final long serialVersionUID = 1L;

    @Autowired
    @Qualifier("hibernate4AnnotatedSessionFactory")
    private SessionFactory sessionFactory;

    public List<CourseDetail> getAllCourses()
    {
        Session session=this.sessionFactory.openSession();

        String query="select Course_Id AS Course_Id,Course_Name AS Course_Name from CourseDetails where isActive = 1";
        NativeQuery nq = session.createSQLQuery(query);
        List<CourseDetail> allCourses = nq.list();

        session.close();
        return allCourses;

    }

    public String getCourse(Integer id){
        Session session = this.sessionFactory.openSession();
        CourseDetail temp = (CourseDetail) session.get(CourseDetail.class,id);
        if(temp==null)
            return "null";
        String course = temp.getCourse_Name();
        session.close();
        return course;
    }

}
