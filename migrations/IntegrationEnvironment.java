import org.springframework.util.FileSystemUtils;
import org.testcontainers.containers.PostgreSQLContainer;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class IntegrationEnvironment {

    private static final String CHANGELOG_FILE = "/liquibase/changelog/master.xml";

    private static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>();

    public static void startContainers() {
        postgres.start();
        runLiquibaseMigrations();
    }

    public static void stopContainers() {
        postgres.stop();
    }

    private static void runLiquibaseMigrations() {
        try {
            String jdbcUrl = postgres.getJdbcUrl();
            String username = postgres.getUsername();
            String password = postgres.getPassword();

            try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
                String changelogPath = new File(".").toPath().resolve(CHANGELOG_FILE).toAbsolutePath().toString();
                Liquibase liquibase = new Liquibase(changelogPath, new ClassLoaderResourceAccessor(), new JdbcConnection(connection));
                liquibase.update("");
            }
        } catch (SQLException | LiquibaseException e) {
            e.printStackTrace();
        }
    }



}
