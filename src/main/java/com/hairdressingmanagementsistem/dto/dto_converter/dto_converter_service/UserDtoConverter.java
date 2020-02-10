package com.hairdressingmanagementsistem.dto.dto_converter.dto_converter_service;

import com.hairdressingmanagementsistem.dto.dto_model.UserDto;
import com.hairdressingmanagementsistem.model.User;
import org.springframework.context.annotation.ComponentScan;

/**
 * User Data transfer object service
 */



public interface UserDtoConverter {

    /**
     * Method for converting entity object to data transfer object
     * @param user
     * @return
     * @throws Exception
     */
    UserDto convertToDto(User user) throws Exception;

    /**
     * Method for converting data transfer object to entity object
     * @param userDto
     * @return
     * @throws Exception
     */
    User convertToEntity(UserDto userDto) throws Exception;
}
