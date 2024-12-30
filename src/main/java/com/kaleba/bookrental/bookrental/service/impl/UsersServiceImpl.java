package com.kaleba.bookrental.bookrental.service.impl;

import org.springframework.stereotype.Service;

import com.kaleba.bookrental.bookrental.dto.UsersDto;
import com.kaleba.bookrental.bookrental.model.Users;
import com.kaleba.bookrental.bookrental.repository.UsersRepository;
import com.kaleba.bookrental.bookrental.service.UsersService;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsersServiceImpl implements UsersService {
    private UsersRepository usersRepository;

    public UsersServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public List<Users> findAllUsers() {
        List<Users> users = usersRepository.findAll();
        return users;
    }

    @Override
    public List<UsersDto> findAllUsersDtos() {
        List<Users> users = usersRepository.findAll();
        return users.stream().map(user -> mapToUsersDto(user)).collect(Collectors.toList());
    }

    private UsersDto mapToUsersDto(Users user) {
        UsersDto usersDto = new UsersDto();

        usersDto.setIdUser(user.getIdUser());
        usersDto.setUsername(user.getUsername());
        usersDto.setPassword(user.getPassword());

        return usersDto;
    }

    @Override
    public Users saveUsers(UsersDto usersDto) {
        Users user = mapToUsers(usersDto);
        return usersRepository.save(user);
    }

    private Users mapToUsers(UsersDto usersDto) {
        Users user = new Users();

        user.setIdUser(usersDto.getIdUser());
        user.setUsername(usersDto.getUsername());
        user.setPassword(usersDto.getPassword());

        return user;
    }

    @Override 
    public UsersDto findUsersById(int idUser) {
        Users user = usersRepository.findById(idUser).get();
        return mapToUsersDto(user);
    }

    @Override
    public void updateUser(UsersDto usersDto) {
        Users user = mapToUsers(usersDto);
        usersRepository.save(user);
    }

    @Override  
    public void deleteUser(int idUser) {
        usersRepository.deleteById(idUser);
    }

}
