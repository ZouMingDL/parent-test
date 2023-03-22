package com.trans.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trans.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StudentMapper extends BaseMapper<Student> {

    List<Student> selectByName(@Param("names") List<String> names);
}
