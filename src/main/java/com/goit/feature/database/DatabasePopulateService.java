package com.goit.feature.database;

import com.goit.feature.utils.WorkerLevel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class DatabasePopulateService {
    private static PreparedStatement insertStWorker;
    private static PreparedStatement insertStClient;
    private static PreparedStatement insertStProject;
    private static PreparedStatement insertStProjectWorker;

    public static boolean createWorker(String name, LocalDate birthday, WorkerLevel level, int salary) {
        try {
            insertStWorker.setString(1, name);
            insertStWorker.setString(2, birthday.toString());
            insertStWorker.setString(3, level.name());
            insertStWorker.setInt(4, salary);
            return insertStWorker.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean createClient(String name) {
        try {
            insertStClient.setString(1, name);
            return insertStClient.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean createProject(int client_id, LocalDate start_date, LocalDate finish_date) {
        try {
            insertStProject.setInt(1, client_id);
            insertStProject.setString(2, start_date.toString());
            insertStProject.setString(3, finish_date.toString());
            return insertStProject.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean createProjectWorker(int project_id, int worker_id) {
        try {
            insertStProjectWorker.setInt(1, project_id);
            insertStProjectWorker.setInt(2, worker_id);

            return insertStProjectWorker.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) throws SQLException {
        String sqlWorker = "INSERT INTO worker (name, birthday, level, salary) VALUES(?, ?, ?, ?)";
        String sqlClient = "INSERT INTO client (name) VALUES(?)";
        String sqlProject = "INSERT INTO project (client_id, start_date, finish_date) VALUES(?, ?, ?)";
        String sqlProjectWorker = "INSERT INTO project_worker (project_id, worker_id) VALUES(?, ?)";

        Database database = Database.getInstance();

        Connection connection = database.getConnection();
        insertStWorker = connection.prepareStatement(sqlWorker);
        insertStClient = connection.prepareStatement(sqlClient);
        insertStProject = connection.prepareStatement(sqlProject);
        insertStProjectWorker = connection.prepareStatement(sqlProjectWorker);
        createWorker("John Monnet", LocalDate.parse("1988-04-19"), WorkerLevel.Middle, 4200);
        createWorker("Sam Paganini", LocalDate.parse("1980-05-11"), WorkerLevel.Senior, 10000);
        createWorker("Bob Smith", LocalDate.parse("1991-03-12"), WorkerLevel.Trainee, 900);
        createWorker("Stiv Fleming", LocalDate.parse("1994-02-01"), WorkerLevel.Junior, 1200);
        createWorker("Alex Mcdonald", LocalDate.parse("1991-06-24"), WorkerLevel.Middle, 2900);
        createWorker("Petro Kudriaviy", LocalDate.parse("1985-11-11"), WorkerLevel.Middle, 3000);
        createWorker("Viktor Zaveriuha", LocalDate.parse("1999-09-29"), WorkerLevel.Middle, 3900);
        createWorker("Vladimir Nogin", LocalDate.parse("1986-07-07"), WorkerLevel.Junior, 1100);
        createWorker("Richie Hawtin", LocalDate.parse("1983-10-14"), WorkerLevel.Junior, 1900);
        createWorker("Nikita Truschev", LocalDate.parse("2001-08-11"), WorkerLevel.Senior, 8000);
        createWorker("Ivan Korg", LocalDate.parse("1997-02-24"), WorkerLevel.Trainee, 800);
        createWorker("Sergey Belokon", LocalDate.parse("1987-12-31"), WorkerLevel.Senior, 8200);

        createClient("Greg");
        createClient("Roman");
        createClient("Cristofer");
        createClient("Bohdan");
        createClient("Danyl");
        createClient("Martin");

        createProject(6, LocalDate.parse("2022-07-13"), LocalDate.parse("2022-12-24"));
        createProject(4, LocalDate.parse("2009-09-15"), LocalDate.parse("2010-01-04"));
        createProject(4, LocalDate.parse("2015-04-29"), LocalDate.parse("2017-11-11"));
        createProject(3, LocalDate.parse("2005-03-02"), LocalDate.parse("2005-07-19"));
        createProject(5, LocalDate.parse("1996-05-01"), LocalDate.parse("1999-08-01"));
        createProject(2, LocalDate.parse("1999-10-27"), LocalDate.parse("2000-10-27"));
        createProject(1, LocalDate.parse("2002-02-07"), LocalDate.parse("2010-02-07"));
        createProject(5, LocalDate.parse("2016-12-15"), LocalDate.parse("2019-08-04"));
        createProject(2, LocalDate.parse("1998-12-25"), LocalDate.parse("2004-03-25"));
        createProject(6, LocalDate.parse("2000-04-19"), LocalDate.parse("2000-05-20"));
        createProject(3, LocalDate.parse("2003-08-30"), LocalDate.parse("2004-09-01"));

        createProjectWorker(1, 6);
        createProjectWorker(1, 9);
        createProjectWorker(1, 10);
        createProjectWorker(2, 3);
        createProjectWorker(2, 5);
        createProjectWorker(2, 7);
        createProjectWorker(2, 6);
        createProjectWorker(3, 1);
        createProjectWorker(3, 2);
        createProjectWorker(4, 1);
        createProjectWorker(4, 4);
        createProjectWorker(4, 3);
        createProjectWorker(4, 8);
        createProjectWorker(4, 11);
        createProjectWorker(5, 2);
        createProjectWorker(5, 5);
        createProjectWorker(6, 1);
        createProjectWorker(6, 4);
        createProjectWorker(6, 9);
        createProjectWorker(7, 12);
        createProjectWorker(8, 7);
        createProjectWorker(8, 9);
        createProjectWorker(8, 5);
        createProjectWorker(8, 1);
        createProjectWorker(8, 2);
        createProjectWorker(9, 6);
        createProjectWorker(9, 7);
        createProjectWorker(9, 8);
        createProjectWorker(9, 9);
        createProjectWorker(10, 12);
        createProjectWorker(11, 7);
        createProjectWorker(11, 8);
        createProjectWorker(11, 4);
    }
}