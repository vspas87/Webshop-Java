package webshop.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="Category")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CategoryEntity {
	
	//Atributi
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer id;
	
	@Column(name="CategoryName")
	@Size(min=3, max=30, message="Category name should be named with 3 to 30 letters")
	public String CategoryName;
	
	@Column(name="CategoryDescription")
	@Size(min=3, max=30, message="Category description should be described with 3 to 30 letters")
	public String CategoryDescription;
	
	//Veze sa drugim tabelama
	@OneToMany(mappedBy="category", cascade=CascadeType.REFRESH, fetch=FetchType.LAZY)
	private List<OfferEntity> offer = new ArrayList<>();
	
	//Konstruktori
	public CategoryEntity() {}
	public CategoryEntity(Integer id,
			@Size(min = 3, max = 30, message = "Category name should be named with 3 to 30 letters") String categoryName,
			@Size(min = 3, max = 30, message = "Category description should be described with 3 to 30 letters") String categoryDescription,
			List<OfferEntity> offer) {
		super();
		this.id = id;
		this.CategoryName = categoryName;
		this.CategoryDescription = categoryDescription;
		this.offer = offer;
	}
	
	//GET && SET
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCategoryName() {
		return CategoryName;
	}
	public void setCategoryName(String categoryName) {
		CategoryName = categoryName;
	}
	public String getCategoryDescription() {
		return CategoryDescription;
	}
	public void setCategoryDescription(String categoryDescription) {
		CategoryDescription = categoryDescription;
	}
	public List<OfferEntity> getOffer() {
		return offer;
	}
	public void setOffer(List<OfferEntity> offer) {
		this.offer = offer;
	}
	
	
	

}
