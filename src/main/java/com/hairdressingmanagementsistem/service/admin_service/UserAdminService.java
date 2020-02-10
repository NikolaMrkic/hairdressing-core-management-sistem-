package com.hairdressingmanagementsistem.service.admin_service;
import com.hairdressingmanagementsistem.model.User;
import java.util.Set;

/**
 * User Admin Service
 */

public interface UserAdminService {

    /**
     * Admin Service method for returning all users
     * @return
     * @throws Exception
     */
    Set<User> getAllUsers() throws Exception;

    /**
     * Admin Service method for returning specific user found her userId
     * @param id
     * @return
     * @throws Exception
     */
    User getUserById(Long id) throws Exception;

    /**
     * Admin Service method for add-ing new user to database
     * @param user
     * @return
     * @throws Exception
     */
    User addUser(User user) throws Exception;

    /**
     * Admin Service method for update-ing specific user found by his id
     * @param id
     * @param user
     * @return
     * @throws Exception
     */
    User updateUser(Long id, User user) throws Exception;

    /**
     * Admin Service method for hard deleting specific user found by his id
     * @param id
     * @return
     * @throws Exception
     */
    User hardDeleteUser(Long id) throws Exception;

    /**
     * Admin Service method for soft deleting specific user found by his id
     * @param id
     * @return
     */
    User softDeleteUser(Long id) throws Exception;

    /**
     * Admin Service method for returning all deleted users
     * @return
     */
    Set<User> getDeletedUsers() throws Exception;

    /**
     * Admin Service method for hard deleting all users that has deleted = true
     * @throws Exception
     */
    void hardDeleteAllUsers() throws Exception;

    /**
     * Admin Service method for updating deleted product to deleted = false
     * @param id
     * @return
     */
    User updateDeletedUser(Long id);
}
