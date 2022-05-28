package thymeleaf.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name ="companies")
@Getter @Setter
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(
            name = "company_id_generator",
            sequenceName = "company_id_seq",
            allocationSize = 1
    )

    private Long id;
    private String companyName;
    private String locatedCountry;

    @OneToMany(mappedBy = "company")
    private List<Course> courses;


    public Company() {
    }


    public Company(String companyName, String locatedCountry, List<Course> courses) {
        this.companyName = companyName;
        this.locatedCountry = locatedCountry;
        this.courses = courses;
    }
}
