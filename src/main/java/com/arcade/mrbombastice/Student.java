package com.arcade.mrbombastice;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "tbl_student")
public class Student {

    @Id
    private Long studentId;

    private String firstName;
    private String lastName;
    private String emailId;

    private String guardianName;
    private String guardianEmail;
    private String guardianMobile;

}
