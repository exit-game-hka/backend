package com.hka.exitgame.controllers;

import com.hka.exitgame.dto.FrontendUserDto;
import com.hka.exitgame.entities.FrontendUser;
import com.hka.exitgame.services.FrontendUserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping(ApiRoute.FRONTEND_USER_ROUTE)
@Slf4j
@Tag(name = "FrontendUser", description = "APIs zur Verwaltung von FrontendUsern")
public class FrontendUserController {

    private final FrontendUserService frontendUserService;

    @PutMapping
    void update(@RequestBody final FrontendUserDto frontendUserDto) {
        frontendUserService.updatePassword(frontendUserDto);
    }

    @GetMapping("/{username}")
    String getPasswordHash(@PathVariable("username") final String username) {
        String pwd = frontendUserService.getPasswordHash(username);
        log.info("Password hash: {}", pwd);
        return pwd;
    }
}
