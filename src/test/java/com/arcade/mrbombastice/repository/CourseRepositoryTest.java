package com.arcade.mrbombastice.repository;

import com.arcade.mrbombastice.Entity.Course;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    CourseRepository repository;


    @Test
    void printCourses(){
        List<Course> courses = repository.findAll();
        System.out.println(courses);
    }

}