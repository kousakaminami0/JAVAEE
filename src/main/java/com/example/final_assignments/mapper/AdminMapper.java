package com.example.final_assignments.mapper;

import com.example.final_assignments.entity.Admin;
import com.example.final_assignments.entity.Building;
import com.example.final_assignments.entity.Guest;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AdminMapper {

    @Select("select * from guests")
    public List<Guest> findguests();

    @Select("select * from histroyguest")
    public List<Guest> findhistroy();

    @Select("select * from building")
    public List<Building> findallbuilding();

    @Select("select password from admins where username=#{username}")
    public String findadminpassword(String username);

    @Select("SELECT * FROM guest where id=#{id}")
    public Guest findone(String id);

    @Select("Select * from building where uid=#{id}")
    public Building findbuilding(String id);

    @Update("UPDATE building SET ${pricetype}=newprice")
    public void updateprice(String pricetype,double newprice);

    @Update("UPDATE building SET buildingtype=#{newtype} where address=#{newtype}")
    public void updatebuildingtype(String address,String newtype);

    @Insert("INSERT INTO guests(id, name, phone,sex,address,day,buildingnmum) " +
            "VALUES (#{id}, #{name}, #{phone},#{sex},#{address},#{day},#{buildingnmum})")
    public void insertguest(Guest guest);

    @Select("select password from  where username=#{username}")
    public String findpassword(String username);

    @Update("UPDATE building SET rent=#{rent},Waterprice=#{Waterprice},Electricityprice=#{Electricityprice},day=#{day}," +
            "beforewaternumber=#{beforewaternumber},beforeElectricitynumber=#{beforeElectricitynumber}")
    public void updatebuilding(Building building);

    @Delete("delect fron guests where id=#{id}")
    public void delectguest(String id);

    @Delete("delect from historyguest where id=#{id}")
    public void delecthistroy(String id);

    @Insert("INSERT INTO histroyguest(id, name, phone,sex,address,day,buildingnmum) " +
            "VALUES (#{id}, #{name}, #{phone},#{sex},#{address},#{day},#{buildingnmum})")
    public void inserthistroy(Guest guest);
}
