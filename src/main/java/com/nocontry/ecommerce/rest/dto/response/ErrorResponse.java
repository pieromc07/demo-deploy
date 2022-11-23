package com.nocontry.ecommerce.rest.dto.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class ErrorResponse {

    private int statusCode;
    private String message;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> moreInfo;
}
