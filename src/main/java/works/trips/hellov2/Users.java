package works.trips.hellov2;


import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Table
@Component
@Entity
public class Users {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long Id;
	private String username;
	private String password;
	private String firstname;
	private String lastname;
	private String role;
	private String email;
	
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
