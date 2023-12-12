package poly.dn.hyundai.Repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import poly.dn.hyundai.Entity.Account;
import poly.dn.hyundai.Entity.Authority;

public interface AuthorityDao extends JpaRepository<Authority, Integer> {
     
	@Query("SELECT DISTINCT a from Authority a where a.account IN ?1")
	List<Authority> authoritiesOf(List<Account> accounts);

}
