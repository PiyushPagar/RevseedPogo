package com.revnomix.revseed.wrapper;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class AccountPropertiesDto {

    private String propertyName;
    private Integer id;
}
