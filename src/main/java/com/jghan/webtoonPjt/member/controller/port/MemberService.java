package com.jghan.webtoonPjt.member.controller.port;


import com.jghan.webtoonPjt.member.domain.Member;
import com.jghan.webtoonPjt.member.domain.MemberCreate;
import com.jghan.webtoonPjt.member.domain.MemberUpdate;

public interface MemberService {

    Member getById(long id);

    Member create(MemberCreate memberCreate);

    Member update(long id, MemberUpdate memberUpdate);
}
