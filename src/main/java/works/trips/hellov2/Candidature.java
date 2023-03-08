package works.trips.hellov2;


import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;


@Table
@Component
@Entity
@Access(value=AccessType.FIELD)
public class Candidature {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long Id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users users;
    @NotBlank(message = "Company Name is mandatory")
    private String companyname;
    @NotBlank(message = "Adress is mandatory")
    private String adress;
    @NotBlank(message = "Postcode is mandatory")
    private String postcode;
    @NotBlank(message = "City is mandatory")
    private String city;
    private String contactName;
    private String mail;
    private String phonenumber;
    private LocalDateTime creationDate;
    private LocalDateTime contactDate;
    
    
    protected Candidature() {//for JPA, dont use this
	};
    
    public Candidature(Long id, Users users, @NotBlank(message = "Company Name is mandatory") String companyname,
	    @NotBlank(message = "Adress is mandatory") String adress,
	    @NotBlank(message = "Postcode is mandatory") String postcode,
	    @NotBlank(message = "City is mandatory") String city, String contactName, String mail, String phonenumber,
	    LocalDateTime creationDate, LocalDateTime contactDate) {
	super();
	Id = id;
	this.users = users;
	this.companyname = companyname;
	this.adress = adress;
	this.postcode = postcode;
	this.city = city;
	this.contactName = contactName;
	this.mail = mail;
	this.phonenumber = phonenumber;
	this.creationDate = creationDate;
	this.contactDate = contactDate;
    }
    public Long getId() {
        return Id;
    }
    public void setId(Long id) {
        this.Id =  id;
    }
    
    public String getCompanyname() {
        return companyname;
    }
    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }
    public String getAdress() {
        return adress;
    }
    public void setAdress(String adress) {
        this.adress = adress;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getContactName() {
        return contactName;
    }
    public void setContactName(String contactName) {
        this.contactName = contactName;
    }
    public String getMail() {
        return mail;
    }
    public void setMail(String mail) {
        this.mail = mail;
    }
    public String getPhonenumber() {
        return phonenumber;
    }
    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }
    public LocalDateTime getCreationDate() {
        return creationDate;
    }
    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }
    public LocalDateTime getContactDate() {
        return contactDate;
    }
    public void setContactDate(LocalDateTime contactDate) {
        this.contactDate = contactDate;
    }
    public Users getUsers() {
        return users;
    }
    public void setUsers(Users users) {
        this.users = users;
    }
    public String getPostcode() {
        return postcode;
    }
    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }
    @Override
    public String toString() {
	return "Candidature [Id=" + Id + ", users=" + users.getId() + ", companyname=" + companyname + ", adress=" + adress
		+ ", postcode=" + postcode + ", city=" + city + ", contactName=" + contactName + ", mail=" + mail
		+ ", phonenumber=" + phonenumber + ", creationDate=" + creationDate + ", contactDate=" + contactDate
		+ "]";
    }
   
    
    
    

}
