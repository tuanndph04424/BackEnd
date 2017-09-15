package com.nguyentuan.api.serverlogic;

import java.util.List;

import com.nguyentuan.api.data.GenericDao;
import com.nguyentuan.api.entity.RolesEntity;



public interface RolesServer extends GenericDao<Integer, RolesEntity> {
	List<RolesEntity> findAll();
}
