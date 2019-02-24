package com.bamdule.dao;

import com.bamdule.model.vo.GuestBookVO;
import java.util.List;

/**
 *
 * @author MW
 */
public interface GuestBookDao {

    List<GuestBookVO> getList();

    public boolean insert(GuestBookVO vo);

    public String getPwd(int no);

    public String getInputPwd(String pwd);

    public boolean delete(int no);
}
