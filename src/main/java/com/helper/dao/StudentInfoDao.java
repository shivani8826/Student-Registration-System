package com.helper.dao;

import com.helper.entity.StudentInfo;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class StudentInfoDao {

    @Autowired
    @Qualifier("hibernate4AnnotatedSessionFactory")
    private SessionFactory sessionFactory;


    public void save(StudentInfo p) throws Exception {
        Session session = this.sessionFactory.openSession();
        session.save(p);
        session.close();
    }


    public boolean emailExistOrNot(String email) throws Exception{

        try {
            Criteria criteria = sessionFactory.getCurrentSession().createCriteria(StudentInfo.class);
            criteria.add(Restrictions.like("email", email));
            StudentInfo studentInfo = (StudentInfo) criteria.uniqueResult();
            if (studentInfo == null)
                return true;
            else return false;
        }
        catch (Exception e){
            System.out.println(e);
            return false;
        }
    }





    public String getPassword(Integer id) throws Exception{
        Session session = this.sessionFactory.openSession();
        StudentInfo studentInfo= (StudentInfo) session.get(StudentInfo.class,id);
        if(studentInfo==null)
            return "null";
        String password = studentInfo.getPassword();
        session.close();
        return password;
    }



}
