package dev.jamieisgeek.origins.Models;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.bukkit.entity.Player;

import java.sql.*;

public class Database {
    private final HikariDataSource dataSource;

    private final String address;
    private final String databaseName;
    private final String username;
    private final String password;
    private final String port;

    private static Database database = null;

    public Database(String address, String database, String username, String password, String port) {
        this.address = address;
        this.databaseName = database;
        this.username = username;
        this.password = password;
        this.port = port;

        this.dataSource = createDataSource();

        Database.database = this;

        createTable();
    }

    private HikariDataSource createDataSource() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(String.format("jdbc:mariadb://%s:%s/%s?autoReconnect=true&useSSL=false", address, port, databaseName));
        config.setUsername(username);
        config.setPassword(password);
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

        return new HikariDataSource(config);
    }

    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public static Database getDatabase() {
        return database;
    }

    public void closeConnection() throws SQLException {
        dataSource.close();
    }

    public void createTable() {
        try {
            Connection connection = this.getConnection();
            Statement statement = connection.createStatement();

            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `origins` (" +
                    "`uuid` VARCHAR(36) NOT NULL," +
                    "`origin` VARCHAR(16) NOT NULL," +
                    "PRIMARY KEY (`uuid`)" +
                    ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;");

            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addPlayerOrigin(Player player, String origin) {
        try {
            Connection connection = this.getConnection();
            PreparedStatement statement = connection.prepareStatement("INSERT INTO `origins` (`uuid`, `origin`) VALUES (?, ?) ON DUPLICATE KEY UPDATE `origin` = ?;");
            statement.setString(1, player.getUniqueId().toString());
            statement.setString(2, origin);
            statement.setString(3, origin);
            statement.executeUpdate();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean checkPlayerOrigin(Player player) {
        // Check if the player has an origin
        try {
            Connection connection = this.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM `origins` WHERE `uuid` = ?;");
            statement.setString(1, player.getUniqueId().toString());
            ResultSet resultSet = statement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}