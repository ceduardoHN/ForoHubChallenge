package com.curso.alura.forohub.documentation;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Soriano
 */
@Configuration
public class SpringDocConfiguration {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components()
                        .addSecuritySchemes("bearer-key",
                                new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("bearer").bearerFormat("JWT")
                        )
                )
                .info(new Info()
                        .title("ForoHub API")
                        .version("0.1.0")
                        .description(
                                "Interfaz de usuario para explorar, entender y analizar los endpoints " +
                                "(peticiones y respuestas) que la API tiene a su disposición."
                        )
                        .contact(new Contact()
                                .name("Eduardo Soriano")
                                .url("https://github.com/ceduardoHN/")
                                .email("EDuardDOsm.13@gmail.com")
                        )
                );
    }
}
