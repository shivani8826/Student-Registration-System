package com.helper.controller;

import com.helper.dto.request.AdminCred;
import com.helper.dto.response.AdminLoginResponse;
import com.helper.dto.response.AdminViewResponse;
import com.helper.dto.response.LoginResponse;
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

    @RequestMapping(value = "admin/login",method = RequestMethod.POST)
    public @ResponseBody
    AdminLoginResponse LoginAdmin(@RequestParam Integer id , @RequestParam String password) throws Exception
    {
        return serviceClass.AdminLogin(id,password);
    }



    @RequestMapping(value = "admin/viewAll",method = RequestMethod.POST)
    public @ResponseBody
    AdminViewResponse ViewAllStudentsInfo(@RequestParam Integer id , @RequestParam String password ) throws Exception
    {
        return serviceClass.AdminViewAllCourses(id,password);
    }


}
