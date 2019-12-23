package webshop.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="Offer")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class OfferEntity {
	
	//Atributi
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer id;
	
	@Column(name="offerName")
	@Size(min=3, max=10, message="Offer Name should have 3 to 10 letters")
	public String offerName;
	
	@Column(name="OfferDescription")
	@Size(min=3, max=20, message="Offer Description should have 3 to 20 letters")
	public String offerDescription;
	
	@Column(name="DateWhenOfferWasCreated")
	public Date offerCreated;
	
	@Column(name="WhenOfferExpires")
	public Date offerExpires;
	
	@Column(name="ActionPrice")
	public Integer actionPrice;
	
	@Column(name="ImagePath")
	public String imagePath;
	
	@Column(name="HowManyOffersIsAvailable")
	public Integer availableOffers;
	
	@Column(name="HowManyOffersWasBought")
	public Integer boughtOffers;
	
	public enum offerStatus { WAIT_FOR_APPROVING, APPROVED, DECLINED, EXPIRED}
	
	//Veze sa drugim tabelama
	@ManyToOne(cascade=CascadeType.REFRESH, fetch=FetchType.LAZY)
	@JoinColumn(name="user")
	private UserEntity user;
	
	@ManyToOne(cascade=CascadeType.REFRESH, fetch=FetchType.LAZY)
	@JoinColumn(name="category")
	private CategoryEntity category;
	
	@OneToMany(mappedBy="offer", cascade=CascadeType.REFRESH, fetch=FetchType.LAZY)
	private List<BillEntity> bill = new ArrayList<>();
	
	@OneToMany(mappedBy="offer", cascade=CascadeType.REFRESH, fetch=FetchType.LAZY)
	private List<VaucherEntity> vaucher= new ArrayList<>();

	//Konstruktori
	public OfferEntity() {}
	public OfferEntity(Integer id,
			@Size(min = 3, max = 10, message = "Offer Name should have 3 to 10 letters") String offerName,
			@Size(min = 3, max = 20, message = "Offer Description should have 3 to 20 letters") String offerDescription,
			Date offerCreated, Date offerExpires, Integer actionPrice, String imagePath, Integer availableOffers,
			Integer boughtOffers, UserEntity user, CategoryEntity category, List<BillEntity> bill,
			List<VaucherEntity> vaucher) {
		super();
		this.id = id;
		this.offerName = offerName;
		this.offerDescription = offerDescription;
		this.offerCreated = offerCreated;
		this.offerExpires = offerExpires;
		this.actionPrice = actionPrice;
		this.imagePath = imagePath;
		this.availableOffers = availableOffers;
		this.boughtOffers = boughtOffers;
		this.user = user;
		this.category = category;
		this.bill = bill;
		this.vaucher = vaucher;
	}
	
	//GET && SET
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getOfferName() {
		return offerName;
	}
	public void setOfferName(String offerName) {
		this.offerName = offerName;
	}
	public String getOfferDescription() {
		return offerDescription;
	}
	public void setOfferDescription(String offerDescription) {
		this.offerDescription = offerDescription;
	}
	public Date getOfferCreated() {
		return offerCreated;
	}
	public void setOfferCreated(Date offerCreated) {
		this.offerCreated = offerCreated;
	}
	public Date getOfferExpires() {
		return offerExpires;
	}
	public void setOfferExpires(Date offerExpires) {
		this.offerExpires = offerExpires;
	}
	public Integer getActionPrice() {
		return actionPrice;
	}
	public void setActionPrice(Integer actionPrice) {
		this.actionPrice = actionPrice;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public Integer getAvailableOffers() {
		return availableOffers;
	}
	public void setAvailableOffers(Integer availableOffers) {
		this.availableOffers = availableOffers;
	}
	public Integer getBoughtOffers() {
		return boughtOffers;
	}
	public void setBoughtOffers(Integer boughtOffers) {
		this.boughtOffers = boughtOffers;
	}
	public UserEntity getUser() {
		return user;
	}
	public void setUser(UserEntity user) {
		this.user = user;
	}
	public CategoryEntity getCategory() {
		return category;
	}
	public void setCategory(CategoryEntity category) {
		this.category = category;
	}
	public List<BillEntity> getBill() {
		return bill;
	}
	public void setBill(List<BillEntity> bill) {
		this.bill = bill;
	}
	public List<VaucherEntity> getVaucher() {
		return vaucher;
	}
	public void setVaucher(List<VaucherEntity> vaucher) {
		this.vaucher = vaucher;
	}

	
}
