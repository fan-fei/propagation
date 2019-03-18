package propagation;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import propagation.entity.Department;
import propagation.entity.Employee;

@Service
public class OneToManyService {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Boolean addDepartment() {

        Department d1 = new Department();
        d1.setDepName("研发部");

        // 创建两个员工对象
        Employee e1 = new Employee();
        e1.setEmpName("张三");
        e1.setPhone("13111111111");
        Employee e2 = new Employee();
        e2.setEmpName("李四");
        e2.setPhone("18523222222");

        // 设置对象关联
        d1.getEmployees().add(e1);
        d1.getEmployees().add(e2);
        
        e1.setDepartment(d1);
        e2.setDepartment(d1);
        
        entityManager.persist(d1);
        entityManager.persist(e1);
        entityManager.persist(e2);

        return Boolean.TRUE;
    }

}