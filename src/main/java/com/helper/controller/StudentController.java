package com.helper.controller;

import com.helper.dto.request.OnboardUserCred;
import com.helper.dto.request.UserCred;
import com.helper.dto.response.ViewListResponse;
import com.helper.dto.request.StudentCourseCred;
import com.helper.dto.response.*;
import com.helper.entity.UserInfo;
import com.helper.service.ServiceClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@EnableWebMvc
@Controller
public class StudentController {

    @Autowired
    private ServiceClass serviceClass;


    /****************************************** User Onboard *****************************************/

    @RequestMapping(value = "/user/onboard", method = RequestMethod.POST)
    @ResponseBody
    public OnboardResponse OnboardUser(@RequestBody OnboardUserCred onboardUserCred) throws Exception{

        String email = onboardUserCred.getEmail();
        String firstName = onboardUserCred.getFirstName();
        String lastName = onboardUserCred.getLastName();
        String password = onboardUserCred.getPassword();

        return serviceClass.saveDetails(new UserInfo(email, firstName, lastName, password,0,LocalDateTime.now(),LocalDateTime.now()));
    }




    /*************************************** User Login *********************************************/


    @RequestMapping(value = "/user/login", method = RequestMethod.POST) //by default choose get
    @ResponseBody
    public LoginResponse loginUser(@RequestBody UserCred userCred) throws Exception {
        return serviceClass.isLogin(userCred);
    }





    /********************************** User View All course List  ************************************/

    @RequestMapping(value = "/courses/view", method = RequestMethod.GET)
    public @ResponseBody
    CourseViewResponse viewCourses(@RequestHeader(value = "userToken") String userToken) throws Exception {


        // get validUpto using user token
        LocalDateTime validUpto = serviceClass.validUptoBasedOnUserToken(userToken);

        LocalDateTime currentDateTime = LocalDateTime.now();

        //if validUpto is less than currentDate Time
        if (validUpto.isAfter(currentDateTime)) {
            return serviceClass.coursesViewAfterLogin();
        }

        else {
            List<StudentCourseDetail> data = new ArrayList<>();
            return new CourseViewResponse("User Token expired! Login again", false, data);
        }

    }




    /********************************** User Course Register  *****************************************/


    @RequestMapping(value = "user/course/register",method = RequestMethod.POST)
    public @ResponseBody
    CourseRegisterResponse CoursesForRegistration(@RequestBody StudentCourseCred studentCourseCred) {
        return serviceClass.saveCoursesOfEachStudent(studentCourseCred);
    }


    /********************************* User All Registered Courses List ********************************/

    @RequestMapping(value = "user/course/list",method = RequestMethod.POST)
    public @ResponseBody
    ViewListResponse CoursesListDetails(@RequestBody UserCred userCred) throws Exception
    {
         return serviceClass.CourseListDetails(userCred);
    }


}



