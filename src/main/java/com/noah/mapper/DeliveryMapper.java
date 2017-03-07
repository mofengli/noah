package com.noah.mapper;

import com.noah.entity.Delivery;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by ljp on 2017/3/7.
 */
@Mapper
public interface DeliveryMapper {
    @Select("SELECT * FROM delivery WHERE indent_id = #{indentId}")
    Delivery findByIndentId(@Param("indentId") Long indentId);

    @Select("SELECT * FROM delivery WHERE id = #{id}")
    Delivery findById(@Param("id") Long id);

    @Insert("INSERT INTO delivery(indent_id, sender, receiver, amount) VALUES(#{indentId}, #{sender}, #{receiver}, #{amount})")
    int insert(Delivery delivery);
}
