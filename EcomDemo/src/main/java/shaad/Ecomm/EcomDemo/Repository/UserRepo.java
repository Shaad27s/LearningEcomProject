package shaad.Ecomm.EcomDemo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shaad.Ecomm.EcomDemo.Module.User;

import java.util.Optional;

@Repository
public interface UserRepo  extends JpaRepository<User,Long> {
    Optional<User> findByName(String name);

}
