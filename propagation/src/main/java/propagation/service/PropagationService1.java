package propagation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import propagation.entity.User;
import propagation.entity.UserRepository;

@Service
public class PropagationService1 {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PropagationService2 propagationService2;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public User save(User user) {
        User resultUser = userRepository.save(user);
        user = new User();
        user.setName("aimee");
        user.setEmail("aimee@163.com");
        try {
            resultUser = propagationService2.save(resultUser);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultUser;
    }

    public void delete(Long id) {
        userRepository.delete(id);
    }

    public Iterable<User> findAll() {
        return userRepository.findAll();
    }
}