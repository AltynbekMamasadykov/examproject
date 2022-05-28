package thymeleaf.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "students")
@Getter @Setter

public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(
            name = "student_id_generator",
            sequenceName = "student_id_seq",
            allocationSize = 1
    )

    private Long id;
    private String firstName;
    private String LastName;
    private String email;
    private StudyFormat studyFormat;

    public Student() {
    }

    public Student(String firstName, String lastName, String email, StudyFormat studyFormat) {
        this.firstName = firstName;
        LastName = lastName;
        this.email = email;
        this.studyFormat = studyFormat;
    }


}
