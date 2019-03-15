package com.bamdule.dao.impl;

import com.bamdule.dao.GuestBookDao;
import java.util.List;
import java.util.Map;
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
