package com.jghan.webtoonPjt.webtoon.controller.response;

import com.jghan.webtoonPjt.webtoon.domain.*;
import com.querydsl.core.annotations.QueryProjection;
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

    @QueryProjection
    public WebtoonResponse(Long id, String title, String author, String url, String img, Platform platform, UpdateDay updateDay, int rank, IsNew isNew, IsPublish isPublish, double rating, LocalDateTime createdDate, LocalDateTime lastModifiedDate) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.url = url;
        this.img = img;
        this.platform = platform;
        this.updateDay = updateDay;
        this.rank = rank;
        this.isNew = isNew;
        this.isPublish = isPublish;
        this.rating = rating;
        this.createdDate = createdDate;
        this.lastModifiedDate = lastModifiedDate;
    }

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


