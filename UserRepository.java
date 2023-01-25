package com.example.democlass.dao;
import org.springframework.data.repository.CrudRepository;
import com.example.democlass.dto.User;

public interface UserRepository extends CrudRepository<User,Integer> {

}
