package com.noah.mapper;

import com.noah.entity.Product;
import org.apache.ibatis.annotations.*;

/**
 * Created by ljp on 2017/3/7.
 */
@Mapper
public interface ProduceMapper {
    @Select("SELECT * FROM product WHERE name = #{name}")
    Product findByName(@Param("name") String name);

    @Select("SELECT * FROM product WHERE id = #{id}")
    Product findById(@Param("id") Long id);

    @Insert("INSERT INTO product(name, code) VALUES(#{name}, #{code})")
    int insert(@Param("name") String name, @Param("code") String code);

    @Update("UPDATE product SET name=#{name} WHERE id=#{id}")
    void update(Product product);

    @Delete("DELETE FROM product WHERE id =#{id}")
    void delete(Long id);
}
