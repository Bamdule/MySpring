package com.bamdule.service.impl;

import com.bamdule.dao.GuestBookDao;
import com.bamdule.model.vo.GuestBookVO;
import com.bamdule.service.GuestBookService;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author MW
 */
@Service
public class GuestBookServiceImpl implements GuestBookService {

    @Autowired
    private GuestBookDao guestBookDao;

    @Override
    public void insert(GuestBookVO vo) {
        guestBookDao.insert(vo);
    }

    @Override
    public List<GuestBookVO> list() {
        return guestBookDao.getList();
    }

}
