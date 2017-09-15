package com.nguyentuan.api.data;

import java.io.Serializable;
import java.util.List;

import org.hibernate.ObjectNotFoundException;
import org.springframework.dao.DuplicateKeyException;



public interface GenericDao<ID extends Serializable, T> {



	T update(T var1);

	T save(T var1);

	T findById(ID var1);

	Integer listDelete(List<ID> var1);

	Integer delete(ID var1);





}
