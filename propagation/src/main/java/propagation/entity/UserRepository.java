package propagation.entity;

import org.springframework.data.repository.CrudRepository;

import propagation.User;

public interface UserRepository extends CrudRepository<User, Long> {

}