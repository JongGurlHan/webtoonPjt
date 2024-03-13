package com.jghan.webtoonPjt.webtoon.controller;

import com.jghan.webtoonPjt.webtoon.controller.port.WebtoonService;
import com.jghan.webtoonPjt.webtoon.controller.response.WebtoonResponse;
import com.jghan.webtoonPjt.webtoon.domain.UpdateDay;
import com.jghan.webtoonPjt.webtoon.domain.Webtoon;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@Builder
@RequestMapping("/api/webtoon")
public class WebtoonApiController {

    private final WebtoonService webtoonService;

    @ResponseStatus
    @GetMapping("/crawl/mon")
    public ResponseEntity<WebtoonResponse> crawlMon(@RequestParam("day") String day) throws IOException, InterruptedException {
        Webtoon webtoon = webtoonService.create(day);
        return null;
//        return ResponseEntity
//                .ok()
//                .body(WebtoonResponse.from(webtoonService.create()));
    }
}
