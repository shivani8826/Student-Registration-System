package com.helper.dao;

import com.helper.entity.UserInfo;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserInfoDao {

    @Autowired
    @Qualifier("hibernate4AnnotatedSessionFactory")
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void save(UserInfo userInfo) throws Exception {
        Session session = this.sessionFactory.openSession();
        session.save(userInfo);
        session.close();
    }


    public boolean emailExistOrNot(String email) throws Exception{

        try {
            Criteria criteria = sessionFactory.getCurrentSession().createCriteria(UserInfo.class);
            criteria.add(Restrictions.like("email", email));
            UserInfo userInfo = (UserInfo) criteria.uniqueResult();
            if (userInfo == null)
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
        UserInfo userInfo = (UserInfo) session.get(UserInfo.class,id);

        if(userInfo ==null)
            return "null";

        String password = userInfo.getPassword();
        session.close();
        return password;
    }



    public Integer getUserType(Integer id) throws Exception{
        Session session = this.sessionFactory.openSession();
        UserInfo userInfo = session.get(UserInfo.class,id);
        if(userInfo==null)
            return -1;

        Integer userType = userInfo.isUserType();
        session.close();
        return userType;
    }



}
