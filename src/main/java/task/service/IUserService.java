package task.service;

import task.model.User;

/**
 * @author Pavel Smokorovskiy on 03.05.18
 */

public interface IUserService {

	   Iterable<User> listAllUsers();

	   User getUserById(long id);

	   User saveUser(User user);
	    
	   void deleteUser(long id);
	
}
