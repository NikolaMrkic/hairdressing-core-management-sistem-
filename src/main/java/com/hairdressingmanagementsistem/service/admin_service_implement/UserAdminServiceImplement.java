package com.hairdressingmanagementsistem.service.admin_service_implement;

import com.hairdressingmanagementsistem.model.User;
import com.hairdressingmanagementsistem.repository.admin_repository.UserAdminRepository;
import com.hairdressingmanagementsistem.service.admin_service.UserAdminService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.NoSuchElementException;
import java.util.Set;

/**
 * User Admin Service Implement
 */

@Service
public class UserAdminServiceImplement implements UserAdminService {

    private final org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private  UserAdminRepository userAdminRepository;

//    @Autowired
//    private UserAdminServiceImplement(UserAdminRepository userAdminRepository){
//        this.userAdminRepository = userAdminRepository;
//    }

    @Transactional
    @Override
    public Set<User> getAllUsers() throws Exception {
        try {
            Set<User> users = userAdminRepository.findAllByDeleted(false);
            logger.info("Collection of all available users returned -user view");
            return users;
        } catch (Exception e) {
            logger.error("Error returning all available users");
            throw e;
        }
    }

    @Transactional
    @Override
    public User getUserById(Long id) throws Exception {
        try {
            User user = userAdminRepository.findAllByIdAndDeleted(id, false);
            if (user == null) {
                logger.error("User with id: " + id + " dosen't exist.");
                return user;
            }
            logger.info("User successful returned with id: " + id);
            return user;
        } catch (NoSuchElementException nsee) {
            logger.error("User with id: " + id + " dosen't exist!");
            throw  nsee;
        } catch (Exception e) {
            logger.error("Error returning (admin) user with id:" + id);
            throw e;
        }
    }

    @Transactional
    @Override
    public User addUser(User user) throws Exception {
        try {
            user.setId(null);
            user.setRole(null);
            user.setAddress(null);
            user.setDeleted(false);

            User newUser = userAdminRepository.save(user);
            if(newUser != null){
                logger.debug("New User is successful created with id: " + user.getId());
                return newUser;
            } else {
                logger.debug("Error with saving new user: " + user.toString());
                throw new Exception("Error with saving new user: " + user.toString());
            }
        }catch (Exception e){
            logger.error("Error with creating user: " + user.toString());
            throw e;
        }
    }

    @Override
    public User updateUser(Long id, User user) throws Exception {
        return null;
    }

    @Override
    public User hardDeleteUser(Long id) throws Exception {
        return null;
    }

    @Override
    public User softDeleteUser(Long id) throws Exception {
        return null;
    }

    @Override
    public Set<User> getDeletedUsers() throws Exception {
        return null;
    }

    @Override
    public void hardDeleteAllUsers() throws Exception {

    }

    @Override
    public User updateDeletedUser(Long id) {
        return null;
    }
}
