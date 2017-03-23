package com.olvi.pmgt.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.olvi.pmgt.model.NameModel;

public enum Dao {
	INSTANCE;


	public void add(String ip, String name) {
		synchronized (this) {
			EntityManager em = EMFService.get().createEntityManager();
			NameModel NameModel = new NameModel(ip,name);
			em.persist(NameModel);
			em.close();
		}
	}

	public List<NameModel> listNameModels() {
		EntityManager em = EMFService.get().createEntityManager();
		Query q = em
				.createQuery("select t from NameModel t");
		List<NameModel> NameModels = q.getResultList();
		return NameModels;
	}

}