package com.example.final_assignments.controller;

import com.example.final_assignments.entity.*;
import com.example.final_assignments.mapper.AdminMapper;
import com.example.final_assignments.mapper.Super_AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@ResponseBody
public class AdminController {

    @Autowired
    private AdminMapper adminmapper;
    //登陆
    @PostMapping("/loginadmin")
    public String login(@RequestBody Admin admin){
        String username=admin.getUsername();
        String password=admin.getPassword();
        String testpassword;
        testpassword=adminmapper.findadminpassword(username);
        if(testpassword==null)
            return "用户不存在";
        if(testpassword.equals(password)){
            return "true";
        }
        else {
            return "密码错误";
        }
    }
    //查找住客
    @PostMapping("/findguest")
    public List<Guest> findguest(){
        List<Guest> list=adminmapper.findguests();
        System.out.println(list);
        return list;
    }
    //查看历史住客
    @PostMapping("/findhistroy")
    public List<Guest> findhistroyguest(){
        List<Guest> list=adminmapper.findhistroy();
        System.out.println(list);
        return list;
    }
    //查找所有building
    @PostMapping("/findallbuilding")
    public List<Building> findbuilding(){
        List<Building> list=adminmapper.findallbuilding();
        System.out.println(list);
        return list;
    }

    //更新水电费
    @PostMapping("/updateprice")
    public String updateprice(@RequestBody Updateprice updateprice){
        String pricetype=updateprice.getPricetype();
        double newprice=updateprice.getNewprice();
        adminmapper.updateprice(pricetype,newprice);
        return "更改成功";
    }
    //更改户型
    @PostMapping("/updatebuildingtype")
    public String updatebuildingtype(@RequestBody Updatebuildingtype updatebuildingtype){
        String address=updatebuildingtype.getAddress();
        String newtype=updatebuildingtype.getNewtype();
        adminmapper.updatebuildingtype(address,newtype);
        return "更改户型成功";
    }
    //添加住客
    @PostMapping("/insertguest")
    public String insertguest(Guest guest){
        adminmapper.insertguest(guest);
        return "添加住客成功";
    }
    //更新设置当前的房租、当前的水电数和单价、入住日期
    //未完成
    @PostMapping("/updatebuildingprice")
    public void updatebuilding(Building building){
        adminmapper.updatebuilding(building);
    }

    //结算费用并退房
    @PostMapping("/checkout")
    public double checkout_quit(CheckoutGuest checkoutguest){
        String id=checkoutguest.getId();
        Building building=adminmapper.findbuilding(id);
        double cost=building.Total_cost(checkoutguest.getCurrentwaternumber(),checkoutguest.getCurrentElectricitynumber(),
                checkoutguest.getDay());
        Guest guest=adminmapper.findone(id);
        guest.setDay(checkoutguest.getDay());
        adminmapper.delectguest(id);
        adminmapper.delecthistroy(id);
        adminmapper.inserthistroy(guest);
        return cost;
    }

    //只结算费用不退房
    @PostMapping("/checkfee")
    public double checkout_fees(CheckoutGuest checkoutguest){
        String id=checkoutguest.getId();
        Building building=adminmapper.findbuilding(id);
        double cost=building.Total_cost(checkoutguest.getCurrentwaternumber(),checkoutguest.getCurrentElectricitynumber(),
                checkoutguest.getDay());
        Guest guest=adminmapper.findone(id);
        guest.setDay(checkoutguest.getDay());
        adminmapper.inserthistroy(guest);
        return cost;
    }
}
