package cn.clj.zchao;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 项目启动类
 */
//@ServletComponentScan //扫描servlet注解
//@EnableScheduling //开启spring定时任务
//@MapperScan(basePackages = "com.zhangchao.springboot.dao")//mybatis注解，扫描mapper接口文件
@SpringBootApplication
public class SpringbootdemoApplication2 {

    public static void main(String[] args) {

        SpringApplication.run(SpringbootdemoApplication2.class, args);
    }

}

