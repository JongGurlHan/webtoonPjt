package com.jghan.webtoonPjt.member.domain;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Member {

    private final Long id;
    private final String email;
    private final String emailRcv;
    private final String nickname;
    private final String mobile;
    private final MemberStatus status;
    private final MemberRole role;
    private final LocalDateTime lastLoginTime;
    private final int loginCount;

    @Builder
    public Member(Long id, String email, String emailRcv, String nickname, String mobile, MemberStatus status, MemberRole role, LocalDateTime lastLoginTime, int loginCount) {
        this.id = id;
        this.email = email;
        this.emailRcv = emailRcv;
        this.nickname = nickname;
        this.mobile = mobile;
        this.status = status;
        this.role = role;
        this.lastLoginTime = lastLoginTime;
        this.loginCount = loginCount;
    }

    public static Member from(MemberCreate memberCreate){
        return Member.builder()
            .email(memberCreate.getEmail())
            .emailRcv(memberCreate.getEmailRcv())
            .nickname(memberCreate.getNickname())
            .mobile(memberCreate.getMobile())
            .status(MemberStatus.ACTIVE)
            .role(MemberRole.USER)
            .loginCount(0)
            .build();
    }

    public Member update(MemberUpdate memberUpdate){

        return Member.builder()
                .id(id)
                .email(email)
                .emailRcv(memberUpdate.getEmailRcv() != null ? memberUpdate.getEmailRcv() : emailRcv)
                .nickname(memberUpdate.getNickname() != null ? memberUpdate.getNickname() : nickname)
                .mobile(memberUpdate.getMobile() != null ? memberUpdate.getMobile() : mobile)
                .status(status)
                .role(role)
                .lastLoginTime(lastLoginTime)
                .loginCount(loginCount)
                .build();


    }

    //todo 테스트: 로그인, 회원삭제


}
