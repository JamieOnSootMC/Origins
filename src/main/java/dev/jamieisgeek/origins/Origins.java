package dev.jamieisgeek.origins;

import dev.jamieisgeek.origins.Models.Database;
import org.bukkit.plugin.java.JavaPlugin;

import java.sql.SQLException;

public final class Origins extends JavaPlugin {

    private Database database;

    @Override
    public void onEnable() {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            getLogger().info("MariaDB driver loaded");
        } catch (ClassNotFoundException e) {
            getLogger().severe("MariaDB driver not found");
            getServer().getPluginManager().disablePlugin(this);
            throw new RuntimeException(e);
        }

        this.database = new Database(
            getConfig().getString("database.address"),
            getConfig().getString("database.database"),
            getConfig().getString("database.username"),
            getConfig().getString("database.password"),
            getConfig().getString("database.port")
        );
    }

    @Override
    public void onDisable() {
        try {
            database.getConnection().close();
            getLogger().info("Database connection closed");
        } catch (SQLException e) {
            getLogger().severe("Failed to close database connection");
            throw new RuntimeException(e);
        }
    }
}
