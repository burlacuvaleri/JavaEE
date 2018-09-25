/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iucosoft.minisite.dao;

import com.iucosoft.minisite.entitati.MyUser;
import java.sql.SQLException;

/**
 *
 * @author iucosoft7
 */
public interface LoginDaoIntf {

    MyUser getUserByNameAndPassword(String username, String password) throws SQLException;

}
