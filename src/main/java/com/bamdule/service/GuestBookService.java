package com.bamdule.service;

import com.bamdule.model.vo.GuestBookVO;
import java.util.List;

/**
 *
 * @author MW
 */
public interface GuestBookService {

    void insert(GuestBookVO vo);
    
    List<GuestBookVO> list();

}
