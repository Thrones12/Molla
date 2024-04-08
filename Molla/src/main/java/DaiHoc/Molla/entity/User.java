package DaiHoc.Molla.entity;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String fullname;

    private Date birthdate;

    private String address;

    @Column(nullable = false, unique = true)
    private Integer phone;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private int state;

	@JsonIgnore
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Account account;
}
