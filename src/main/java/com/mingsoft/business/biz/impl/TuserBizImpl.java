package com.mingsoft.business.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mingsoft.basic.biz.impl.BasicBizImpl;
import com.mingsoft.business.biz.ITuserBiz;
import com.mingsoft.business.dao.ITuserDao;
import com.mingsoft.business.entity.TuserEntity;
import com.mingsoft.util.PageUtil;
@Service("TuserBizImpl")
public class TuserBizImpl extends BasicBizImpl implements ITuserBiz {
	@Autowired
	private ITuserDao iTuserDao;
	@Override
	public int queryCountByCond(TuserEntity tuserEntity) {
		if (tuserEntity==null) {
			tuserEntity = new TuserEntity();
		}
		return this.iTuserDao.queryCountByCond(tuserEntity);
	}

	@Override
	public List<TuserEntity> queryByPage(PageUtil page,TuserEntity tuserEntity) {
		if (tuserEntity!=null) {
			tuserEntity.setPage(page);
			tuserEntity.setOrder(false);
			tuserEntity.setOrderBy("CREATE_TIME");
		}
		return this.iTuserDao.queryByPage(tuserEntity);
	}

	@Override
	public void saveEntity(TuserEntity tuserEntity) {
		if (tuserEntity.getId()==0) {
			this.iTuserDao.saveEntity(tuserEntity);
		}else {
			this.iTuserDao.updateEntity(tuserEntity);
		}
		
	}

	@Override
	public TuserEntity getTuserEntity(int id) {
		return this.iTuserDao.getTuserEntity(id);
	}

	@Override
	public void updateEntity(TuserEntity tuserEntity) {
		this.iTuserDao.updateEntity(tuserEntity);
	}

}
