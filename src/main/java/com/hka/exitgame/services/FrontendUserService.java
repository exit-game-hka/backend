package com.hka.exitgame.services;

import com.hka.exitgame.dto.FrontendUserDto;
import com.hka.exitgame.entities.FrontendUser;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
@AllArgsConstructor
public class FrontendUserService {

    private final JdbcTemplate jdbcTemplate;

    public String getPasswordHash(final String username) {
        String sql = "SELECT * FROM public.frontend_user WHERE username='" + username + "'";
        List<FrontendUser> userFromDbList = jdbcTemplate.query(
                sql,
                (rs, c) -> {
                    log.info("Result set: {}", rs);
                    return FrontendUser.builder()
                            .id(UUID.fromString(rs.getString("id")))
                            .username(rs.getString("username"))
                            .password(rs.getString("password"))
                            .build();
                }
        );
        return userFromDbList.get(0).getPassword();
    }

    public void updatePassword(final FrontendUserDto frontendUserDto) {
        String sql = "UPDATE public.frontend_user SET password=? WHERE username=?";
        int result = jdbcTemplate.update(sql, frontendUserDto.password(), frontendUserDto.username());
        if (result > 0) {
            log.info("Password successfully updated.");
        }
    }
}
