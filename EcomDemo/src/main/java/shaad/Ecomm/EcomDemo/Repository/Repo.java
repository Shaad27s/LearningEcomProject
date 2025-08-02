package shaad.Ecomm.EcomDemo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import shaad.Ecomm.EcomDemo.Module.PrdCar;

import java.util.List;

@Repository
public interface Repo extends JpaRepository<PrdCar,Integer> {

      @Query("Select p from PrdCar p WHERE " +
      " LOWER(p.name) like LOWER(CONCAT('%', :keyword ,'%')) OR " +
      " LOWER(p. description) like LOWER(CONCAT('%' ,:keyword ,'%')) OR " +
      " LOWER(p.brand) like LOWER(CONCAT('%', :keyword , '%'))")

      List<PrdCar> SearchBYBrand(String keyword);
       boolean existsByName(String name);


}
