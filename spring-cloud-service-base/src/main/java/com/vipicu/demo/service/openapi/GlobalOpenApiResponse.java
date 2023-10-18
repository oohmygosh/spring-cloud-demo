package com.vipicu.demo.service.openapi;

import com.vipicu.demo.service.entity.ApiResult;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.media.Content;
import io.swagger.v3.oas.models.media.MediaType;
import io.swagger.v3.oas.models.media.Schema;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.customizers.GlobalOpenApiCustomizer;
import org.springframework.util.ObjectUtils;

import java.util.Optional;

/**
 * @author Administrator
 * @since 1.0.0
 */
@Slf4j
public class GlobalOpenApiResponse implements GlobalOpenApiCustomizer {
    @Override
    public void customise(OpenAPI openApi) {
        Schema<ApiResult<String>> schema = new Schema<>();
        schema.set$ref("#/components/schemas/ApiResultString");
        MediaType mediaType = new MediaType().schema(schema);
        openApi.getPaths().values().forEach(pathItem -> pathItem.readOperations().forEach(item -> {
            ApiResponses responses = Optional.ofNullable(item.getResponses()).orElseGet(() -> {
                ApiResponses apiResponses = new ApiResponses();
                item.responses(apiResponses);
                return item.getResponses();
            });
            Content content = new Content().addMediaType("*/*", mediaType);
            ApiResponse unauthorized = responses.get("401");
            if (ObjectUtils.isEmpty(unauthorized)) {
                responses.addApiResponse("401", new ApiResponse().description("未授权")
                        .content(content));
            }
            ApiResponse success = responses.get("200");
            if (ObjectUtils.isEmpty(success)) {
                responses.addApiResponse("200", new ApiResponse().description("请求成功")
                        .content(content));
            }
            ApiResponse error = responses.get("500");
            if (ObjectUtils.isEmpty(error)) {
                responses.addApiResponse("500", new ApiResponse().description("服务端异常")
                        .content(content));
            }

        }));
    }

}
