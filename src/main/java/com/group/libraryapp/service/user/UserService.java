package com.group.libraryapp.service.user;

import com.group.libraryapp.domain.user.JavaUser;
import com.group.libraryapp.domain.user.UserRepository;
import com.group.libraryapp.dto.user.request.UserCreateRequest;
import com.group.libraryapp.dto.user.request.UserUpdateRequest;
import com.group.libraryapp.dto.user.response.UserResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

  private final UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Transactional
  public void saveUser(UserCreateRequest request) {
    JavaUser newJavaUser = new JavaUser(request.getName(), request.getAge());
    userRepository.save(newJavaUser);
  }

  @Transactional(readOnly = true)
  public List<UserResponse> getUsers() {
    return userRepository.findAll().stream()
        .map(UserResponse::new)
        .collect(Collectors.toList());
  }

  @Transactional
  public void updateUserName(UserUpdateRequest request) {
    JavaUser javaUser = userRepository.findById(request.getId()).orElseThrow(IllegalArgumentException::new);
    javaUser.updateName(request.getName());
  }

  @Transactional
  public void deleteUser(String name) {
    JavaUser javaUser = userRepository.findByName(name).orElseThrow(IllegalArgumentException::new);
    userRepository.delete(javaUser);
  }

}
