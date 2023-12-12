package poly.dn.hyundai.Repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;

import poly.dn.hyundai.Entity.Account;

public interface AccountDao extends JpaRepository<Account, String> {
   @Query("SELECT DISTINCT ar.account from Authority ar Where ar.role.id IN ('DIRE','STAF')")
	List<Account> getAdministrators();

void save(UserDetails user);

Account findByEmail(String email);
	@Query("SELECT COUNT(a) FROM Account a")
	Long countUser();
	
	@Query("SELECT a FROM Account a Where a.fullname = ?1")
	List<Account> findByFullname(String name);
	
	@Query("SELECT a FROM Account a Where a.fullname = ?1")
	Page<Account> findByFullname(String name, Pageable pageable);
	
	@Query("SELECT a.username FROM Account a where a.username = ?1")
	String getUsername(String username);
	
	@Query("SELECT a FROM Account a Where a.username = ?1")
	List<Account> findByUsername(String name);
	
	@Query("SELECT a FROM Account a Where a.fullname = ?1")
	Page<Account> findByUsername(String name, Pageable pageable);

	
	@Query("SELECT a FROM Account a Where a.username = ?1")
	Account findByUsername1(String name);
}
