package com.bamdule.dao;

import com.bamdule.model.vo.GuestBookVO;
import java.util.List;
import java.util.Map;

/**
 *
 * @author MW
 */
public interface GuestBookDao {

    List<Map<String,Object>> list();
}
