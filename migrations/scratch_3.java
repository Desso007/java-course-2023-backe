import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Testcontainers
public class IntegrationEnvironment {

    private static final String CHANGELOG_FILE = "master.xml";

    @Container
    public static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>();

    public static void startMigration() {
        try {
            String jdbcUrl = postgres.getJdbcUrl();
            String username = postgres.getUsername();
            String password = postgres.getPassword();

            Path migrationsDir = Paths.get(".", "migrations");
            Path changelogPath = migrationsDir.resolve(CHANGELOG_FILE);

            String liquibaseCommand = String.format("liquibase --changeLogFile=%s --url=%s --username=%s --password=%s update",
                changelogPath, jdbcUrl, username, password);

            ProcessBuilder processBuilder = new ProcessBuilder();
            processBuilder.command("bash", "-c", liquibaseCommand);
            processBuilder.directory(migrationsDir.toFile());

            Process process = processBuilder.start();
            int exitCode = process.waitFor();

            if (exitCode != 0) {
                throw new RuntimeException("Liquibase migration failed");
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

