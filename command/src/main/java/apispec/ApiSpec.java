//model object definition
package apispec;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * data model definition
 * API = `<host>/api`
 * METHOD = `GET, POST, PUT, DELETE`
 * HEADERS = `{Authorization: "", hash: ""}`
 * QUERY_PARAMS = `{userdata: {a: 1, b: 2}}`
 * 
 * Setter methods are required by the repository
 */
@Entity
public class ApiSpec {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String api;
	private String method;
	private String headers;
	private String queryParams;

	private long userid;
	
	@ManyToOne(optional=true)
	@JoinColumn(name="userid", referencedColumnName="id", insertable=false, updatable=false)
	private User user;
	
	public void setApi(String api) {
		this.api = api;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public void setHeaders(String headers) {
		this.headers = headers;
	}

	public void setQueryParams(String queryParams) {
		this.queryParams = queryParams;
	}
	public void setUserid(long userid) {
		this.userid = userid;
	}

	public ApiSpec() {
	}

	public ApiSpec(String api, String method, String headers, String queryParams, long userid) {
		this.api = api;
		this.method = method;
		this.headers = headers;
		this.queryParams = queryParams;
		this.userid = userid;
	}
	
	@Override
	public String toString() {
		return String.format("apispec[api=%s, method=%s, headers=%s, queryParams=%s, userid=%s]",
				api, method, headers, queryParams, userid);
	}
}
