package com.helper.controller;

import com.helper.dto.request.UserCred;
import com.helper.dto.response.AdminLoginResponse;
import com.helper.dto.response.AdminViewResponse;
import com.helper.service.ServiceClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@Controller
@EnableWebMvc
public class AdminController {

    @Autowired
    ServiceClass serviceClass;



    /*********************************   Admin Login   ***************************************/

    @RequestMapping(value = "admin/login",method = RequestMethod.POST)
    public @ResponseBody
  //  @RequestParam Integer id , @RequestParam String password
    AdminLoginResponse LoginAdmin(@RequestBody UserCred userCred) throws Exception
    {
        return serviceClass.AdminLogin(userCred);
    }




    /*************************** Admin view All StudentsInfo **********************************/

    @RequestMapping(value = "admin/viewAll",method = RequestMethod.POST)
    public @ResponseBody
    AdminViewResponse ViewAllStudentsInfo(@RequestBody UserCred userCred) throws Exception
    {
        return serviceClass.AdminViewAllCourses(userCred);
    }


}
