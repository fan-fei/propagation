package propagation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import propagation.entity.User;
import propagation.entity.UserRepository;

@Service
public class PropagationService {

    @Autowired
    private UserRepository userRepository;

    public User save(User user) {
        return userRepository.save(user);
    }

    public void delete(Long id) {
        userRepository.delete(id);
    }

    public Iterable<User> findAll() {
        return userRepository.findAll();
    }
}