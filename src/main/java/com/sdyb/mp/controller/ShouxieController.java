package com.sdyb.mp.controller;

import com.sdyb.mp.entity.Student;
import com.sdyb.mp.service.StudentService;
import com.sdyb.mp.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/** 手写sql实现 */
@RestController
@RequestMapping("/student1")
public class ShouxieController {

  @Autowired private StudentService studentService;

  /**
   * 手写：根据id获取到对象
   *
   * @param id id
   * @return result
   */
  @GetMapping("getById")
  public Result getById(@RequestParam("id") String id) {

    Student entity = studentService.getStudentById(id);

    int code = null == entity ? 1 : 0;
    String msg = code == 0 ? "根据id获取到对象" : "根据id获取不到对象";

    Result result = new Result();
    result.putCode(code);
    result.putMsg(msg);
    result.putData(entity);
    return result;
  }

  // MP: 根据条件查询，返回list
  @GetMapping("getStudentLikeMyEmail")
  public Result list1(@RequestParam("myEmail") String myEmail) {

    List<Student> list = studentService.selectStudentLikeMyEmail(myEmail);

      int code = (null == list||0==list.size()) ? 1 : 0;
      String msg = code == 0 ? "获取到数据" : "获取不到数据";

      Result result = new Result();
      result.putCode(code);
      result.putMsg(msg);
      result.putData(list);
      return result;
  }

  /**
   * 分页和条件查询 示例：http://localhost:8888/student/page1?currentPage=1&size=3
   *
   * @param current 当前页，从1开始
   * @param size 每页展示的数量
   * @return result
   */
  @GetMapping("page")
  public Result page1(@RequestParam("current") int current, @RequestParam("size") int size) {
    Result result = new Result();
    return result;
  }
}
