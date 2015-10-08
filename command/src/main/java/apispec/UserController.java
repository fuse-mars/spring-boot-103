// controller and application starter/entry point
package apispec;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@RequestMapping(value = "/register", method = RequestMethod.POST, headers = { "validation=spring-boot-103", "userhash=register" }, produces = "application/json")
	public Map<String, String> postCommand(@RequestBody User user) {
		Map<String, String> ACK = new HashMap<String, String>();
		ACK.put("success", "true");
		ACK.put("message", "started saving the received data");

		System.out.println(user);
		// start a worker actor to take care of the data saving task
		// ----
		userRepository.save(user);
		// ----

		return ACK;
	}

	@RequestMapping(value = "/deactivate/{id}", method = RequestMethod.DELETE, headers = { "validation=spring-boot-103", "userhash=deactivate" }, produces = "application/json")
	public Map<String, String> deleteCommand(@PathVariable("id") long id) {
		Map<String, String> ACK = new HashMap<String, String>();
		ACK.put("success", "true");
		ACK.put("message", "started deativating your account");
		return ACK;
	}

}
