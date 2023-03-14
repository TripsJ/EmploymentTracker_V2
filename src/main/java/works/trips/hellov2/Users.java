package works.trips.hellov2;


import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


@Table
@Component
@Entity
public class Users {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long Id;
	@NotBlank(message = "Username is mandatory")
	private String username;
	@NotBlank(message = "Password is mandatory")
	@Size(min = 12, message = "Validation Error: Size too short")
	@JsonProperty(access = Access.WRITE_ONLY)
	private String password;
	@NotBlank(message = "Firstname is mandatory")
	private String firstname;
	@NotBlank(message = "Lastname is mandatory")
	private String lastname;
	private String role;
	@NotBlank(message = "E Mail is mandatory")
	private String email;
	@OneToMany
	@JoinColumn(name = "candidature_id")
	private List <Candidature> candidatures;
	
	protected Users() { } // JPA needs this but it should never ever be used
	
	public Users( String username, String password, String firstname, String lastname, String role,
			String email) {
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.role = role;
		this.email = email;
	}
	
	
	// Getters and Setters
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
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
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [Id=" + Id + ", username=" + username + ", passwordhash=" + password + ", firstname="
				+ firstname + ", lastname=" + lastname + ", role=" + role + ", email=" + email + "]";
	}




	
	
	
	

}
