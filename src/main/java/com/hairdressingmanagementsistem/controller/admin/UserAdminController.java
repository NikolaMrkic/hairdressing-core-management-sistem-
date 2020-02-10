package com.hairdressingmanagementsistem.controller.admin;


import com.fasterxml.jackson.annotation.JsonView;
import com.hairdressingmanagementsistem.configuration.View;
import com.hairdressingmanagementsistem.dto.dto_fasade.dto_admin_fasade.UserAdminFasade;
import com.hairdressingmanagementsistem.dto.dto_model.UserDto;
import com.hairdressingmanagementsistem.service.admin_service.UserAdminService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.validation.Valid;
import java.util.Set;


/**
 * Admin User Controller
 */
@Controller
@RequestMapping(value = "/admin")
public class UserAdminController {

    private final org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());

    private final UserAdminService userAdminService;

    private final UserAdminFasade userAdminFasade;

    /**
     * @param userAdminService
     * @param userAdminFasade
     */
    @Autowired
    public UserAdminController(UserAdminService userAdminService, UserAdminFasade userAdminFasade) {
        this.userAdminService = userAdminService;
        this.userAdminFasade = userAdminFasade;
    }

    /**
     * Post User admin method
     */
    @JsonView(View.AdminView.class)
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public ResponseEntity<UserDto> addUser(@Valid @RequestBody UserDto userDto) throws  Exception {
        logger.info("Admin add User request: user details " + userDto.toString());
        if (userDto == null){
            logger.error("Admin add User bad request");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        try {
            UserDto responseUser = userAdminFasade.addUser(userDto);
            logger.debug("Admin add User request: user details " + userDto.toString());
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            logger.error("Admin add User bad request exception");
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Get User admin method that returning by id
     */
    @JsonView(View.AdminView.class)
    @RequestMapping(value = "user/{id}", method = RequestMethod.GET)
    public ResponseEntity<UserDto> getUserById(@PathVariable("id")Long id){
        logger.info("Get admin User request: user details {}" + id);
        try {
            UserDto responseUser = userAdminFasade.getUserById(id);
            if (responseUser == null || responseUser.getId() == null){
                logger.error("User >> with id: " + id + " not found.");
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            } else {
                logger.debug("User >> with id: "+ id +" is found.");
                return new ResponseEntity<>(responseUser, HttpStatus.OK);
            }
        } catch (Exception e){
            logger.error("Get admin user >> bad request exception");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * GET all User-s admin method
     */
    @JsonView(View.AdminView.class)
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ResponseEntity<Set<UserDto>> getAllUsers() throws Exception{
        logger.info("Recieved get admin users collection request");
        try{
            Set<UserDto> users = userAdminFasade.getAllUsers();
            logger.debug("Get users - Successfully returned collection of users to controller, users: " + users.toString());
            return new ResponseEntity<>(users, HttpStatus.OK);
        }catch (Exception e){
            logger.error("Get Users collection bad request exception");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
