package com.noah.mapper;

import com.noah.entity.Supplier;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by ljp on 2017/3/7.
 */
@Mapper
public interface SupplierMapper {
    @Select("SELECT * FROM supplier WHERE NAME = #{name}")
    Supplier findByName(@Param("name") String name);

    @Insert("INSERT INTO supplier(NAME) VALUES(#{name})")
    int insert(@Param("name") String name);

    @Select("SELECT * FROM supplier WHERE id = #{id}")
    Supplier findById(@Param("id") Long id);
}
