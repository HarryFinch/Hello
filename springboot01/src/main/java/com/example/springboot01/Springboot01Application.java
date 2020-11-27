package com.example.springboot01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * @SpringBootApplication 标注主程序，说明是一个 SpringBoot应用
 * 1、该注解标注的类，说明该类是 springboot 的主配置类，运行该类的 main() 方法，运行项目
 *
 * @Target({ElementType.TYPE})
 * @Retention(RetentionPolicy.RUNTIME)
 * @Documented
 * @Inherited
 * @SpringBootConfiguration
 * @EnableAutoConfiguration
 * @ComponentScan(
 *     excludeFilters = {@Filter(
 *     type = FilterType.CUSTOM,
 *     classes = {TypeExcludeFilter.class}
 * ), @Filter(
 *     type = FilterType.CUSTOM,
 *     classes = {AutoConfigurationExcludeFilter.class}
 * )}
 * )
 *
 * 1、@SpringBootConfiguration : spring boot 的配置类
 *   1.1、@Configuration : 配置类上标注该注解
 *        配置类就是配置文件，配置类也是容器中的组件(@Component)
 *
 * 2、@EnableAutoConfiguration : 开启自动配置功能
 *      boot之前需要自己配置的东西，SpringBoot 帮我们自动配置，
 *      该注解告诉 SpringBoot 开启自动配置功能，自动配置生效
 *   2.1、@EnableAutoConfiguration 直接解析
 *      ① @AutoConfigurationPackage : 自动配置包
 *          Ⅰ. @Import(AutoConfigurationPackages.Registrar.class);
 *                  Spring的底层原理注解 @Import，给容器导入一个组件，
 *          Ⅱ. 导入的组件由 AutoConfigurationPackages.Registrar.class
 *                  将主配置类(@SpringBootApplication 标注的类)的所在包及
 *                  下面所有子包里面的所有组件扫描到Spring容器
 *              ***重点记忆一下***
 */
@SpringBootApplication
public class Springboot01Application {

    public static void main(String[] args) {
        //Spring 应用启动起来
        SpringApplication.run(Springboot01Application.class, args);
    }

}
