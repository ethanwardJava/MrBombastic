package com.arcade.mrbombastice.repository;

import com.arcade.mrbombastice.Entity.Course;
import com.arcade.mrbombastice.Entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    CourseMaterialRepository repo;

    @Test
    public void saveCourseMaterial() {

        Course course = Course.builder()
                .title("Maven")
                .credit(5)
                .build();

        CourseMaterial courseMaterial = CourseMaterial.builder()
                .url("www.bomb.com")
                .course(course)
                .build();

        repo.save(courseMaterial);
    }

    @Test
    public void printAllCourses(){
        List<CourseMaterial> courseMaterials = repo.findAll();
        System.out.println(courseMaterials);
    }
}
