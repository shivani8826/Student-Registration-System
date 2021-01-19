package com.helper.controller;

import com.helper.MailSender.EmailConfigure;
import com.helper.dto.response.ViewListResponse;
import com.helper.dto.request.StudentCourseCred;
import com.helper.dto.request.StudentCred;
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


    @RequestMapping(value = "/user/onboard", method = RequestMethod.POST)
    @ResponseBody
    public OnboardResponse OnboardUser(@RequestParam() String email, @RequestParam() String first, @RequestParam() String last,
                                       @RequestParam() String password) throws Exception{
        return serviceClass.saveDetails(new UserInfo(email, first, last, password,0));
    }




    @RequestMapping(value = "/user/login", method = RequestMethod.POST) //by default choose get
    @ResponseBody
    public LoginResponse loginUser(@RequestParam() int id, @RequestParam() String password) throws Exception {
        return serviceClass.isLogin(id, password);
    }





    @RequestMapping(value = "/courses/view", method = RequestMethod.POST)
    public @ResponseBody
    CourseViewResponse viewCourses(@RequestHeader(value = "validUpto") String validUptoStr, @RequestBody StudentCred studentCred) throws Exception {

        LocalDateTime validUpto = LocalDateTime.parse(validUptoStr);

        LocalDateTime currentDateTime = LocalDateTime.now();

        if (validUpto.isAfter(currentDateTime)) {
            return serviceClass.coursesViewAfterLogin(studentCred);
        } else {
            List<CourseNameId> data = new ArrayList<>();
            return new CourseViewResponse("User Token expired! Login again", false, data);
        }

    }



    @RequestMapping(value = "user/course/register",method = RequestMethod.POST)
    public @ResponseBody
    CourseRegisterResponse CoursesForRegistration(@RequestBody StudentCourseCred studentCourseCred) {
        return serviceClass.saveCoursesOfEachStudent(studentCourseCred);
    }




    @RequestMapping(value = "user/course/list",method = RequestMethod.POST)
    public @ResponseBody
    ViewListResponse CoursesListDetails(@RequestBody StudentCred studentCred) throws Exception
    {
         return serviceClass.CourseListDetails(studentCred);
    }






}

