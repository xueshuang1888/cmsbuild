package com.mingsoft.cms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mingsoft.base.dao.IBaseDao;
import com.mingsoft.cms.entity.ReservationEntity;

public interface IReservationDao extends IBaseDao {

	public int queryCountByCond(ReservationEntity reservationEntity);
	//public List<ReservationEntity> queryByPage(PageUtil page, @Param("orderBy")String orderBy, @Param("order")boolean order,ReservationEntity reservationEntity);
	public List<ReservationEntity> queryByPage(ReservationEntity reservationEntity);
	
	public void saveEntity(ReservationEntity reservationEntity);
	public void deleteEntity(@Param("id")int id);
	public ReservationEntity getReservationEntity(@Param("id")int id);
	public void updateEntity(ReservationEntity reservationEntity);
	
	
}
