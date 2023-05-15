package com.revnomix.revseed.wrapper;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Accessors(chain = true)
public class AccountsDto {
    private Integer accountId;
    private String accountFirstName;
    private String accountLastName;
    private String Address1;
    private String Address2;
    private String mobile1;
    private String mobile2;
    private String city;
    private String state;
    private String email;
    private String password;
    private String status;
    private Date regdate;
    private String author;
    private String position;
    private Integer clientId;
    private String role;
    private String propertyName;
    private Set<AccountRoleDto> roles = new HashSet<>();
    private Set<AccountPropertiesDto> accountProperties = new HashSet<>();
    private String oldpassword;
}
