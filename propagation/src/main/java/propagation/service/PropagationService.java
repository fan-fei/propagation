package propagation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import propagation.entity.User;
import propagation.entity.UserRepository;

@Service
public class PropagationService {

    @Autowired
    private UserRepository userRepository;

    @Transactional(propagation = Propagation.REQUIRED)
    public User save(User user) {
        return userRepository.save(user);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public User saveNew(User user) {
        return userRepository.save(user);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public User saveNewWithExc(User user) {
        User userResult = userRepository.save(user);
        // System.out.println(1 / 0);
        return userResult;
    }

    public void delete(Long id) {
        userRepository.delete(id);
    }

    public Iterable<User> findAll() {
        return userRepository.findAll();
    }
}