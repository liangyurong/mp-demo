package com.sdyb.mp.test;

import com.google.common.base.Joiner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest // (classes = TestRun.class) // .class对应.java文件名
public class TestRun {

    private final List<String> strList = Arrays.asList(
            "aa","bb","cc","dd"
    );

    private final List<String> strListWithNull = Arrays.asList(
            "aa","bb","cc",null
    );

    @Test
    public void testJoinerOnJoin(){
        // 使用*拼接字符串数组的元素
        String result = Joiner.on("*").join(strList);
        // 如果result与期望值不同，则抛出异常。否则无事发生，
        assertThat(result,equalTo("aa*bb*cc*dd"));
    }

    @Test
    public void testJoiner_On_Join_WithNullValue(){
        // 使用*拼接字符串数组的元素
        String result = Joiner.on("*").join(strListWithNull);
        // 含有null，抛出异常：at com.google.common.base.Preconditions.checkNotNull
        assertThat(result,equalTo("aa*bb*cc*dd"));
    }

    @Test
    public void testJoiner_On_Join_WithNullValue_ButSkip(){
        // 使用*拼接字符串数组的元素
        // 屏蔽了null值
        String result = Joiner.on("*").skipNulls().join(strListWithNull);
        // 含有null，不抛出异常
        assertThat(result,equalTo("aa*bb*cc"));
    }

    // 当方法的逻辑比较多，可以加下划线区分
    @Test
    public void testJoiner_On_Join_WithNullValue_ButReplaceDefaultValue(){
        // 使用*拼接字符串数组的元素
        // 使用DEFAULT字符串代替null
        String result = Joiner.on("*").useForNull("DEFAULT").join(strListWithNull);
        // 含有null，不抛出异常
        assertThat(result,equalTo("aa*bb*cc*DEFAULT"));
    }




}
