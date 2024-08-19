package com.rujuu.todo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")  // すべてのエンドポイントに適用
                .allowedOrigins("http://localhost:3000")  //  TODO: 環境変数で切り替えられるようにする
                .allowedMethods("GET", "POST", "PUT", "DELETE")  // 許可するHTTPメソッド
                .allowedHeaders("*")  // 許可するヘッダー
                .allowCredentials(true);  // クッキーの送信を許可
    }
}
