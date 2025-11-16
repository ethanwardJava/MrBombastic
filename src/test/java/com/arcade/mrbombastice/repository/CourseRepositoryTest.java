package com.arcade.mrbombastice.repository;

import com.arcade.mrbombastice.Entity.Course;
import com.arcade.mrbombastice.Entity.Student;
import com.arcade.mrbombastice.Entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Transactional
class CourseRepositoryTest {

    @Autowired
    CourseRepository repository;


    @Test
    void printCourses() {
        List<Course> courses = repository.findAll();
        System.out.println(courses);
    }


    @Test
    void saveCourseWithTeacher() {

        Teacher teacher = Teacher.builder().firstName("Jamshid").lastName("Karam").build();
        Course course = Course.builder()
                .title("JavaScript")
                .credit(6)
                .teacher(teacher)
                .build();
        repository.save(course);
    }

    @Test
    public void findAllPagination() {
        Pageable pageWithSizeThree = PageRequest.of(0, 3);
        Pageable pageWithSizeTwo = PageRequest.of(1, 2);

        List<Course> courseList = repository.findAll(pageWithSizeThree).getContent();

        long totalCourses = repository.findAll(pageWithSizeThree).getTotalElements();
        long totalPages = repository.findAll(pageWithSizeThree).getTotalPages();

        System.out.println("List of Courses" + courseList);
        System.out.println("Total Courses: " + totalCourses);
        System.out.println("Total Pages: " + totalPages);
    }


    @Test
    public void findAllSorted() {
        Pageable sortByTitle = PageRequest.of(0, 3,
                Sort.by("title").ascending()
                        .and(Sort.by("credit").descending())
        );

        List<Course> courseList = repository.findAll(sortByTitle).getContent();
        System.out.println("List of Courses" + courseList);

    }


    @Test
    void findByDataContaining() {
        Pageable pageWithSizeThree = PageRequest.of(0, 3);
        List<Course> courseList = repository.findAllByTitleContaining(pageWithSizeThree, "D").getContent();
        System.out.println("================================================");
        for (Course course : courseList) {
            System.out.println(course);
        }
        System.out.println("================================================");
    }


    @Test
    void saveCourseWithStudentAndTeacher() {
        Teacher teacher = Teacher.builder().firstName("Mary").lastName("Sanchez").build();
        Student stud = Student.builder().firstName("Yara").lastName("Smith").emailId("yara@gmail.com").build();
        Course course = Course.builder().title("AI").credit(12).teacher(teacher).build();
        course.addStudents(stud);
        repository.save(course);
    }


}




















