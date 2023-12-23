package com.example.taskmanager.repo;

import com.example.taskmanager.domain.Tasks;
import com.example.taskmanager.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, String> {


}
