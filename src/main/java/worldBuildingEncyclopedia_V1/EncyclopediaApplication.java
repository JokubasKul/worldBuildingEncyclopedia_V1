package worldBuildingEncyclopedia_V1;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import worldBuildingEncyclopedia_V1.database_operations.DatabaseMigration;

@SpringBootApplication
public class EncyclopediaApplication implements CommandLineRunner {

    private final DatabaseMigration databaseMigration;

    public EncyclopediaApplication(DatabaseMigration databaseMigration){
        this.databaseMigration=databaseMigration;
    }

    public static void main(String[] args) {
        SpringApplication.run(EncyclopediaApplication.class, args);
        System.out.println("Application running http://localhost:8090");
    }

    @Override
    public void run(String... args) {
        databaseMigration.migrate();
    }
}