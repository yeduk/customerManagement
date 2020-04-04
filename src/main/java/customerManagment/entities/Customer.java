package customerManagment.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "customer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "first_name")
	@NotEmpty
	@Size(max = 45, message = "Please give a name within 45 character")

	private String firstName;
	@Column(name = "last_name")
	@NotEmpty
	@Size(max = 45, message = "Please give a name within 45 character")
	private String lastName;
	@NotEmpty(message = "Invalid Date")
	@DateTimeFormat(pattern="dd-MM-yyyy")
	private String dob;
	@NotEmpty
	private String gender;
	@NotEmpty
	@Email(message = "Please give a valid email")
	private String email;
	@NotEmpty(message = "Please give a phone number")
	private String phn;

	public Customer(String firstName, String lastName, String dob, String gender, String email, String phn) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.gender = gender;
		this.email = email;
		this.phn = phn;
	}

	public Customer() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String
			dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhn() {
		return phn;
	}

	public void setPhn(String phn) {
		this.phn = phn;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", dob=" + dob
				+ ", gender=" + gender + ", email=" + email + ", phn=" + phn + "]";
	}

}
