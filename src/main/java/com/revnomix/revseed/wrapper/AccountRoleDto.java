package com.revnomix.revseed.wrapper;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountRoleDto {

    private Integer roleId;
    private String name;
    private String description;
    private String defaultScreen;
    private String roleCode;
}
