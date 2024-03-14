package com.jghan.webtoonPjt.webtoon.controller;

import com.jghan.webtoonPjt.webtoon.controller.port.WebtoonService;
import com.jghan.webtoonPjt.webtoon.controller.request.WebtoonSearchCondition;
import com.jghan.webtoonPjt.webtoon.controller.response.WebtoonResponse;
import com.jghan.webtoonPjt.webtoon.domain.UpdateDay;
import com.jghan.webtoonPjt.webtoon.domain.Webtoon;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@Builder
@RequestMapping("/api/webtoon")
public class WebtoonApiController {

    private final WebtoonService webtoonService;

    @GetMapping
    public Page<WebtoonResponse> search(WebtoonSearchCondition condition, Pageable pageable){
        return webtoonService.search(condition, pageable);
    }


    @ResponseStatus
    @GetMapping("/crawl")
    public ResponseEntity<WebtoonResponse> crawlOneDay(@RequestParam("day") String day) throws IOException, InterruptedException {
        Webtoon webtoon = webtoonService.create(day);
        return null;
    }

    @ResponseStatus
    @GetMapping("/crawl/all")
    public ResponseEntity<WebtoonResponse> crawlAllDay() throws IOException, InterruptedException {
        Webtoon webtoonMon = webtoonService.create("mon");
        Webtoon webtoonTue = webtoonService.create("tue");
        Webtoon webtoonWed = webtoonService.create("wed");
        Webtoon webtoonThu = webtoonService.create("thu");
        Webtoon webtoonFri = webtoonService.create("fri");
        Webtoon webtoonSat = webtoonService.create("sat");
        Webtoon webtoonSun = webtoonService.create("sun");
        return null;
    }



}
