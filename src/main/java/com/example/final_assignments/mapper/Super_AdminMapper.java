package com.example.final_assignments.mapper;


import com.example.final_assignments.entity.Admin;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface Super_AdminMapper {

    @Select("select password from superadmin where username=#{username}")
    public String findsuperpassword(String username);

    @Insert("insert into admins(username,password) values(#{username},#{password})")
    public void insertadmin(String username,String password);

    @Update("UPDATE admins SET ${attribute} = #{newval} where username=#{username}")
    public void update(String attribute,  String newval, String username);

    @Select("select * from admins")
    public List<Admin>  findadmins();

    @Select("select count(*) from admins where username=#{username}")
    public int findone(String username);

}
