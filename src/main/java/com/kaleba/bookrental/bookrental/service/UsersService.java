package com.kaleba.bookrental.bookrental.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kaleba.bookrental.bookrental.dto.UsersDto;
import com.kaleba.bookrental.bookrental.model.Users;

@Service
public interface UsersService {
    List<Users> findAllUsers();

    List<UsersDto> findAllUsersDtos();

    Users saveUsers(UsersDto usersDto);

    UsersDto findUsersById(int idUser);

    void updateUser(UsersDto users);

    void deleteUser(int idUser);
}
