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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="Role")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class UserRole {
	
	//Atributi
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer id;
	
	@Column(name="NameOfRole", nullable=false, unique=true)
	@Size(min=3, max=15, message="Name of the role is defined, and should have max 15 letters")
	public String roleName;
	
	//Veze sa drugim tabelama
	@JsonIgnore
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.REFRESH, mappedBy="role")
	private List<UserEntity> user= new ArrayList<>();
	
	//Konstruktori
	public UserRole() {}
	public UserRole(Integer id,
			@Size(min = 3, max = 15, message = "Name of the role is defined, and should have max 15 letters") String roleName,
			List<UserEntity> user) {
		super();
		this.id = id;
		this.roleName = roleName;
		this.user = user;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public List<UserEntity> getUser() {
		return user;
	}
	public void setUser(List<UserEntity> user) {
		this.user = user;
	}
	
	
	
	
	

}
