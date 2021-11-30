package com.sdyb.mp.service;

import com.sdyb.mp.entity.Student;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lyr
 * @since 2021-11-29
 */
public interface StudentService extends IService<Student> {

  Student getStudentById(String id);

  List<Student> selectStudentLikeMyEmail(String myEmail);

}
