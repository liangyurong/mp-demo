package com.sdyb.mp.test;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import org.junit.Test;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class TestHutool {

    @Test
    public void testExcel() {
        // excel文件路径
        String filePath = "C:/Users/lyr/Desktop/basic_info.xlsx";

        // 通过工具类创建writer
        ExcelWriter writer = ExcelUtil.getWriter(filePath);

        // 构建写入的数据
        Map<String, Object> row1 = new LinkedHashMap<>();
        row1.put("id", 11);
        row1.put("name", "11");
        row1.put("age", 1);

        Map<String, Object> row2 = new LinkedHashMap<>();
        row2.put("id", 22);
        row2.put("name", "22");
        row2.put("age", 22);

        Map<String, Object> row3 = new LinkedHashMap<>();
        row3.put("id", 33);
        row3.put("name", "33");
        row3.put("age", 33);

        ArrayList<Map<String, Object>> rows = CollUtil.newArrayList(row1, row2,row3);

        // 定位到最后一行的后边，用于追加数据(从hutool的版本5.5.0开始支持)
         writer.setCurrentRowToEnd();

        // 一次性写出内容，使用默认样式，
        // true：强制输出标题 ， false：不输出标题
        writer.write(rows, false);

        // 关闭writer，释放内存
        // write（写出数据）方法后只是将数据写入到Workbook，并不写出文件，只有调用flush或者close方法后才会真正写出文件
        writer.close();

    }
}
