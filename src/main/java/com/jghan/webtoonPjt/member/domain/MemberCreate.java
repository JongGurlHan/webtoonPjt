package com.jghan.webtoonPjt.member.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

@Getter
public class MemberCreate {

    private final String email;
    private final String emailRcv;
    private final String nickname;
    private final String mobile;
    private final MemberStatus status;
    private final MemberRole role;
    private final int loginCount;

    @Builder
    public MemberCreate(
            @JsonProperty("email") String email,
            @JsonProperty("emailRcv") String emailRcv,
            @JsonProperty("nickname") String nickname,
            @JsonProperty("mobile") String mobile,
            @JsonProperty("status") MemberStatus status,
            @JsonProperty("role") MemberRole role,
            @JsonProperty("loginCount") int loginCount) {

        this.email = email;
        this.emailRcv = emailRcv;
        this.nickname = nickname;
        this.mobile = mobile;
        this.status = status;
        this.role = role;
        this.loginCount = loginCount;
    }
}
