package io.wincher.cloud.Controller;

import io.wincher.cloud.Entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserEndpoint {
	protected Logger logger = LoggerFactory.getLogger(UserEndpoint.class);
	
	@Value("${server.port:8221}")
	private int serverPort = 8221;
	
	@RequestMapping(value = "/{loginName}", method = RequestMethod.GET)
	public User detail(@PathVariable String loginName) {
		String memos = "I come from " + this.serverPort;
		return new User(loginName, loginName, "/avatar/default.png", memos);
	}
}
