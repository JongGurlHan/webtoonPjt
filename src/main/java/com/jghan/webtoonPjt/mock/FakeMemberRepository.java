//package com.jghan.webtoonPjt.mock;
//
//import com.jghan.webtoonPjt.common.domain.exception.ResourceNotFoundException;
//import com.jghan.webtoonPjt.member.domain.Member;
//import com.jghan.webtoonPjt.member.domain.MemberStatus;
//import com.jghan.webtoonPjt.member.service.port.MemberRepository;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Objects;
//import java.util.Optional;
//import java.util.concurrent.atomic.AtomicLong;
//
//public class FakeMemberRepository implements MemberRepository {
//
//    private final AtomicLong autoGeneratedId = new AtomicLong(0);
//
//    private final List<Member> data = new ArrayList<>();
//
//    @Override
//    public Member getById(long id) {
//        return findById(id).orElseThrow(()-> new ResourceNotFoundException("Members", id));
//    }
//
//    @Override
//    public Optional<Member> findById(long id) {
//        return data.stream().filter(item -> item.getId().equals(id)).findAny();
//    }
//
//    @Override
//    public Optional<Member> findByIdAndStatus(long id, MemberStatus memberStatus) {
//        return data.stream().filter(item -> item.getId().equals(id) && item.getStatus() == memberStatus).findAny();
//    }
//
//    @Override
//    public Member save(Member member) {
//        if (member.getId() == null || member.getId() == 0) {
//            Member newMember = Member.builder()
//                    .id(autoGeneratedId.incrementAndGet())
//                    .email(member.getEmail())
//                    .emailRcv(member.getEmailRcv())
//                    .nickname(member.getNickname())
//                    .mobile(member.getMobile())
//                    .status(member.getStatus())
//                    .role(member.getRole())
//                    .lastLoginTime(member.getLastLoginTime())
//                    .loginCount(member.getLoginCount())
//                    .build();
//            data.add(newMember);
//            return newMember;
//        } else {
//            data.removeIf(item -> Objects.equals(item.getId(), member.getId())); //id값이 있으면 기존 데이터 지우고 지금 들어온 데이터 저장
//            data.add(member);
//            return member;
//        }
//    }
//}
