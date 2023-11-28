package com.example.final_assignments.controller;

import com.example.final_assignments.entity.Admin;
import com.example.final_assignments.entity.Super_Admin;
import com.example.final_assignments.entity.Updateadmin;
import com.example.final_assignments.mapper.AdminMapper;
import com.example.final_assignments.mapper.Super_AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@ResponseBody
public class Super_AdminController {
    @Autowired
    private Super_AdminMapper supermapper;
    @Autowired
    private AdminMapper adminmapper;
    //登陆
    @PostMapping("/loginsuper")
    public String login(@RequestBody Super_Admin super_admin){
        String username=super_admin.getUsername();
        String password=super_admin.getPassword();
        String testpassword;
        testpassword=supermapper.findsuperpassword(username);
        if(testpassword==null)
            return "用户不存在";
        if(testpassword.equals(password)){
            return "true";
        }
        else {
            return "密码错误";
        }
    }

    //插入admin
    @PostMapping("/insertadmin")
    public String insertadmin(@RequestBody Admin admin){
        String username=admin.getUsername();
        String password=admin.getPassword();
        int usernameExists = supermapper.findone(username);
        if(usernameExists==0) {
            supermapper.insertadmin(username, password);
            return "插入成功";
        }
        else{
            return "用户已存在插入失败";
        }
    }

    //更新admin信息
    @PostMapping("/updateadmin")
    public String updateadmin(@RequestBody Updateadmin updateadmin){
        String attribute=updateadmin.getAttribute();
        String newval=updateadmin.getNewval();
        String username=updateadmin.getUsername();
        int usernameExists = supermapper.findone(username);
        if(usernameExists!=0){
            supermapper.update(attribute,newval,username);
            return "更改成功将"+username+"的"+attribute+"更改为"+newval;}
        else{
            return "更改失败,用户名为"+username+"的管理员不存在";
        }
    }

    //查找所有的admin
    @PostMapping("/findadmin")
    public List<Admin> findadmin(){
        List<Admin> list=supermapper.findadmins();
        System.out.println(list);
        return list;
    }

}
