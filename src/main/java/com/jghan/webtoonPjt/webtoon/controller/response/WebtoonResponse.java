package com.jghan.webtoonPjt.webtoon.controller.response;

import com.jghan.webtoonPjt.webtoon.domain.*;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class WebtoonResponse {

    private final Long id;
    private final String title;
    private final String author;
    private final String url;
    private final String img;
    private final Platform platform;
    private final UpdateDay updateDay;
    private final int rank;
    private final IsNew isNew;
    private final IsPublish isPublish;
    private final double rating;
    private final LocalDateTime createdDate;
    private final LocalDateTime lastModifiedDate;

    public static WebtoonResponse from(Webtoon webtoon){
        return WebtoonResponse.builder()
                .id(webtoon.getId())
                .title(webtoon.getTitle())
                .author(webtoon.getAuthor())
                .url(webtoon.getUrl())
                .img(webtoon.getImg())
                .platform(webtoon.getPlatform())
                .updateDay(webtoon.getUpdateDay())
                .rank(webtoon.getRank())
                .isNew(webtoon.getIsNew())
                .rating(webtoon.getRating())
                .isPublish(webtoon.getIsPublish())
                .createdDate(webtoon.getCreatedDate())
                .lastModifiedDate(webtoon.getLastModifiedDate())
                .build();
    }
}


