package pte.mik.habitstatsserver.service;

import lombok.AllArgsConstructor;
import org.apache.catalina.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import pte.mik.habitstatsserver.dto.UserDto;
import pte.mik.habitstatsserver.entity.User;
import pte.mik.habitstatsserver.repository.UserRepository;

import javax.swing.text.html.parser.Entity;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> listAllUser(){
        return userRepository.findAll();
    }

    public Optional<User> findUserById(Integer id){
        return userRepository.findById(id);
    }

    public void createUser(UserDto userDto){
        User user = new ModelMapper().map(userDto,User.class);
        userRepository.save(user);
    }

    public void deleteUser(UserDto userDto){
        userRepository.deleteById(userDto.getId());
    }

}
