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
@Table(name = "review")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Review {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "review_date")
	private Date reviewDate;
	
	@Column(name = "rating")
	private int rating;
	
	@Column(name = "conten")
	private String content;
	
	@Column(name = "picture")
	private String picture;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="user_id", referencedColumnName="id")
	private User user;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="pro_id", referencedColumnName="id")
	private Product product;
}
