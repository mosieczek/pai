/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adzia.dao;

import com.adzia.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface userDao extends CrudRepository<User, Integer> {
    public User findByLogin(String login);
}

