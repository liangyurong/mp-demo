package com.sdyb.mp.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 全局常量
 */
@Configuration
@ConfigurationProperties(prefix="stu") // prefix不可使用驼峰命名或者下划线命名
@Data
public class GlobalPropertiesConfig {

   private static String name;

   private static Integer age;

   public static String getName() {
      return name;
   }

   public  void setName(String name) {
      GlobalPropertiesConfig.name = name;
   }

   public static Integer getAge() {
      return age;
   }

   public  void setAge(Integer age) {
      GlobalPropertiesConfig.age = age;
   }

}
