package com.olvi.pmgt.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.olvi.pmgt.model.NameModel;

public enum Dao {
	INSTANCE;

	public List<NameModel> listNameModels() {
		EntityManager em = EMFService.get().createEntityManager();
		// read the existing entries
		Query q = em.createQuery("select m from NameModel m");
		List<NameModel> NameModels = q.getResultList();
		return NameModels;
	}

	public void add(String ip, String name) {
		synchronized (this) {
			EntityManager em = EMFService.get().createEntityManager();
			NameModel NameModel = new NameModel(ip,name);
			em.persist(NameModel);
			em.close();
		}
	}

	public List<NameModel> getNameModels() {
		EntityManager em = EMFService.get().createEntityManager();
		Query q = em
				.createQuery("select t from NameModel t");
		List<NameModel> NameModels = q.getResultList();
		return NameModels;
	}

	public void remove(long id) {
		EntityManager em = EMFService.get().createEntityManager();
		try {
			NameModel NameModel = em.find(NameModel.class, id);
			em.remove(NameModel);
		} finally {
			em.close();
		}
	}
}