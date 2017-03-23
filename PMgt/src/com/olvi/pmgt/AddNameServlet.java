package com.olvi.pmgt;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.labs.repackaged.org.json.JSONException;
import com.google.appengine.labs.repackaged.org.json.JSONObject;
import com.olvi.pmgt.dao.Dao;
import com.olvi.pmgt.dao.NameEntityDao;
import com.olvi.pmgt.entity.NameEntity;

@SuppressWarnings("serial")
public class AddNameServlet extends HttpServlet {
	private static final String PARM_KEY_ID_NAME = "name";
	private final static Logger LOGGER = Logger.getLogger(AddNameServlet.class
			.getName());

	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {

		try {
			// get from query string
			String name = nullSafe(req.getParameter(PARM_KEY_ID_NAME));

			LOGGER.log(Level.INFO, "Creating new Name: " + name);
			// add to db via jpa
			Dao.INSTANCE.add(req.getRemoteHost(), name);

			// add to db directly - note id will auto assign from nosql
			NameEntityDao dDao = new NameEntityDao();
			dDao.createName(new NameEntity(req.getRemoteHost(), name, -1L));

			// build json
			JSONObject json = new JSONObject();
			json.put(PARM_KEY_ID_NAME, name);

			// return json
			resp.setContentType("application/json");
			resp.getWriter().write(json.toString());

		} catch (JSONException e) {
			LOGGER.log(Level.SEVERE, "Exception occurred while parsing json.",
					e);
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "General Exception occurred", e);
		}
	}

	private String nullSafe(String s) {
		if (s == null) {
			return "";
		}
		return s;
	}
}