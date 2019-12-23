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
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="Bills")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class BillEntity {
	
	//Atributi
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int id;
	
	@Column(name="DateWhenBillWasCreated", nullable=false)
	public Date createDate;
	
	@Column(name="IsBillPaid")
	public boolean paid;
	
	@Column(name="IsBillCancelled")
	public boolean cancel;
	
	@Version
	public int version;
	
	
	//Veze sa drugim tabelama
	@ManyToOne(cascade=CascadeType.REFRESH, fetch=FetchType.LAZY)
	@JoinColumn(name="offer")
	private OfferEntity offer;
	
	@ManyToOne(cascade=CascadeType.REFRESH, fetch=FetchType.LAZY)
	@JoinColumn(name="user")
	private UserEntity user;
	
	//Konstruktori
	public BillEntity() {}
	public BillEntity(int id, Date createDate, boolean paid, boolean cancel, int version, OfferEntity offer,
			UserEntity user) {
		super();
		this.id = id;
		this.createDate = createDate;
		this.paid = paid;
		this.cancel = cancel;
		this.version = version;
		this.offer = offer;
		this.user = user;
	}
	
	//GET & SET metode
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public boolean isPaid() {
		return paid;
	}
	public void setPaid(boolean paid) {
		this.paid = paid;
	}
	public boolean isCancel() {
		return cancel;
	}
	public void setCancel(boolean cancel) {
		this.cancel = cancel;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	public OfferEntity getOffer() {
		return offer;
	}
	public void setOffer(OfferEntity offer) {
		this.offer = offer;
	}
	public UserEntity getUser() {
		return user;
	}
	public void setUser(UserEntity user) {
		this.user = user;
	}
	
	
	
	

}
