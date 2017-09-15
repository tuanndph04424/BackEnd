package com.nguyentuan.api.logic;

import java.util.ArrayList;
import java.util.List;

import com.nguyentuan.api.data.GenericDao;
import com.nguyentuan.api.entity.RolesEntity;





public interface RolesDao extends GenericDao<Integer, RolesEntity> {
	List<RolesEntity> findAll();

}
