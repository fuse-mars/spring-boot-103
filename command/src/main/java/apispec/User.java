//model object definition
package apispec;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/*
 * data model definition
 * profile = `User full name, and other userful info about this user
 *           - should be an object`
 * email = `email address to be used to login and communication`
 * password = ``
 */
@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@OneToMany(mappedBy="user",targetEntity=Profile.class, fetch=FetchType.EAGER)
	private Collection<ApiSpec> apispecs;
	
	@OneToMany(mappedBy="user",targetEntity=Profile.class, fetch=FetchType.EAGER)
	private Collection<Profile> profiles;
	
	/**
	 * primary profile here
	 */
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="profile", referencedColumnName="id", nullable=true)
	private Profile profile;
	
	private String email;
	private String password;

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User() {
	}

	public User(String email, String password, Profile profile) {
		this.email = email;
		this.password = password;
		this.profile = profile;
	}
}
