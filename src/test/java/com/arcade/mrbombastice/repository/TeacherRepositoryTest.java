package com.arcade.mrbombastice.repository;

import com.arcade.mrbombastice.Entity.Course;
import com.arcade.mrbombastice.Entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    TeacherRepository repo;


    Course course = Course.builder()
            .title("DBA")
            .credit(6)
            .build();


    Course coursePython = Course.builder()
            .title("Python")
            .credit(6)
            .build();

    @Test
    public void saveTeacher() {
        Teacher teacher = Teacher.builder()
                .firstName("Jim")
                .lastName("Carry")
                //.courses(List.of(course , coursePython))
                .build();
        repo.save(teacher);
    }

}