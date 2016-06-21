package com.mingsoft.business.biz;

import java.util.List;

import com.mingsoft.basic.biz.IBasicBiz;
import com.mingsoft.business.entity.TuserEntity;
import com.mingsoft.util.PageUtil;

public interface ITuserBiz extends IBasicBiz {
	
	public int queryCountByCond(TuserEntity tuserEntity);
	public List<TuserEntity> queryByPage(PageUtil page,TuserEntity tuserEntity);
	public void saveEntity(TuserEntity tuserEntity);
	public void deleteEntity(int id);
	public TuserEntity getTuserEntity(int id);
	public void updateEntity(TuserEntity tuserEntity);

}
