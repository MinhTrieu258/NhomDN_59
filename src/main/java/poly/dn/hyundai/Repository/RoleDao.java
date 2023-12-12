package poly.dn.hyundai.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import poly.dn.hyundai.Entity.Role;

public interface RoleDao extends JpaRepository<Role, String> {

}
