package DaiHoc.Molla.entity;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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

    @Column(name = "picture", length = 255,  nullable = true)
    private String picture;
 
    @Column(name = "description", length = 500)
    private String description;

    @Column(name = "purchase_price", nullable = true)
    private Float purchase_price;

    @Column(name = "selling_price", nullable = true)
    private Float selling_price;

    @Column(name = "state")
    private int state;
    
    @Column(name = "sold", nullable = true)
    private int slod;
    
    @Column(name = "rating", nullable = true)
    private Integer rating;
    
	public int getSlod() {
		return slod;
	}
	public void setSlod(int slod) {
		this.slod = slod;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(Integer rating) {
		this.rating = rating;
	}
	public PromotionalEvent getEvent() {
		return event;
	}
	public void setEvent(PromotionalEvent event) {
		this.event = event;
	}
	public Set<LineItem> getLineItems() {
		return lineItems;
	}
	public void setLineItems(Set<LineItem> lineItems) {
		this.lineItems = lineItems;
	}
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "cate_id")
	private Category category;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "manu_id")
	private Manufacturer manufacturer;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "event_id")
	private PromotionalEvent event;
	
	@JsonIgnore
	@OneToMany(mappedBy="product", cascade = CascadeType.ALL)
	private Set<LineItem> lineItems;
	@JsonIgnore
	@OneToMany(mappedBy="product", cascade = CascadeType.ALL)
	private Set<Stock> stocks;
	@JsonIgnore
	@OneToMany(mappedBy="product", cascade = CascadeType.ALL)
	private Set<Review> reviews;
	@JsonIgnore
	@OneToMany(mappedBy="product", cascade = CascadeType.ALL)
	private Set<SubPicture> subPictures;
	

}

