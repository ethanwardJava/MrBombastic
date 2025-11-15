package com.arcade.mrbombastice.repository;

import com.arcade.mrbombastice.Entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByFirstName(String firstName);

    List<Student> findByFirstNameContaining(String lastName);

    List<Student> findByLastNameNotNull();

    List<Student> findByGuardian_Name(String name);

    List<Student> findByFirstNameAndLastName(String firstName, String lastName);

    @Query("SELECT s FROM Student s WHERE s.emailId = :emailAddress")
    Student getByEmailAddress(@Param("emailAddress") String emailAddress);

    @Query("SELECT s.firstName FROM Student s WHERE s.emailId = :emailAddress")
    String getStudentsFirstNameWithEmailAddress(@Param("emailAddress") String emailAddress);

    @Query("SELECT s.lastName FROM Student s WHERE s.emailId = :emailAddress")
    String getStudentsLastNameWithEmailAddress(@Param("emailAddress") String emailAddress);

    @Query(nativeQuery = true, value = "SELECT * FROM tbl_student t WHERE t.email_address = :emailAddress")
    Student getStudentByEmailAddressNativeQuery(@Param("emailAddress") String emailAddress);

    @Modifying
    @Transactional
    @Query(
            value = "UPDATE tbl_student t SET t.fisrt_name= :first_name" +
                    " WHERE email_address = :emailAddress ",
            nativeQuery = true
    )
    int updateByEmailAddress(
            @Param("first_name") String firstName,
            @Param("emailAddress") String emailAddress);

}
