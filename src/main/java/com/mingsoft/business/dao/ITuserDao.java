package com.mingsoft.business.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mingsoft.base.dao.IBaseDao;
import com.mingsoft.business.entity.TuserEntity;

public interface ITuserDao extends IBaseDao {
	public int queryCountByCond(TuserEntity tuserEntity);
	public List<TuserEntity> queryByPage(TuserEntity tuserEntity);
	public void saveEntity(TuserEntity tuserEntity);
	public void deleteEntity(@Param("id")int id);
	public TuserEntity getTuserEntity(@Param("id")int id);
	public void updateEntity(TuserEntity tuserEntity);
}
