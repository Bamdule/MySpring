/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bamdule.dao.impl;

import com.bamdule.dao.GuestBookDao;
import com.bamdule.model.vo.GuestBookVO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author MW
 */
@Repository
public class GuestBookDaoImpl extends BaseDao implements GuestBookDao {

    private final String namespace = "guestbook";

    @Override
    public List<Map<String, Object>> list() {
        return getSqlSession().selectList(namespace + ".getList");
    }

}
