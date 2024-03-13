package com.jghan.webtoonPjt.webtoon.domain;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class WebtoonCreate {

    private final String title;
    private final String author;
    private final String url;
    private final String img;
    private final Platform platform;

    private final UpdateDay updateDay;

    private final int rank;

    private final IsNew isNew;

    private final double rating;

    private final IsPublish isPublish;

    private final LocalDateTime createdDate;

    private final LocalDateTime lastModifiedDate;

    @Builder
    public WebtoonCreate(String title, String author, String url, String img, Platform platform, UpdateDay updateDay, int rank, IsNew isNew, double rating, IsPublish isPublish, LocalDateTime createdDate, LocalDateTime lastModifiedDate) {

        this.title = title;
        this.author = author;
        this.url = url;
        this.img = img;
        this.platform = platform;
        this.updateDay = updateDay;
        this.rank = rank;
        this.isNew = isNew;
        this.rating = rating;
        this.isPublish = isPublish;
        this.createdDate = createdDate;
        this.lastModifiedDate = lastModifiedDate;
    }





}