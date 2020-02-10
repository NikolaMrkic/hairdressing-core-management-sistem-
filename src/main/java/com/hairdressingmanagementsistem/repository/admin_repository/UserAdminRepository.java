package com.hairdressingmanagementsistem.repository.admin_repository;
import com.hairdressingmanagementsistem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Set;

/**
 *  Hairdresser User Repository
 */
@Repository
@Transactional
public interface UserAdminRepository extends JpaRepository<User, Long> {

    /**
     * JpaRepository method for finding all users that has deleted set to false
     */
    Set<User> findAllByDeleted(Boolean deleted);

    /**
     *
     * @param id
     * @param deleted
     * @return
     */
    @Query(value = "Select * from hairdresser_user where id = ? and deleted = ? ", nativeQuery = true)
    User findAllByIdAndDeleted(Long id, boolean deleted);
}
