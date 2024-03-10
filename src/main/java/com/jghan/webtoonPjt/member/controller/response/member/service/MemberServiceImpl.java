package com.jghan.webtoonPjt.member.controller.response.member.service;


import com.jghan.museumProject.common.domain.exception.ResourceNotFoundException;
import com.jghan.museumProject.member.controller.port.MemberService;
import com.jghan.museumProject.member.domain.Member;
import com.jghan.museumProject.member.domain.MemberCreate;
import com.jghan.museumProject.member.domain.MemberStatus;
import com.jghan.museumProject.member.domain.MemberUpdate;
import com.jghan.museumProject.member.service.port.MemberRepository;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Builder
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;


    @Override
    public Member getById(long id) {
        return memberRepository.findByIdAndStatus(id, MemberStatus.ACTIVE)
                .orElseThrow(()-> new ResourceNotFoundException("Members", id));
    }

    @Override
    public Member create(MemberCreate memberCreate) {
        Member member = Member.from(memberCreate);
        member = memberRepository.save(member);
        return member;
    }

    @Override
    public Member update(long id, MemberUpdate memberUpdate) {
        Member member = getById(id);
        member = member.update(memberUpdate);
        member = memberRepository.save(member);
        return member;
    }
}
