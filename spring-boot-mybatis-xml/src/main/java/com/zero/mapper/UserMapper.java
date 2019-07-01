package com.zero.mapper;

import com.zero.model.User;
import com.zero.param.UserParam;

import java.util.List;


public interface UserMapper {

	List<User> getAll();

	List<User> getList(UserParam userParam);

	int getCount(UserParam userParam);

	User getOne(Long id);

	void insert(User user);

	int update(User user);

	int delete(Long id);

}