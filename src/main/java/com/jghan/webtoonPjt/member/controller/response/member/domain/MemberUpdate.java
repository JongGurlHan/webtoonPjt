package com.jghan.webtoonPjt.member.controller.response.member.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

@Getter
public class MemberUpdate {

    private final String emailRcv;
    private final String nickname;
    private final String mobile;

    @Builder
    public MemberUpdate(
            @JsonProperty("emailRcv") String emailRcv,
            @JsonProperty("nickname") String nickname,
            @JsonProperty("mobile") String mobile
            ) {

        this.emailRcv = emailRcv;
        this.nickname = nickname;
        this.mobile = mobile;

    }
}
