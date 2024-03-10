package com.jghan.webtoonPjt.member.controller;

import com.jghan.webtoonPjt.member.controller.port.MemberService;
import com.jghan.webtoonPjt.member.controller.response.member.controller.response.MemberResponse;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//@Tag(name = "유저(users)")
@RestController
@RequestMapping("/api/members")
@Builder
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @ResponseStatus
    @GetMapping("/{id}")
    public ResponseEntity<MemberResponse> getById(@PathVariable long id) {
        return ResponseEntity
                .ok()
                .body(MemberResponse.from(memberService.getById(id)));
    }


}
