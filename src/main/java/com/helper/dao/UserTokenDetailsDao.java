package com.helper.dao;

import com.helper.entity.UserInfo;
import com.helper.entity.UserTokenDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public class UserTokenDetailsDao {

    @Autowired
    @Qualifier("hibernate4AnnotatedSessionFactory")
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void save(UserTokenDetails userTokenDetails) throws Exception {
        Session session = this.sessionFactory.openSession();
        session.save(userTokenDetails);
        session.close();
    }



}
