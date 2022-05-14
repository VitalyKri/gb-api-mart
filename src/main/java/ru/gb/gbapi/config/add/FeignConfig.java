package ru.gb.gbapi.config.add;

import feign.RequestInterceptor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import ru.gb.gbapi.category.api.CategoryGateway;
import ru.gb.gbapi.config.GbApiProperties;
import ru.gb.gbapi.manufacturer.api.ManufacturerGateway;
import ru.gb.gbapi.order.api.OrderGateway;
import ru.gb.gbapi.product.api.ProductGateway;
import ru.gb.gbapi.security.api.AuthGateway;
import ru.gb.gbapi.security.api.UserGateway;

@Configuration
@EnableFeignClients
@EnableConfigurationProperties(GbApiProperties.class)
@RequiredArgsConstructor
@Import(value = {FeignClientFactory.class})
@Getter
@ComponentScan("ru.gb.gbapi.config")
public class FeignConfig {

    private final GbApiProperties gbApiProperties;
    private final FeignClientFactory feignClientFactory;
    private final RequestInterceptor requestInterceptor;


    @Bean
    public CategoryGateway categoryGateway() {
        return feignClientFactory.newFeignClient(CategoryGateway.class, gbApiProperties.getEndpoint().getCategoryUrl(),requestInterceptor);
    }

    @Bean
    public ManufacturerGateway manufacturerGateway() {
        return feignClientFactory.newFeignClient(ManufacturerGateway.class, gbApiProperties.getEndpoint().getManufacturerUrl(),requestInterceptor);
    }
    @Bean
    public OrderGateway orderGateway() {
        return feignClientFactory.newFeignClient(OrderGateway.class, gbApiProperties.getEndpoint().getOrderUrl(),requestInterceptor);
    }

    @Bean
    public ProductGateway productGateway() {
        return feignClientFactory.newFeignClient(ProductGateway.class, gbApiProperties.getEndpoint().getProductUrl(),requestInterceptor);
    }

    @Bean
    public UserGateway userGateway() {
        return feignClientFactory.newFeignClient(UserGateway.class, gbApiProperties.getEndpoint().getUserUrl(),requestInterceptor);
    }

    @Bean
    public AuthGateway authGateway() {
        return feignClientFactory.newFeignClient(AuthGateway.class, gbApiProperties.getEndpoint().getAuthUrl(),requestInterceptor);
    }

}
