package com.jghan.webtoonPjt.member.controller.response.member.service.port;

import com.jghan.museumProject.member.domain.Member;
import com.jghan.museumProject.member.domain.MemberStatus;

import java.util.Optional;

public interface MemberRepository {

    Member getById(long id);

    Optional<Member>findById(long id);

    Optional<Member> findByIdAndStatus(long id, MemberStatus memberStatus);


    Member save(Member member);


}
