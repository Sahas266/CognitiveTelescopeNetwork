package org.ccode.asset.ctn.image.rest.dao;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.ccode.asset.ctn.image.rest.models.CelestialBody;

public class CelestialBodyDAO {
	public List<CelestialBody> celestialBodyList = new ArrayList<CelestialBody>();
	public static Connection connection;

	public void connect() {
		connection = DatabaseSessionManager.getInstance().getSession();
	}

	public void displayClassPath() {
		String classpath = System.getProperty("java.class.path");
		String[] classpathEntries = classpath.split(File.pathSeparator);
		for (String path : classpathEntries) {
			System.out.println(path);
		}
	}

	public List<CelestialBody> readcelestialBodyList() {
		// Retrieve data from the database.
		connect();
		Statement statement;
		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM CelestialBody");
			// Iterate over the ResultSet and print the results.
			while (resultSet.next()) {
				CelestialBody event = new CelestialBody();
				event.setId(resultSet.getInt("ID"));
				event.setName(resultSet.getString("NAME"));
				event.setLocation(resultSet.getInt("LOCATION"));
				celestialBodyList.add(event);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return celestialBodyList;
	}

	public void addCelestialBody(String name, int location) {
		connect();
		Statement statement;
		String query = "INSERT INTO CelestialBody (name, location) values ('" + name + "', " + location + ")";
		System.out.println(query);
		try {
			statement = connection.createStatement();
			statement.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateCelestialBody(int id, int location) {
		connect();
		Statement statement;
		String query = "Update CelestialBody SET location = " + location + " where id = " + id;
		try {
			statement = connection.createStatement();
			statement.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteCelestialBody(int id) {
		connect();
		Statement statement;
		String query = "Delete from CelestialBody where id = " + id;
		try {
			statement = connection.createStatement();
			statement.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void printCelestialBodys(List<CelestialBody> celestialBodyList) {
		for (CelestialBody t : celestialBodyList) {
			System.out.println(" ID:" + t.getId() + "; Event:" + t.getName() + ";  Location:" + t.getLocation());
		}
	}

	public static void main(String[] args) {
		CelestialBodyDAO dao = new CelestialBodyDAO();
		dao.printCelestialBodys(dao.readcelestialBodyList());
		dao.updateCelestialBody(4, 5);
		dao.printCelestialBodys(dao.readcelestialBodyList());
		dao.deleteCelestialBody(6);
		dao.printCelestialBodys(dao.readcelestialBodyList());
		dao.addCelestialBody("Sun", 9);
		dao.printCelestialBodys(dao.readcelestialBodyList());
	}

}
