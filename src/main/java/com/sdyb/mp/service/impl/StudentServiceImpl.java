package com.sdyb.mp.service.impl;

import com.sdyb.mp.entity.Student;
import com.sdyb.mp.mapper.StudentMapper;
import com.sdyb.mp.service.StudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lyr
 * @since 2021-11-29
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public Student getStudentById(String id) {
        return studentMapper.selectStudentById(id);
    }

    @Override
    public List<Student> selectStudentLikeMyEmail(String myEmail) {
        return studentMapper.selectStudentLikeMyEmail(myEmail);
    }
}
