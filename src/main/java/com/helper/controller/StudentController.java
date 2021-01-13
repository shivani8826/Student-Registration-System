package com.helper.controller;

import ResponseEntity.*;
import com.helper.dao.StudentInfo;
import com.helper.service.ServiceClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

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
                                       @RequestParam() String password) {
        return serviceClass.saveDetails(new StudentInfo(email, first, last, password));
    }


    @RequestMapping(value = "/user/login", method = RequestMethod.POST) //by default choose get
    @ResponseBody
    public LoginResponse loginUser(@RequestParam() int id, @RequestParam() String password) {
        return serviceClass.isLogin(id, password);
    }


    @RequestMapping(value = "/courses/view", method = RequestMethod.POST)
    public @ResponseBody
    CourseViewResponse viewCourses(@RequestBody GetStudentCred getParameter) {
        Integer id = getParameter.getId();
        String password = getParameter.getPassword();
        return serviceClass.coursesViewAfterLogin(id, password);
    }


    @RequestMapping(value = "user/course/register",method = RequestMethod.POST)
    public @ResponseBody
    CourseRegisteredResponse CoursesForRegistration(@RequestBody GetEachStudentCourseCred getEachStudentCourseCred) {
        //return null;
        return serviceClass.saveCoursesOfEachStudent(getEachStudentCourseCred);
    }


   /* @RequestMapping(value = "user/course/list",method = RequestMethod.POST)
    public @ResponseBody
    CourseListResponse CoursesListDetails(@RequestBody GetStudentCred getStudentCred)
    {
        Integer id = getStudentCred.getId();
        String password = getStudentCred.getPassword();

        String passwordCheck =
    }*/



}







    /*@RequestMapping("/user/options")
    public String UserOptions(){
        return "courseOptions";
   }


    @RequestMapping("user/course/register")
    public ModelAndView registerCourses(@RequestParam List<String> courseList)
    {
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("result.jsp");
        modelAndView.addObject("ans",courseList);

        return modelAndView;
    }


    @RequestMapping( "/user/registered")
    public ModelAndView viewRegisteredCourses(@RequestParam List<String>list)
    {
        ModelAndView m = new ModelAndView("coursesRegistered");
        m.addObject("list",list);
        return m;
    }
*/
//ModelAndView mav = new ModelAndView("jspfilekaname");