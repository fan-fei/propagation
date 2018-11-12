package propagation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import propagation.entity.User;
import propagation.entity.UserRepository;

@Service
public class PropagationService2 {

    @Autowired
    private UserRepository userRepository;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Boolean save(User user) {
        userRepository.save(user);
        System.out.println(1 / 0);
        return Boolean.TRUE;
    }

}