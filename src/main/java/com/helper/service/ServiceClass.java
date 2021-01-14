package com.helper.service;

import com.helper.dto.response.ViewListResponse;
import com.helper.dao.*;

import com.helper.dto.request.StudentCourseCred;
import com.helper.dto.request.StudentCred;
import com.helper.dto.response.*;
import com.helper.entity.CourseDetail;
import com.helper.entity.StudentCourseInfo;
import com.helper.entity.StudentInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
        try {
            studentInfoDao.save(studentInfo);
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    @Transactional
    public OnboardResponse saveDetails(StudentInfo studentInfo) throws Exception{

        try {

            boolean idExist = studentInfoDao.emailExistOrNot(studentInfo.getEmail());

            if (idExist) {
                save(studentInfo);
                return OnboardResponse.buildResp(studentInfo.getStudentID(), "Successfully Registered", "SUCCESS");
            } else {
                return OnboardResponse.buildResp(-1, "Email already exist", "FAILED");
            }
        }
        catch (Exception e){
            throw e;
        }
    }



   @Transactional
    public LoginResponse isLogin(Integer id, String password ) throws Exception
   {
       try {
           String isCheck = studentInfoDao.getPassword(id);
           if (isCheck.equals(password)) {
               return LoginResponse.buildRes("Login Successful", "Success");
           } else {
               return LoginResponse.buildRes("Invalid Student Id / Password", "Login Failed");
           }
       }
       catch (Exception e){
         throw e;
       }
   }


   @Transactional
    public CourseViewResponse coursesViewAfterLogin(Integer id, String password) throws Exception
   {
       try {
           String isCheck = studentInfoDao.getPassword(id);
           List<CourseDetail> list = new ArrayList<>();

           if (isCheck.equals(password)) {
               list = courseDetailDao.getAllCourses();
               return new CourseViewResponse(true, "success", list);
           } else {
               return new CourseViewResponse(false, "failed", list);
           }
       }
       catch (Exception e){
           throw e;
       }
   }


   public CourseRegisteredResponse saveCoursesOfEachStudent(StudentCourseCred getStudentCourseCred) {

        try {

            Integer studentId = getStudentCourseCred.getStudentId();

            boolean isIdExist = studentCourseInfoDao.isIdAlreadyExist(studentId);
            List<String> courses = new ArrayList<>();

            if(isIdExist) {
                return new CourseRegisteredResponse("Courses already registered", "Failed", courses);
            }

            else {
                Integer[] courseId = getStudentCourseCred.getCourseId();
                Date date = getStudentCourseCred.getDateOfRegistration();
                Integer validityInDays = getStudentCourseCred.getValidityInDays();


                for (int i = 0; i < courseId.length; i++) {
                    Integer currentCourseId = courseId[i];
                    String course = courseDetailDao.getCourse(currentCourseId);

                    studentCourseInfoDao.save(new StudentCourseInfo(studentId, currentCourseId, date, validityInDays));

                    courses.add(course);
                }
                return new CourseRegisteredResponse("Courses Saved", "success", courses);
            }

        }
        catch (Exception e) {
            throw e;
       }
   }


    public ViewListResponse CoursesListDetails(StudentCred studentCred) throws Exception
    {
        try {
            Integer id = studentCred.getId();
            String password = studentCred.getPassword();
            String passwordCheck = studentInfoDao.getPassword(id);
            List<CourseList> listOfStudentCourseInfo = new ArrayList<>();

            if (password.equals(passwordCheck)) {

                listOfStudentCourseInfo = studentCourseInfoDao.getStudentIdNameDate(id);
                return new ViewListResponse("Data Extracted","success", listOfStudentCourseInfo);

            } else {
                return new ViewListResponse("Not registered any Course","failed", listOfStudentCourseInfo);
            }
        }
        catch (Exception e){
            throw e;
        }

    }

}
