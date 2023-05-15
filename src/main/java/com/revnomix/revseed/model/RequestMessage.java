package com.revnomix.revseed.model;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestMessage {
    private String errorMessage;
    private Integer accountId;
}
