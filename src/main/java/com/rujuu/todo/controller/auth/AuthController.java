package com.rujuu.todo.controller.auth;

import com.rujuu.todo.model.GenerateToken200Response;
import com.rujuu.todo.service.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final TokenService tokenService;

    @PostMapping("/token")
    public ResponseEntity<GenerateToken200Response> generateToken(Authentication authentication) {
        // トークン生成処理
        String token = tokenService.generateToken(authentication);

        // 生成されたトークンをレスポンスに設定
        GenerateToken200Response response = new GenerateToken200Response();
        response.setToken(token);

        // レスポンスを返す
        return ResponseEntity.ok(response);
    }
}
