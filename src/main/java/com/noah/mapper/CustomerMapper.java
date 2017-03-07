package com.noah.mapper;


import com.noah.entity.Customer;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by ljp on 2017/3/7.
 */
@Mapper
public interface CustomerMapper {
    @Select("SELECT * FROM customer WHERE NAME = #{name}")
    Customer findByName(@Param("name") String name);

    @Insert("INSERT INTO customer(NAME) VALUES(#{name})")
    int insert(@Param("name") String name);

    @Select("SELECT * FROM customer WHERE id = #{id}")
    Customer findById(@Param("id") Long id);
}
