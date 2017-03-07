package com.noah.mapper;

import com.noah.entity.Indent;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by ljp on 2017/3/7.
 */
@Mapper
public interface IndentMapper {
    @Select("SELECT * FROM indent WHERE product_id = #{productId}")
    Indent findByProductId(@Param("productId") Long productId);

    @Insert("INSERT INTO indent(customer_id, product_id, currency, sum, amount, status, start_date, end_date, ext ) " +
            "VALUES(#{customerId}, #{productId}, #{currency}, #{sum}, #{amount}, #{status}, #{startDate}, #{endDate}, #{ext})")
    int insert(Indent order);

    @Select("SELECT * FROM indent WHERE id = #{id}")
    Indent findById(@Param("id") Long id);

    @Results({
            @Result(property = "customerId", column = "customer_id"),
            @Result(property = "productId", column = "product_id")
    })
    @Select("SELECT customer_id, product_id FROM indent")
    List<Indent> findAll();
}
