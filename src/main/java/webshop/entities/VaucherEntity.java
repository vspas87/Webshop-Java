package webshop.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Vaucher")
public class VaucherEntity {
	
	//Atributi
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int id;
	
	@Column(name="ExpirationDate")
	public Date expDate;
	
	@Column(name="IsVaucherUser")
	public boolean isUsed;
	
	//Veze sa drugim tabelama
	@ManyToOne(cascade=CascadeType.REFRESH, fetch=FetchType.LAZY)
	@JoinColumn(name="user")
	private UserEntity user;
	
	@ManyToOne(cascade=CascadeType.REFRESH, fetch=FetchType.LAZY)
	@JoinColumn(name="offer")
	private OfferEntity offer;
	
	//Konstruktori
	public VaucherEntity() {}
	public VaucherEntity(int id, Date expDate, boolean isUsed, UserEntity user, OfferEntity offer) {
		super();
		this.id = id;
		this.expDate = expDate;
		this.isUsed = isUsed;
		this.user = user;
		this.offer = offer;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getExpDate() {
		return expDate;
	}
	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}
	public boolean isUsed() {
		return isUsed;
	}
	public void setUsed(boolean isUsed) {
		this.isUsed = isUsed;
	}
	public UserEntity getUser() {
		return user;
	}
	public void setUser(UserEntity user) {
		this.user = user;
	}
	public OfferEntity getOffer() {
		return offer;
	}
	public void setOffer(OfferEntity offer) {
		this.offer = offer;
	}
	
}
