package thymeleaf.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;


@Entity
@Table(name = "groups")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(
            name = "group_id_generator",
            sequenceName = "group_id_seq",
            allocationSize = 1
    )


    private Long id;
    private String  groupName;
    private LocalDate dateOfStart;
    private LocalDate dateOfFinish;

    @ManyToMany(mappedBy = "groupList")
    private List<Course> courseList;

    @OneToMany
    private List<Student> studentList;


    public Group() {
    }

    public Group(String groupName, LocalDate dateOfStart, LocalDate dateOfFinish, List<Course> courseList, List<Student> studentList) {
        this.groupName = groupName;
        this.dateOfStart = dateOfStart;
        this.dateOfFinish = dateOfFinish;
        this.courseList = courseList;
        this.studentList = studentList;
    }
}
