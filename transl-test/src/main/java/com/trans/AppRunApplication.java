package com.trans;

import com.trans.entity.Student;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.ArrayList;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.trans.mapper.*")
@Slf4j
public class AppRunApplication {
    public static void main(String[] args) {
        SpringApplication.run(AppRunApplication.class,args);

        ArrayList<Student> students = new ArrayList<>();
        int i = 0;
        while (true){
            Student student = new Student();
            student.setAge(i++);
            student.setName("a");
            students.add(student);
            log.debug("student+{}",students);
        }
    }
}
