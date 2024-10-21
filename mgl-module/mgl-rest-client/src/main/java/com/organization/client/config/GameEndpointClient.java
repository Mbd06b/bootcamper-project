package com.organization.client.config;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.FeignClientProperties.FeignClientConfiguration;
import org.springframework.stereotype.Component;
import com.organization.provider.endpoint.GameEndpoint;


@Component
@FeignClient(name="game-endpoint-client",url="${mgl.game.feignclient.url}",  configuration= FeignClientConfiguration.class)
public interface GameEndpointClient extends GameEndpoint {

}
