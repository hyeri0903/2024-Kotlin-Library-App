package com.group.libraryapp.dto.user.response;

import com.group.libraryapp.domain.user.JavaUser;

public class UserResponse {

  private final long id;
  private final String name;
  private final Integer age;

  public UserResponse(JavaUser javaUser) {
    this.id = javaUser.getId();
    this.name = javaUser.getName();
    this.age = javaUser.getAge();
  }

  public long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public Integer getAge() {
    return age;
  }

}
