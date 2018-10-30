package propagation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }

//    |ANNOTATION-----------------|TRANSACTION EXISTS-------------------|NONE EXISTS------------------|
//    |---------------------------|-------------------------------------|-----------------------------|
//    |PROPAGATION_REQUIRED-------|SUPPORT------------------------------|CREATE-----------------------|
//    |PROPAGATION_SUPPORTS-------|SUPPORT------------------------------|EXECUTE NON-TRANSACTIONALLY--|
//    |PROPAGATION_MANDATORY------|SUPPORT------------------------------|THROW AN EXCEPTION-----------|
//    |PROPAGATION_REQUIRES_NEW---|SUSPEND------------------------------|CREATE-----------------------|
//    |PROPAGATION_NOT_SUPPORTED--|SUSPEND------------------------------|EXECUTE NON-TRANSACTIONALLY--|
//    |PROPAGATION_NEVER----------|THROW AN EXCEPTION-------------------|EXECUTE NON-TRANSACTIONALLY--|
//    |PROPAGATION_NESTED---------|EXECUTE WITHIN A NESTED TRANSACTION--|CREATE-----------------------|
//    |---------------------------|-------------------------------------|-----------------------------|

}
