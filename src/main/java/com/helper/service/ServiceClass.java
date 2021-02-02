package com.helper.service;

import com.helper.dto.request.UserCred;
import com.helper.dto.response.ViewListResponse;
import com.helper.dao.*;
import com.helper.dto.request.StudentCourseCred;
import com.helper.dto.response.*;
import com.helper.entity.StudentCourseInfo;
import com.helper.entity.UserInfo;
import com.helper.entity.UserTokenDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
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
                + "(?=.*[@#$%^&+=]).{6,20}$";

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


    /* ------------------------ Md5 Encryption ----------------------------- */
    private String getMd5 (String input)
    {
        try {

            // Static getInstance method is called with hashing MD5
            MessageDigest md = MessageDigest.getInstance("MD5");

            // digest() method is called to calculate message digest
            //  of an input digest() return array of byte
            byte[] messageDigest = md.digest(input.getBytes());

            // Convert byte array into signum representation
            BigInteger no = new BigInteger(1, messageDigest);

            // Convert message digest into hex value
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        }

        // For specifying wrong message digest algorithms
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }



    /************************ Send Mail After student Registration **********************/

    void sendOnboardMailMessage(String email , String userName , Integer userId) {
        //create a mail sender
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        javaMailSender.setHost("smtp.gmail.com");
        javaMailSender.setPort(587);
        javaMailSender.setUsername("demo49202@gmail.com");
        javaMailSender.setPassword("Shivani@123");

        Properties properties = new Properties();
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.starttls.enable", "true");

        javaMailSender.setJavaMailProperties(properties);

        //create a email instance
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("university.portal@gmail.com");
        mailMessage.setTo(email);
        mailMessage.setSubject("IGDTUW: Account Successfully Created ");
        mailMessage.setText("Dear " + userName + ",\n\nWelcome in our University.\nYou have successfully registered on our portal !!\n\nYour Student Id is: " + userId + "\nYou can now login with this Student Id.\n\n\n\n Thanks and Regards");

        //send mail
        javaMailSender.send(mailMessage);


    }




    /***************************** Send Mail After Courses being registered ******************************/

    public void sendMailAfterCourseRegister(String email,String fullName,String courseString)
    {
        //create a mail sender
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        javaMailSender.setHost("smtp.gmail.com");
        javaMailSender.setPort(587);
        javaMailSender.setUsername("demo49202@gmail.com");
        javaMailSender.setPassword("Shivani@123");

        Properties properties = new Properties();
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.starttls.enable", "true");

        javaMailSender.setJavaMailProperties(properties);

        //create a email instance
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("university.portal@gmail.com");
        mailMessage.setTo(email);
        mailMessage.setSubject("IGDTUW: Course Registered Successfully");
        mailMessage.setText("Dear "+fullName+" ,\nYou have successfully registered the following courses.\n\n"+courseString+"" +
                "\n\n\n\nThanks and Regards");

        //send mail
        javaMailSender.send(mailMessage);

    }


    // return valid upto based on user token
    public LocalDateTime validUptoBasedOnUserToken(String userToken)
    {
        return userTokenDetailsDao.getValidUpto(userToken);
    }




    public void save(UserInfo userInfo) {
        try {

            userInfoDao.saveUserDetails(userInfo);
        }
        catch (Exception e){
            System.out.println(e);
        }
    }


    public void saveTokenDetails(UserTokenDetails userTokenDetails) {
        try {

            userTokenDetailsDao.save(userTokenDetails);
        }
        catch (Exception e){
            System.out.println("Something w");
        }
    }


    public OnboardResponse saveDetails(UserInfo userInfo) throws Exception{

        boolean isValidPassword = isValidPassword(userInfo.getPassword());
        boolean isValidEmail = isValidEmail(userInfo.getEmail());


        if(isValidEmail && isValidPassword) {
            try {

                boolean emailExist = userInfoDao.emailExistOrNot(userInfo.getEmail());

                // if any student is already registered with that email
                if (emailExist) {

                    String encryptedPassword = getMd5(userInfo.getPassword());
                    //saving encrypted password
                    userInfo.setPassword(encryptedPassword);

                    //saving that student info
                    save(userInfo);

                    //mail sender
                    sendOnboardMailMessage(userInfo.getEmail(),userInfo.getFirstName(),userInfo.getUserId());


                return OnboardResponse.buildResp(userInfo.getUserId(), "Successfully Registered", "SUCCESS");

                }

                else {
                    return OnboardResponse.buildResp(-1, "Email already exist", "FAILED");
                }
            } catch (Exception e) {
                throw e;
            }
        }

        // if email or password is invalid
        else{
            return OnboardResponse.buildResp(-1,"Email / Password is Invalid","FAILED");
        }
    }


    public LoginResponse isLogin(UserCred userCred) throws Exception
   {
        try {

           Integer id = userCred.getId();
           String password = userCred.getPassword();


           String isCheck = userInfoDao.getPassword(id);
           int userType = userInfoDao.getUserType(id);
           String encryptedPassword = getMd5(password);

           // if password matches
           if (isCheck.equals(encryptedPassword) && userType==0) {


               LocalDateTime createdAt = LocalDateTime.now();

               //valid upto 10 min from being created
               LocalDateTime validUpto = createdAt.plusMinutes(10);

               //unique user token(id)
               String createdAtString = createdAt.toString();
               String partialToken = createdAtString.replaceAll("[-:.]","");

               String userToken = partialToken + String.valueOf(id);

               UserTokenDetails userTokenDetails = new UserTokenDetails(userToken,id,createdAt,validUpto);

               //saving user token details
               saveTokenDetails(userTokenDetails);

               return LoginResponse.buildRes("Login Successful",userTokenDetails.getUserToken() ,"Success");
           }

           else {
               return LoginResponse.buildRes("Invalid Student Id / Password",null, "Login Failed");
           }
       }
       catch (Exception e){
         throw e;
       }
   }



    public CourseViewResponse coursesViewAfterLogin() throws Exception
   {
       try {

           List<Object> list = new ArrayList<>();
           List<StudentCourseDetail>courseDetails = new ArrayList<>();

               //get all the courses from the database dao
               list = courseDetailDao.getAllCourses();

               for(int i=0;i<list.size();i++){

                   Integer courseId = (Integer) ((Object[])(list.get(i)))[0];
                   String courseName = (String) ((Object[])(list.get(i)))[1];
                   StudentCourseDetail studentCourseDetail = new StudentCourseDetail(courseId,courseName);

                   //saving each courseName with CourseId
                   courseDetails.add(studentCourseDetail);
               }

               return new CourseViewResponse("success", true, courseDetails);
           }
       catch (Exception e){
           throw e;
       }
   }


   public CourseRegisterResponse saveCoursesOfEachStudent(StudentCourseCred getStudentCourseCred) {

        try {

            Integer studentId = getStudentCourseCred.getStudentId();

            // check whether courses are already registered with given studentId
            boolean isIdExist = studentCourseInfoDao.isIdAlreadyExist(studentId);


            List<String> courses = new ArrayList<>();

            if(isIdExist) {
                return new CourseRegisterResponse("Courses are already registered", "Failed", courses);
            }

            else {

                //getting all the values from the request ( id taken)
                Integer[] courseId = getStudentCourseCred.getCourseId();
                Date date = getStudentCourseCred.getDateOfRegistration();
                Integer validityInDays = getStudentCourseCred.getValidityInDays();
                String courseString="";

                for (int i = 0; i < courseId.length; i++) {

                    Integer currentCourseId = courseId[i];

                    //course name corresponding to that courseId
                    String courseName = courseDetailDao.getCourse(currentCourseId);

                    //saving into database
                    studentCourseInfoDao.save(new StudentCourseInfo(studentId, currentCourseId, date, validityInDays,LocalDateTime.now()));

                    String n = String.valueOf(i+1);
                    courseString =  courseString  + n + ".   " + courseName + " \n";

                    //for response purpose
                    courses.add(courseName);
                }


                //for sending mail
                String email = userInfoDao.getUserEmail(getStudentCourseCred.getStudentId());
                String fullName = userInfoDao.name(getStudentCourseCred.getStudentId());

                //mail sender
                sendMailAfterCourseRegister(email,fullName,courseString);
                System.out.println("Mail Sent!!");

                return new CourseRegisterResponse("Courses Saved", "success", courses);
            }

        }
        catch (Exception e) {
            throw e;
       }
   }


  // @Cacheable(key="#userCred",value = "courseListDetails")
    public ViewListResponse CourseListDetails(UserCred userCred) throws Exception
    {
        try {
            Integer id = userCred.getId();
            String password = userCred.getPassword();
            String encryptedPassword = getMd5(password);

            String passwordCheck = userInfoDao.getPassword(id);

            List<Object> listOfStudentCourseInfo = new ArrayList<>();
            List<StudentRegisteredCourseDetail> studentRegisteredCourseDetail = new ArrayList<>();

            //password check
            if (encryptedPassword.equals(passwordCheck)) {

                //all entries from the db
                listOfStudentCourseInfo = studentCourseInfoDao.getStudentIdNameDate(id);


                if(listOfStudentCourseInfo.size()==0)
                    return new ViewListResponse("Not registered any Course","failed", studentRegisteredCourseDetail);


                 for(int i=0;i<listOfStudentCourseInfo.size();i++)
                 {
                     //order will be same as mentioned in query.
                     Integer courseId=(Integer)((Object[]) listOfStudentCourseInfo.get(i))[0];

                     Date date = (Date) ((Object[]) listOfStudentCourseInfo.get(i))[1];

                     String dateFinal = date.toString();

                     //LocalDateTime dateFinal =  timeStamp.toLocalDateTime().toLocalDate();
                     String courseName = (String)((Object[]) listOfStudentCourseInfo.get(i))[2];

                    StudentRegisteredCourseDetail currentStudentRegisteredCourseDetail =  new StudentRegisteredCourseDetail(courseId,dateFinal,courseName);


                    //add each courseList(id,date,courseName) into list
                    studentRegisteredCourseDetail.add(currentStudentRegisteredCourseDetail);

                }


                return new ViewListResponse("Data Extracted","success", studentRegisteredCourseDetail);

            } else {
                return new ViewListResponse("Invalid Id / Password","failed", studentRegisteredCourseDetail);
            }
        }
        catch (Exception e){
            throw e;
        }

    }


    public AdminLoginResponse AdminLogin(UserCred userCred) throws Exception{

        try {

           Integer id = userCred.getId();
           String password = userCred.getPassword();

           String isCheckPassword = userInfoDao.getPassword(id);//exception may occur
           String encryptPassword = getMd5(password);

            Integer userType = userInfoDao.getUserType(id);

            if(isCheckPassword.equals(encryptPassword) && userType==1){
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


    public AdminViewResponse AdminViewAllCourses(UserCred userCred) throws Exception
    {

        Integer id = userCred.getId();
        String password = userCred.getPassword();

        String isCheckPassword = userInfoDao.getPassword(id);
        String encryptPassword = getMd5(password);

        List<AdminView> allStudentDetails = new ArrayList<>();
        Integer userType = userInfoDao.getUserType(id);


        if(isCheckPassword.equals(encryptPassword) && userType==1) {


            List<Object> adminView = studentCourseInfoDao.adminViewAllStudentInfo();

            try {

                for (int i = 0; i < adminView.size(); i++) {

                    Integer studentId = (Integer) ((Object[]) adminView.get(i))[0];
                    Integer courseId = (Integer) ((Object[]) adminView.get(i))[1];
                    String courseName = (String) ((Object[]) adminView.get(i))[2];

                    AdminView currentAdminView = new AdminView(studentId, courseId, courseName);

                    //add all the details of each student (response)
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
