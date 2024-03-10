package com.jghan.webtoonPjt.webtoon.service;


import com.jghan.webtoonPjt.webtoon.controller.port.WebtoonService;
import com.jghan.webtoonPjt.webtoon.domain.Webtoon;
import com.jghan.webtoonPjt.webtoon.domain.WebtoonCreate;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;


public class WebtoonServiceImpl implements WebtoonService {
    @Override
    public Webtoon create(WebtoonCreate webtoonCreate) throws IOException {

        String url = "https://comic.naver.com/webtoon?tab=mon";
        Document doc = Jsoup.connect(url).get();


    }
}
