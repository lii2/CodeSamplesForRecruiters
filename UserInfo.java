package com.promptous.commercial;

import com.promptous.entity.UserInfoEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfo {

    private String userName;

    private String memberId;

    private String companyName;

    private String role;

    private String brokerId;

    private String accountEmail;

    private String accountPhoneNumber;

    public UserInfo(UserInfoEntity userInfoEntity) {
        this.userName = userInfoEntity.getUserName();
        this.memberId = userInfoEntity.getUserId();
        this.brokerId = userInfoEntity.getBrokerId();
        this.companyName = userInfoEntity.getUserCompanyName();
        this.role = userInfoEntity.getUserRole();
        this.accountEmail = userInfoEntity.getAccountEmail();
        this.accountPhoneNumber = userInfoEntity.getAccountPhoneNumber();
    }
}
