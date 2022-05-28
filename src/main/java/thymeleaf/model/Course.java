package thymeleaf.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

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
    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @ManyToMany
    @JoinTable(name = "course_group",
    joinColumns={@JoinColumn(name = "course_id")},
    inverseJoinColumns = {@JoinColumn(name = "group_id")})
    private List<Group> groupList;


    @OneToOne
    @PrimaryKeyJoinColumn
    private Teacher teacher;

    public Course() {
    }

    public Course(String courseName, String duration, Company company, List<Group> groupList, Teacher teacher) {
        this.courseName = courseName;
        this.duration = duration;
        this.company = company;
        this.groupList = groupList;
        this.teacher = teacher;
    }
}
