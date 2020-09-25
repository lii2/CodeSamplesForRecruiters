package com.promptous.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity(name = "user_Info")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class UserInfoEntity {

    @Id
    private String userName;

    private String userId;

    private String brokerId;

    private String userCompanyName;

    private String userRole;

    private String userPasswordHash;

    private Boolean enabled;

    private ZonedDateTime lastActivity;

    private String accountEmail;

    private String accountPhoneNumber;

}
