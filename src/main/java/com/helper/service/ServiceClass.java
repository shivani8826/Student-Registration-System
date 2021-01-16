package com.helper.service;

import com.helper.dto.response.ViewListResponse;
import com.helper.dao.*;

import com.helper.dto.request.StudentCourseCred;
import com.helper.dto.request.StudentCred;
import com.helper.dto.response.*;
import com.helper.entity.StudentCourseInfo;
import com.helper.entity.UserInfo;
import com.helper.entity.UserTokenDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ServiceClass {

    @Autowired
    private UserInfoDao userInfoDao;

    @Autowired
    private CourseDetailDao courseDetailDao;

    @Autowired
    private StudentCourseInfoDao studentCourseInfoDao;

    @Autowired
    private UserTokenDetailsDao userTokenDetailsDao;

    /*      --------------   Password Validation Check  ------------------------ */
    public boolean isValidPassword(String password)
    {

        // Regex to check valid password.
        String regex = "^(?=.*[0-9])"
                + "(?=.*[a-z])(?=.*[A-Z])"
                + "(?=.*[@#$%^&+=])"
                + "(?=\\S+$).{6,20}$";

        // Compile the ReGex
        Pattern p = Pattern.compile(regex);

        // If the password is empty return false
        if (password == null) {
            return false;
        }

        Matcher m = p.matcher(password);
        return m.matches();
    }


    /*      -------------- Email Validation Check  ------------------------ */
    public boolean isValidEmail(String email)
    {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }



    public void save(UserInfo userInfo) {
        try {
            userInfoDao.save(userInfo);
        }
        catch (Exception e){
            System.out.println(e);
        }
    }


    public OnboardResponse saveDetails(UserInfo userInfo) throws Exception{


        boolean isValidPassword = isValidPassword(userInfo.getPassword());
        boolean isValidEmail = isValidEmail(userInfo.getEmail());

        if(isValidEmail && isValidPassword) {
            try {
                boolean idExist = userInfoDao.emailExistOrNot(userInfo.getEmail());

                if (idExist) {
                    save(userInfo);
                    return OnboardResponse.buildResp(userInfo.getUserId(), "Successfully Registered", "SUCCESS");
                } else {
                    return OnboardResponse.buildResp(-1, "Email already exist", "FAILED");
                }
            } catch (Exception e) {
                throw e;
            }
        }

        else{
            return OnboardResponse.buildResp(-1,"Email / Password is Invalid","FAILED");
        }
    }


    public LoginResponse isLogin(Integer id, String password ) throws Exception
   {
        try {

           String isCheck = userInfoDao.getPassword(id);
           int userType = userInfoDao.getUserType(id);

           if (isCheck.equals(password) && userType==0) {

               LocalDateTime createdAt = LocalDateTime.now();
               LocalDateTime validUpto = createdAt.plusMinutes(10);
               String userToken = createdAt + String.valueOf(id);

               userTokenDetailsDao.save(new UserTokenDetails(userToken,id,createdAt,validUpto));


               return LoginResponse.buildRes("Login Successful",userToken ,"Success");
           } else {
               return LoginResponse.buildRes("Invalid Student Id / Password",null, "Login Failed");
           }
       }
       catch (Exception e){
         throw e;
       }
   }


    public CourseViewResponse coursesViewAfterLogin(StudentCred studentCred) throws Exception
   {
       try {
           Integer id = studentCred.getId();
           String password = studentCred.getPassword();
           String isCheck = userInfoDao.getPassword(id);
           List<Object> list = new ArrayList<>();
           List<CourseNameId>courseDetails = new ArrayList<>();

           if (isCheck.equals(password)) {
               list = courseDetailDao.getAllCourses();
               for(int i=0;i<list.size();i++){
                   Integer courseId = (Integer) ((Object[])(list.get(i)))[0];
                   String courseName = (String) ((Object[])(list.get(i)))[1];
                   CourseNameId courseNameId = new CourseNameId(courseId,courseName);

                   courseDetails.add(courseNameId);
               }

               return new CourseViewResponse("success", true, courseDetails);
           } else {
               return new CourseViewResponse("failed", false, courseDetails);
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


    public ViewListResponse CourseListDetails(StudentCred studentCred) throws Exception
    {
        try {
            Integer id = studentCred.getId();
            String password = studentCred.getPassword();
            String passwordCheck = userInfoDao.getPassword(id);
            List<Object> listOfStudentCourseInfo = new ArrayList<>();
            List<CourseList>allCourseList = new ArrayList<>();

            if (password.equals(passwordCheck)) {

                listOfStudentCourseInfo = studentCourseInfoDao.getStudentIdNameDate(id);

                 for(int i=0;i<listOfStudentCourseInfo.size();i++)
                 {
                     Integer courseId=(Integer)((Object[]) listOfStudentCourseInfo.get(i))[0];
                     Date date = (Date) ((Object[]) listOfStudentCourseInfo.get(i))[1];
                     String courseName = (String)((Object[]) listOfStudentCourseInfo.get(i))[2];

                    CourseList currentCourseList =  new CourseList(courseId,date,courseName);
                    allCourseList.add(currentCourseList);

                }
                return new ViewListResponse("Data Extracted","success", allCourseList);

            } else {
                return new ViewListResponse("Not registered any Course","failed", allCourseList);
            }
        }
        catch (Exception e){
            throw e;
        }

    }


    public AdminLoginResponse AdminLogin(Integer id,String password) throws Exception{

        try {
           String isCheckPassword = userInfoDao.getPassword(id);//exception may occur

            Integer userType = userInfoDao.getUserType(id);

            if(isCheckPassword.equals(password) && userType==1){
                return new AdminLoginResponse("Admin Login Successful","success");
            }
            else{
                return new AdminLoginResponse("Invalid credentials","failed");
            }
        }
        catch (Exception e){
            throw e;
        }
    }


    public AdminViewResponse AdminViewAllCourses(Integer id,String password, boolean userType) throws Exception
    {

        String isCheckPassword = userInfoDao.getPassword(id);
        List<AdminView> allStudentDetails = new ArrayList<>();

        if(isCheckPassword.equals(password) && userType) {
            List<Object> adminView = studentCourseInfoDao.adminViewAllStudentInfo();

            try {

                for (int i = 0; i < adminView.size(); i++) {
                    Integer studentId = (Integer) ((Object[]) adminView.get(i))[0];
                    Integer courseId = (Integer) ((Object[]) adminView.get(i))[1];
                    String courseName = (String) ((Object[]) adminView.get(i))[2];

                    AdminView currentAdminView = new AdminView(studentId, courseId, courseName);
                    allStudentDetails.add(currentAdminView);
                }

                return new AdminViewResponse("Student Details Extracted","true", allStudentDetails);
            } catch (Exception e) {
                throw e;
            }
        }

        else{
            return new AdminViewResponse("Invalid Input Credentials","false",allStudentDetails);
        }
    }


}
