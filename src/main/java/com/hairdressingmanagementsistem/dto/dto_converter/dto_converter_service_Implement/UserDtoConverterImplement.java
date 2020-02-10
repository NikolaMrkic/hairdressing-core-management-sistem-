package com.hairdressingmanagementsistem.dto.dto_converter.dto_converter_service_Implement;

import com.hairdressingmanagementsistem.dto.dto_converter.dto_converter_service.UserDtoConverter;
import com.hairdressingmanagementsistem.dto.dto_model.UserDto;
import com.hairdressingmanagementsistem.model.User;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.stereotype.Service;

@Service
@Data
public class UserDtoConverterImplement implements UserDtoConverter {

    private final org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());

    private final ModelMapper modelMapper;

    /**
     * @param modelMapper
     */
    @Autowired
    public UserDtoConverterImplement(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }


    public UserDto convertToDto(User user) throws Exception{
        try{
            UserDto userDto = modelMapper.map(user, UserDto.class);
            logger.debug("Convert to data transfer object successfully converted user object.");
            return userDto;
        }catch (ParseException pe){
            logger.error("Exception parsing data transfer object to user object - parse exception.");
            throw pe;
        }catch (Exception e){
            logger.error("Error converting data transfer object to user object - exception.");
            throw e;
        }
    }

    public User convertToEntity(UserDto userDto) throws Exception {
        try{
            User user = modelMapper.map(userDto, User.class);
            logger.debug("Convertion from data transfer object to user object successfully finished.");
            return user;
        }catch (ParseException pe){
            logger.error("Exception parsing user object to data transfer object - parse exception.");
            throw pe;
        }catch (Exception e){
            logger.error("Error converting user object to data transfer object - exception.");
            throw e;
        }
    }
}