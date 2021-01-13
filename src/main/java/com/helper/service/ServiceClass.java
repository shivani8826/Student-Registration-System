package com.helper.service;

import ResponseEntity.*;
import com.helper.dao.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ServiceClass {

    @Autowired
    private StudentInfoDao studentInfoDao;

    @Autowired
    private CourseDetailDao courseDetailDao;

    @Autowired
    private StudentCourseInfoDao studentCourseInfoDao;


    @Transactional
    public void save(StudentInfo studentInfo) {
        studentInfoDao.save(studentInfo);
    }


    public int getId(StudentInfo studentInfo) {
        return studentInfoDao.getID(studentInfo);
    }


    /*  ------    Validation check for Password ------  */
    public boolean isPasswordCheck(String password) {
        // Regex to check valid password.
        String regex = "^(?=.*[0-9])"
                + "(?=.*[a-z])(?=.*[A-Z])"
                + "(?=\\S+$).{5,20}$";

        // Compile the ReGex
        Pattern p = Pattern.compile(regex);

        // If the password is empty return false
        if (password == null) {
            return false;
        }

        // Pattern class contains matcher() method to find matching between given password and regular expression.
        Matcher m = p.matcher(password);

        // Return if the password
        // matched the ReGex
        return m.matches();
    }

    @Transactional
    public OnboardResponse saveDetails(StudentInfo studentInfo) {
        boolean isPass = isPasswordCheck(studentInfo.getPassword());

        if (isPass) {
            save(studentInfo);
            Integer id = getId(studentInfo);
            return OnboardResponse.buildResp(id, "SUCCESS");
        }

        else {
        //   return "{\"success\":false,\"id\":-1}";
          return OnboardResponse.buildResp(-1,"FAILED");

        }
    }



   @Transactional
    public LoginResponse isLogin(Integer id, String password)
   {
       String isCheck = studentInfoDao.getPassword(id);
       if(isCheck.equals(password)){
           return LoginResponse.buildRes("Login Successful","Success");
       }
       else{
           return LoginResponse.buildRes("Invalid Student Id / Password","Login Failed");
       }
   }


   @Transactional
    public CourseViewResponse coursesViewAfterLogin(Integer id,String password)
   {
       String isCheck = studentInfoDao.getPassword(id);
       List<CourseDetail>list=new ArrayList<>();

       if(isCheck.equals(password)){
           list = courseDetailDao.getAllCourses();
           return new CourseViewResponse(true,"success",list);
       }

       else{
           return new CourseViewResponse(false,"failed",list);
       }
   }


   public CourseRegisteredResponse saveCoursesOfEachStudent(GetEachStudentCourseCred getStudentCourseCred)
   {
       Integer Student_Id = getStudentCourseCred.getStudentId();
       Integer[] Course_Id = getStudentCourseCred.getCourseId();
       Date date = getStudentCourseCred.getDateOfRegistration();
       Integer Validity_in_Days = getStudentCourseCred.getValidityInDays();

       List<String>courses=new ArrayList<>();

       for(int i=0;i<Course_Id.length;i++) {
           Integer currentCourseId = Course_Id[i];
           String course = courseDetailDao.getCourse(currentCourseId);
           studentCourseInfoDao.save(new StudentCourseInfo(Student_Id, currentCourseId, date, Validity_in_Days));
           courses.add(course);
       }
           return new CourseRegisteredResponse("Courses Saved","success",courses);


          // return new CourseRegisteredResponse("Courses Not Saved","Failed",courses);
   }

/*
    public CourseListResponse CoursesListDetails(GetStudentCred getStudentCred)
    {
        Integer id = getStudentCred.getId();
        String password = getStudentCred.getPassword();
        String passwordCheck = studentInfoDao.getPassword(id);

        if(password.equals(passwordCheck))
        {
            return new CourseListResponse(
        }
    }*/

}
