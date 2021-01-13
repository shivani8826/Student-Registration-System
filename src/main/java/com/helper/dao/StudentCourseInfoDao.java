package com.helper.dao;

import ResponseEntity.CourseListResponse;
import net.sf.ehcache.hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import javax.security.auth.login.Configuration;
import java.time.LocalDate;
import java.util.List;

@Transactional
@Repository
public class StudentCourseInfoDao {

    @Autowired
    @Qualifier("hibernate4AnnotatedSessionFactory")
    private SessionFactory sessionFactory;

   // SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public void save (StudentCourseInfo studentCourseInfo)
    {
        Session session = this.sessionFactory.openSession();
        session.save(studentCourseInfo);
        session.close();
    }

    public List<CourseListResponse> getStudentIdNameDate(Integer studentId) {

        Session session = this.sessionFactory.openSession();

        String query = "select Course_Id ,Date_of_Registration from StudentCourseInfo where Student_Id = studentId";
        NativeQuery nq = session.createSQLQuery(query);
        List<CourseListResponse> allCourses = nq.list(); //giving error

        session.close();
        return allCourses;
    }
}
