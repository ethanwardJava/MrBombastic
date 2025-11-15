package com.arcade.mrbombastice.repository;

import com.arcade.mrbombastice.Entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {




}
