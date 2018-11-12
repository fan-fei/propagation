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
    public Boolean addUser(User userParam) {
        userRepository.save(userParam);

        try {
            User dbUser = new User();
            dbUser.setName("aimee");
            dbUser.setEmail("aimee@163.com");
            propagationService2.save(dbUser);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Boolean.TRUE;
    }

}