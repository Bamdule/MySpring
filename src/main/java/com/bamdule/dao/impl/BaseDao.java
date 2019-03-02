/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bamdule.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author MW
 */
public class BaseDao {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private SqlSession sqlSession;

    protected Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    protected SqlSession getSqlSession() {
        return sqlSession;
    }

}
