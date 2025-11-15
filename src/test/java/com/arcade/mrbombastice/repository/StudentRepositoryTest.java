package com.arcade.mrbombastice.repository;

import com.arcade.mrbombastice.Entity.Guardian;
import com.arcade.mrbombastice.Entity.Student;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    @Disabled
    public void saveStudent() {

        Student student = Student.builder()
                .emailId("aFatMouseSinging@gmail.com")
                .firstName("John")
                .lastName("Wick")
                //.guardianName("Alireza")
                //.guardianEmail("theGodHimself@gmail.com")
                //.guardianMobile("123456789")
                .build();
        studentRepository.save(student);
    }

    @Test
    @Disabled
    public void saveStudentWithGuardian() {

        Guardian guardian = Guardian.builder()
                .name("SpongeBob")
                .email("patrickisfat@gmail.com")
                .mobile("78451232")
                .build();

        Student student = Student.builder()
                .firstName("Hannibal")
                .lastName("Lefter")
                .emailId("iamhungray@gmail.com")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    void findAll() {
        List<Student> students = studentRepository.findAll();
        System.out.println("Some human maybe :  " + students);
    }

    @Test
    void findByFirstNameContaining() {
        List<Student> students = studentRepository.findByFirstNameContaining("o");
        System.out.println("Found : " + students);
    }


    @Test
    void findByGuardian_Name() {
        List<Student> students = studentRepository.findByGuardian_Name("SpongeBob");
        System.out.println("Found : " + students);
    }


    @Test
    void findStudentBasedOnEmailAddress() {
        Student student = studentRepository.getByEmailAddress("iamhungray@gmail.com");
        System.out.println("Found : " + student);
    }

    @Test
    void fistNameOfEmail(){
        String email = "iamhungray@gmail.com";
        String stName = studentRepository.getStudentsFirstNameWithEmailAddress(email);
        String stLastName = studentRepository.getStudentsLastNameWithEmailAddress(email);
        System.out.println(stName.concat(stLastName));
    }


    @Test
    void getStudentByEmailAddressNativeGayQuery(){
        Student student = studentRepository.getStudentByEmailAddressNativeQuery("aFatMouseSinging@gmail.com");
        System.out.println("Found : " + student);
    }

}