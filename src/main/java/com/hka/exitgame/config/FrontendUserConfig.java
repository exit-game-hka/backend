package com.hka.exitgame.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
@Slf4j
public class FrontendUserConfig implements CommandLineRunner {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    UUID id = UUID.randomUUID();
    String username = "frontend_user";
    String password = "exitiwihka";

    @Override
    public void run(String... args) throws Exception {
        createTable();
        if (checkFrontendUserExists()) return;
        initializeFrontendUser();
    }

    public void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS public.frontend_user (" +
                "id UUID NOT NULL PRIMARY KEY, " +
                "username VARCHAR(255) UNIQUE NOT NULL, " +
                "password VARCHAR NOT NULL)";

        jdbcTemplate.execute(sql);
        log.info("Table created successfully");
    }

    public boolean checkFrontendUserExists() {
        String sql = "SELECT COUNT(*) FROM public.frontend_user;";
        Optional<Integer> count = Optional.ofNullable(jdbcTemplate.queryForObject(sql, Integer.class));

        return count.filter(integer -> integer > 0).isPresent();
    }

    public void initializeFrontendUser() {
        String sql = "INSERT INTO public.frontend_user (id, username, password) VALUES (?, ?, ?)";

        int result = jdbcTemplate.update(sql, id, username, password);

        if (result > 0) {
            log.info("A new row has been inserted: Frontend user successfully initialized");
        }
    }
}
