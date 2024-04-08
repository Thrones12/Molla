package DaiHoc.Molla.entity;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="promotional_code")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PromotionalCode {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", length = 500)
    private String id;

    private Float discount;

    @Column(name = "exp_date")
    private Date expiryDate;

    private Integer quantity;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "type_id")
    private PromotionalType type;
}
