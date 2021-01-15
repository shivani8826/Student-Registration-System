package com.helper.controller;

import com.helper.dto.request.AdminCred;
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

@EnableWebMvc
@Controller
public class StudentController {

    @Autowired
    private ServiceClass serviceClass;


    @RequestMapping(value = "/user/onboard", method = RequestMethod.POST)
    @ResponseBody
    public OnboardResponse OnboardUser(@RequestParam() String email, @RequestParam() String first, @RequestParam() String last,
                                       @RequestParam() String password) throws Exception{
        return serviceClass.saveDetails(new UserInfo(email, first, last, password));
    }


    @RequestMapping(value = "/user/login", method = RequestMethod.POST) //by default choose get
    @ResponseBody
    public LoginResponse loginUser(@RequestParam() int id, @RequestParam() String password) throws Exception {
        return serviceClass.isLogin(id, password);
    }


    @RequestMapping(value = "/courses/view", method = RequestMethod.POST)
    public @ResponseBody
    CourseViewResponse viewCourses(@RequestBody StudentCred studentCred) throws Exception {
        return serviceClass.coursesViewAfterLogin(studentCred);
    }


    @RequestMapping(value = "user/course/register",method = RequestMethod.POST)
    public @ResponseBody
    CourseRegisteredResponse CoursesForRegistration(@RequestBody StudentCourseCred studentCourseCred) {
        return serviceClass.saveCoursesOfEachStudent(studentCourseCred);
    }


    @RequestMapping(value = "user/course/list",method = RequestMethod.POST)
    public @ResponseBody
    ViewListResponse CoursesListDetails(@RequestBody StudentCred studentCred) throws Exception
    {
         return serviceClass.CourseListDetails(studentCred);
    }






}

