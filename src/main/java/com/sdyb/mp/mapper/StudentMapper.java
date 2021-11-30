package com.sdyb.mp.mapper;

import com.sdyb.mp.entity.Student;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author lyr
 * @since 2021-11-29
 */
@Mapper
@Component
public interface StudentMapper extends BaseMapper<Student> {

    Student selectStudentById(String id);

    List<Student> selectStudentLikeMyEmail(String myEmail);

}
