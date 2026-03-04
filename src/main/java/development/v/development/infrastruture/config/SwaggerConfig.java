package development.v.development.infrastruture.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import development.v.development.domain.messages.Message;



@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI restaurantOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title(Message.TITTLE_API_SWAGGER)
                        .description(Message.DESCRIPTION_API_SWAGGER)
                        .version(Message.VERSION_API_SWAGGER));
    }
}