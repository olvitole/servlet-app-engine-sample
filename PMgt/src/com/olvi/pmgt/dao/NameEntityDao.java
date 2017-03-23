package com.olvi.pmgt.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.FilterOperator;
import com.olvi.pmgt.entity.NameEntity;

public class NameEntityDao extends BaseDAO {

	private static final String ENTITY_NAME = "NameEntity";

	public NameEntityDao() {
		super();
	}

	@Override
	public Key putEntity(Entity entity) {
		return super.putEntity(entity);
	}

	public static Entity make(Entity entity, NameEntity entry) {
		if (entry == null || entity == null) {
			return null;
		}
		entity.setProperty(NameEntity.IP, entry.getIp());
		entity.setProperty(NameEntity.NAME, entry.getName());
		return entity;
	}

	public static Entity make(NameEntity entry) {
		return make(new Entity(ENTITY_NAME), entry);
	}

	public static NameEntity make(Entity entity) {
		if (entity == null) {
			return null;
		}
		NameEntity entry = new NameEntity();
		entry.setIp((String) entity.getProperty(NameEntity.IP));
		entry.setName((String) entity.getProperty(NameEntity.NAME));
		return entry;
	}

	public Key createName(NameEntity nameEntity) {
		return putEntity(make(nameEntity));
	}

	public Iterable<Entity> listEntities() {
		return prepare(new Query(ENTITY_NAME)).asIterable();
	}

	public List<NameEntity> listNameModels() {
		List<NameEntity> list = new ArrayList<NameEntity>();

		for (Entity name : listEntities()) {
			NameEntity nameE = make(name);
			list.add(nameE);
		}
		return list;
	}

}
