package thymeleaf.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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

    public Company() {
    }

    public Company(String companyName, String locatedCountry) {
        this.companyName = companyName;
        this.locatedCountry = locatedCountry;
    }


}
