package com.filter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.filter.beans.User;
import com.filter.service.UserService;

@Component
public class Runner implements ApplicationRunner {
	@Autowired
	private UserService<User> userService;
	private static final Logger log = LoggerFactory.getLogger(Runner.class);

	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
		if (!hasRows()) {
			log.info("------------------ Start filling database ------------------");
			initUser();
			log.info("------------------ Database filled ------------------");
	}
		}

	void initUser() {
		log.info("\n");
		log.info("------------------ Start inserting pilots ------------------");
		userService.create(new User("Mario", "Rossi", 22, "N3LEWMFX9AS8JF", 66.3));
		userService.create(new User("John", "Doe", 24, "OKWSUWML4RBTCM", 67.5));
		userService.create(new User("Anna", "Bianchi", 32, "YIO7JRGKQT9JR9", 68.1));
		userService.create(new User("Marta", "Kovacic", 66, "H34MM4USRW3F27", 69));
		userService.create(new User("Alain", "Heidelberg", 87, "1TSKVEMN34CFUZ", 71.4));
		userService.create(new User("Mario", "Rossi", 22, "MMMMWMFX9AS8JF", 59.6));
		log.info("------------------ End inserting pilots ------------------");
		log.info("\n");

	}

	boolean hasRows() {
		return userService.countRows() > 0 ? true : false;
	}
}
