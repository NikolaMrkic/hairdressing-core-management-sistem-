package com.hairdressingmanagementsistem.dto.dto_fasade.dto_admin_fasade;

import com.hairdressingmanagementsistem.dto.dto_converter.dto_converter_service.UserDtoConverter;
import com.hairdressingmanagementsistem.dto.dto_model.UserDto;
import com.hairdressingmanagementsistem.model.User;
import com.hairdressingmanagementsistem.service.admin_service.UserAdminService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * User Facade class - based on Facade design pattern, which is called by controller and he calls service bean and DTO converter
 * (Dispatcher class between controller and service, using DTO converter to convert objects and forward them)
 */
@Service
public class UserAdminFasade {

    private final org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());
    private final UserAdminService userAdminService;
    private final UserDtoConverter userDtoConverter;

    /**
     * @param userAdminService
     * @param userDtoConverter
     */
    @Autowired
    public UserAdminFasade(UserAdminService userAdminService, UserDtoConverter userDtoConverter) {
        this.userAdminService = userAdminService;
        this.userDtoConverter = userDtoConverter;
    }

    /**
     * Add user facade method which first convert DTO user to Entity user and sends it to service to create user and then
     * when user is created it converts him in DTO and return him to controller to be sent in ResponseEntity
     * @param userDto
     * @return
     */
    public UserDto addUser(UserDto userDto) throws Exception {
        User createdUser = userAdminService.addUser(userDtoConverter.convertToEntity(userDto));
        UserDto responseDtoUser = userDtoConverter.convertToDto(createdUser);
        return responseDtoUser;
    }

    /**
     * Get all users facade method for returning all users from database and then converting them all in collection of DTO
     * user objects to be returned to controller
     * @return
     * @throws Exception
     */
    public Set<UserDto> getAllUsers() throws Exception{
        Set<User> users = userAdminService.getAllUsers();
        logger.debug("Users collection returned to UserAdminFacade.");
        Set<UserDto> usersDto = users.stream()
                .map(user -> {
                    try {
                        return userDtoConverter.convertToDto(user);
                    } catch (Exception e) {
                        e.printStackTrace();
                        return null;
                    }
                }).collect(Collectors.toSet());
        logger.debug("Users collection successfully converted to data transfer object and returned to user controller. UsersDto: " + usersDto.toString());
        return usersDto;
    }


    public UserDto getUserById(Long id) throws Exception {
        User user = userAdminService.getUserById(id);
        if (user != null){
            return userDtoConverter.convertToDto(user);
        } else {
            return null;
        }
    }
}
