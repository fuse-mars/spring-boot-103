//model object definition
package apispec;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

/*
 * data model definition
 * First Name = ``
 * Last Name = ``
 * Description = `userful info about this user`
 * Date Of Birth = `email address to be used to login and communication`
 * Title = `position in the company or student`
 * Company = `name of the Company you work for`
 * Languages and frameworks = `list of Languages and frameworks that you have worked with`
 */
@Entity
public class Profile {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String firstName;
	private String lastName;
	private String description;

	private String dob;
	private String title;
	private String company;
	private String programming; // list of Languages and frameworks
	
	@ManyToOne(optional=false)
	@JoinColumn(name="userid", referencedColumnName="id")
	private User user;
	
	public void setLastName(String firstName) {
		this.firstName = firstName;
	}

	public void setFirstName(String lastName) {
		this.lastName = lastName;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public void setProgramming(String programming) {
		this.programming = programming;
	}

	public Profile() {
	}

	public Profile(String firstName, String lastName, String description) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.description = description;
	}
}
