package task.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import task.model.User;
import task.repository.UserRepository;

/**
 * @author Pavel Smokorovskiy on 03.05.18
 */

@Service
public class UserServiceImpl implements IUserService {

	private UserRepository userRepository;
	
	@Autowired
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public Iterable<User> listAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User getUserById(long id) {
		return userRepository.findById(id);
	}

	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}
	
	@Override
	public void deleteUser(long id) {
		 userRepository.deleteById(id);
	}

	
}
