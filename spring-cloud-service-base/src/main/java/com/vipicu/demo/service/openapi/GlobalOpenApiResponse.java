package com.vipicu.demo.service.openapi;

import com.vipicu.demo.cloud.core.entity.ApiResult;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.media.Content;
import io.swagger.v3.oas.models.media.MediaType;
import io.swagger.v3.oas.models.media.Schema;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.customizers.GlobalOpenApiCustomizer;
import org.springframework.util.ObjectUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @author Administrator
 * @since 1.0.0
 */
@Slf4j
public class GlobalOpenApiResponse implements GlobalOpenApiCustomizer {

    private final Map<String, ApiResponse> defaultApiResponses = new HashMap<>() {{
        Schema<ApiResult<String>> schema = new Schema<>();
        schema.set$ref("#/components/schemas/ApiResultString");
        MediaType mediaType = new MediaType().schema(schema);
        Content content = new Content().addMediaType("*/*", mediaType);
        put("200",new ApiResponse().description("OK").content(content));
        put("401",new ApiResponse().description("INVALID_AUTHENTICATION").content(content));
        put("403",new ApiResponse().description("UNAUTHORIZED").content(content));
        put("500",new ApiResponse().description("SERVER_ERROR").content(content));
    }};

    @Override
    public void customise(OpenAPI openApi) {
        openApi.getPaths().values().forEach(pathItem -> pathItem.readOperations().forEach(item -> {
            ApiResponses responses = Optional.ofNullable(item.getResponses()).orElseGet(() -> {
                ApiResponses apiResponses = new ApiResponses();
                item.responses(apiResponses);
                return item.getResponses();
            });
            defaultApiResponses.forEach((k, v) -> {
                if (ObjectUtils.isEmpty(responses.get(k))) {
                    responses.addApiResponse(k, v);
                }
            });
        }));
    }

}
