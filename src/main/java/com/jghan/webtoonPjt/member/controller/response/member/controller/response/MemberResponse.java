package com.jghan.webtoonPjt.member.controller.response.member.controller.response;

import com.jghan.museumProject.member.domain.Member;
import com.jghan.museumProject.member.domain.MemberRole;
import com.jghan.museumProject.member.domain.MemberStatus;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class MemberResponse {

    private Long id;
    private String email;
    private String emailRcv;
    private String nickname;
    private String mobile;
    private MemberStatus status;
    private MemberRole role;
    private LocalDateTime lastLoginTime;
    private int loginCount;

    public static MemberResponse from(Member member){
        return MemberResponse.builder()
                .id(member.getId())
                .email(member.getEmail())
                .emailRcv(member.getEmailRcv())
                .nickname(member.getNickname())
                .mobile(member.getMobile())
                .status(member.getStatus())
                .role(member.getRole())
                .lastLoginTime(member.getLastLoginTime())
                .loginCount(member.getLoginCount())
                .build();
    }
}
