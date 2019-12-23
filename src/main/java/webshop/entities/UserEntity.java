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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="User")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class UserEntity {
	
	//Atributi
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer id;
	
	@Column(name="Firstname")
	@NotNull
	@Size(min=2, max=20, message="Please write between 2 and 20 letters")
	public String firstname;
	
	@Column(name="Lastname")
	@NotNull
	@Size(min=2, max=20, message="Please write between 2 and 20 letters")
	public String lastname;
	
	@Column(name="Username", unique=true, nullable=false)
	@NotNull
	@Size(min=3, max=10, message="Please write between 3 and 10 letters")
	public String username;
	
	@Column(name="Password", unique=true, nullable=false)
	@NotNull
	@Size(min=4, max=10, message="Please write between 4 and 10 letters")
	public String password;
	
	@Column(name="EmailAdress")
	public String email;
	
	@Column(name="PhoneNumber")
	public Integer phoneNumber;
	
	@Column(name="JMBGNumber", unique=true, nullable=false)
	@NotNull
	public Integer JMBG;
	
	//Veze sa drugim tabelama
	@JsonIgnore
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.REFRESH, mappedBy="user")
	private List<OfferEntity> offers= new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.REFRESH, mappedBy="user")
	private List<BillEntity> bills= new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.REFRESH, mappedBy="user")
	private List<VaucherEntity> vaucher= new ArrayList<>();
	
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.REFRESH)
	@JoinColumn(name="role")
	private UserRole role;
	
	//Konstruktori
	public UserEntity() {}
	public UserEntity(Integer id,
			@NotNull @Size(min = 2, max = 20, message = "Please write between 2 and 20 letters") String firstname,
			@NotNull @Size(min = 2, max = 20, message = "Please write between 2 and 20 letters") String lastname,
			@NotNull @Size(min = 3, max = 10, message = "Please write between 3 and 10 letters") String username,
			@NotNull @Size(min = 4, max = 10, message = "Please write between 4 and 10 letters") String password,
			String email, Integer phoneNumber, @NotNull Integer jMBG, List<OfferEntity> offers, List<BillEntity> bills,
			List<VaucherEntity> vaucher, UserRole role) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
		this.email = email;
		this.phoneNumber = phoneNumber;
		JMBG = jMBG;
		this.offers = offers;
		this.bills = bills;
		this.vaucher = vaucher;
		this.role = role;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Integer phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Integer getJMBG() {
		return JMBG;
	}

	public void setJMBG(Integer jMBG) {
		JMBG = jMBG;
	}

	public List<OfferEntity> getOffers() {
		return offers;
	}

	public void setOffers(List<OfferEntity> offers) {
		this.offers = offers;
	}

	public List<BillEntity> getBills() {
		return bills;
	}

	public void setBills(List<BillEntity> bills) {
		this.bills = bills;
	}

	public List<VaucherEntity> getVaucher() {
		return vaucher;
	}

	public void setVaucher(List<VaucherEntity> vaucher) {
		this.vaucher = vaucher;
	}

	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}
	
}