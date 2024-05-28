package com.sol.LitGuten;

import com.sol.LitGuten.principal.Main;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LitGutenApplication implements CommandLineRunner {

    private final Main main;

    public LitGutenApplication(Main main) {
        this.main = main;
    }

    public static void main(String[] args) {
        SpringApplication.run(LitGutenApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        main.showMenu();
    }
}
