package com.helper.dao;

import com.helper.dto.response.AdminView;
import com.helper.entity.StudentCourseInfo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentCourseInfoDao {

    @Autowired
    @Qualifier("hibernate4AnnotatedSessionFactory")
    private SessionFactory sessionFactory;

    public void save (StudentCourseInfo studentCourseInfo)
    {
        Session session = this.sessionFactory.openSession();
        session.save(studentCourseInfo);
        session.close();
    }

    public List<Object>getStudentIdNameDate (Integer studentId) throws Exception {

        Session session = this.sessionFactory.openSession();

        List<Object> coursesOfAStudent = session.createNativeQuery(
                "select student_course_info.course_id ,student_course_info.date_of_registration,course_detail.course_name from student_course_info INNER JOIN course_detail ON course_detail.course_id = student_course_info.course_id where student_course_info.student_id = ?")
                .setParameter(1, studentId).list();

        session.close();
        return coursesOfAStudent;
    }

    public boolean isIdAlreadyExist(Integer id){
         Session session = this.sessionFactory.openSession();
       List<StudentCourseInfo>studentCourseInfos = session.createNativeQuery("select * from student_course_info where student_id=?")
               .setParameter(1, id).list();

        if (studentCourseInfos.size() != 0) {
            return true;
        } else {
            return false;
        }
    }

    public List<Object> adminViewAllStudentInfo ()
    {
        Session session = this.sessionFactory.openSession();
        List<Object> adminViewRespons = session.createNativeQuery("select student_course_info.student_id,student_course_info.course_id,course_detail.course_name from student_course_info INNER JOIN course_detail ON course_detail.course_id = student_course_info.course_id").list();
        return adminViewRespons;
    }

}
