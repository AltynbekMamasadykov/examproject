package thymeleaf.model;

import jakarta.persistence.*;

@Entity
@Table(name = "teachers")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(
            name = "teacher_id_generator",
            sequenceName = "teacher_id_seq",
            allocationSize = 1)

    private Long id;
    private String firstName;
    private String LastName;
    private String email;

    @OneToOne(mappedBy = "teacher")
    private Course course;

    public Teacher() {
    }

    public Teacher(String firstName, String lastName, String email, Course course) {
        this.firstName = firstName;
        LastName = lastName;
        this.email = email;
        this.course = course;
    }
}
