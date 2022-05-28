package thymeleaf.model;

import jakarta.persistence.*;

import java.time.LocalDate;


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

    public Group() {
    }

    public Group(String groupName, LocalDate dateOfStart, LocalDate dateOfFinish) {
        this.groupName = groupName;
        this.dateOfStart = dateOfStart;
        this.dateOfFinish = dateOfFinish;
    }
}
