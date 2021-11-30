package com.sdyb.mp.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sdyb.mp.dto.StudentDto;
import com.sdyb.mp.entity.Student;
import com.sdyb.mp.mapper.StudentMapper;
import com.sdyb.mp.service.StudentService;
import com.sdyb.mp.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author lyr
 * @since 2021-11-29
 */
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private StudentService studentService;

    /**
     * MP自带：根据id获取到对象
     * @param id id
     * @return result
     */
    @GetMapping("/find")
    public Result getById(@RequestParam("id")String id){

        Result result = new Result();

        Student entity = studentService.getById(id);

        int code = null==entity ? 1 :0;
        String msg = code==0 ? "根据id获取到对象":"根据id获取不到对象";

        result.putCode(code);
        result.putMsg(msg);
        result.putData(entity);

        return result;
    }

  /**
   * 前端传递dto，后端保存实体类
   *
   * 示例：{ "name":"222", "myEmail":"ddddd" } postman要选择post，下面点击raw和选择JSON
   *
   * @param dto StudentDto
   * @return result
   */
  @PostMapping("/add")
  public Result add(@RequestBody StudentDto dto) {

        Result result = new Result();

        Student student = new Student();
        student.setName(dto.getName());
        student.setMyEmail(dto.getMyEmail());

        // 插入成功返回1
        // 插入失败返回？
        int insert = studentMapper.insert(student);

        int code = insert==1 ? 0:1;
        String msg = code==0 ?"添加成功":"添加失败";

        result.putCode(code);
        result.putMsg(msg);
        return result;
    }


    /**
     * MP: 根据条件查询，返回list
     * @return result
     */
    @GetMapping("list")
    public Result list(){

        Result result = new Result();

        QueryWrapper<Student> wrapper = new QueryWrapper<>();
        wrapper.like("name","11");

        List list = studentService.list(wrapper);

        int code = (null == list || 0 == list.size()) ? 1:0;
        String msg = code==0 ?"找到数据":"找不打数据";

        result.putCode(code);
        result.putMsg(msg);
        return result;

    }

    /**
     * 分页和条件查询
     * 示例：http://localhost:8888/student/page?current=1&size=3
     * @param current 当前页，从1开始
     * @param size 每页展示的数量
     * @return result
     */
    @GetMapping("page")
    public Result page(@RequestParam("current")int current,@RequestParam("size")int size){

        Page<Student> page = new Page<>(current,size);

        QueryWrapper<Student> wrapper = new QueryWrapper<>();
        wrapper.like("my_email","11");

        // 根据某字段排序
        // wrapper.select().orderByAsc("id");
        // wrapper.select().orderByDesc("id");

        Page<Student> pageStu = studentService.page(page, wrapper);

        int code = (null == pageStu || 0 == pageStu.getTotal())?1:0;
        String msg = code==0 ?"找到数据":"找不到数据";

        Result result = new Result();
        result.putCode(code);
        result.putMsg(msg);
        result.putData(pageStu);
        return result;
    }

    /**
     *  示例：http://localhost:8888/student/deleteById?id=222
     */
    @GetMapping("deleteById")
    public Result deleteById(@RequestParam("id")String id){
        boolean b = studentService.removeById(id);
        int code = b ? 0 :1;
        String msg = code==0 ? "删除成功":"删除失败";

        Result result = new Result();
        result.putCode(code);
        result.putMsg(msg);
        return result;
    }

}

