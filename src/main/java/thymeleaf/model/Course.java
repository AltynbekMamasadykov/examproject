package thymeleaf.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "courses")
@Getter @Setter

public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(
            name = "course_id_generator",
            sequenceName = "course_id_seq",
            allocationSize = 1
    )

    private Long id;
    private String courseName;
    private String duration;

    public Course() {
    }

    public Course(String courseName, String duration) {
        this.courseName = courseName;
        this.duration = duration;
    }
}
