package DaiHoc.Molla.entity;

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
@Table(name = "product")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long productId;

    @Column(name = "name", length = 500, nullable = false, columnDefinition = "varchar(500) default 'Chưa đặt tên'")
    private String name;

    @Column(name = "picture", length = 255)
    private String picture;
 
    @Column(name = "description", length = 500)
    private String description;

    @Column(name = "purchase_price")
    private Float purchase_price;

    @Column(name = "selling_price")
    private Float selling_price;

    @Column(name = "state")
    private int state;
    
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "cate_id")
	private Category category;
	@ManyToOne
	@JoinColumn(name = "manu_id")
	private Manufacturer manufacturer;
	@ManyToOne
	@JoinColumn(name = "event_id")
	private PromotionalEvent event;
}
