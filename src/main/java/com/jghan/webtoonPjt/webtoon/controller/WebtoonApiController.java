package com.jghan.webtoonPjt.webtoon.controller;

import com.jghan.webtoonPjt.webtoon.controller.port.WebtoonService;
import com.jghan.webtoonPjt.webtoon.controller.response.WebtoonResponse;
import com.jghan.webtoonPjt.webtoon.domain.Webtoon;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@Builder
@RequestMapping("/api/webtoon")
public class WebtoonApiController {

    private final WebtoonService webtoonService;

    @ResponseStatus
    @GetMapping("/crawl/mon")
    public ResponseEntity<WebtoonResponse> crawlMon() throws IOException, InterruptedException {
        Webtoon webtoon = webtoonService.create();
        return null;
//        return ResponseEntity
//                .ok()
//                .body(WebtoonResponse.from(webtoonService.create()));
    }
}
