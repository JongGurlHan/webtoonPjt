package com.jghan.webtoonPjt.webtoon.service;


import com.jghan.webtoonPjt.webtoon.controller.port.WebtoonService;
import com.jghan.webtoonPjt.webtoon.controller.request.WebtoonSearchCondition;
import com.jghan.webtoonPjt.webtoon.controller.response.WebtoonResponse;
import com.jghan.webtoonPjt.webtoon.domain.*;
import com.jghan.webtoonPjt.webtoon.infrastructure.WebtoonRepositoryCustom;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Builder
@Slf4j
@RequiredArgsConstructor
public class WebtoonServiceImpl implements WebtoonService {

    private final WebtoonRepository webtoonRepository;
    private final WebtoonRepositoryCustom webtoonRepositoryCustom;

    @Transactional
    @Override
    public Webtoon create(String day)  {

        //1. 요일설정
        UpdateDay updateDay = switch (day) {
            case "mon" -> UpdateDay.월요일;
            case "tue" -> UpdateDay.화요일;
            case "wed" -> UpdateDay.수요일;
            case "thu" -> UpdateDay.목요일;
            case "fri" -> UpdateDay.금요일;
            case "sat" -> UpdateDay.토요일;
            case "sun" -> UpdateDay.일요일;
            default -> throw new IllegalStateException("Unexpected value: " + day);
        };

        //2. 크롤링 환경설정
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless"); // Run in headless mode

        WebDriver driver = new ChromeDriver(options);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));  // Use Duration

        String targetUrl = "https://comic.naver.com/webtoon?tab="+day;
        driver.get(targetUrl);

        WebElement contentListDiv = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("ContentList__content_list--q5KXY")));

        //3. 크롤링 및 저장
        if (contentListDiv != null) {
            List<WebElement> items = contentListDiv.findElements(By.className("item"));

            int rank =  0;
            for (WebElement item : items) {
                String title = item.findElement(By.className("ContentTitle__title--e3qXt")).getText();
                String author = item.findElement(By.className("ContentAuthor__author--CTAAP")).getText();
                String url = item.findElement(By.className("Poster__link--sopnC")).getAttribute("href");
                double rating = Double.parseDouble(item.findElement(By.className("Rating__star_area--dFzsb")).findElement(By.className("text")).getText());

                WebElement posterImage = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("Poster__image--d9XTI")));
                String posterUrl = posterImage.getAttribute("src");

                rank ++;

                WebtoonCreate webtoonCreate = WebtoonCreate.builder()
                        .title(title)
                        .author(author)
                        .url(url)
                        .img(posterUrl)
                        .platform(Platform.NAVER)
                        .updateDay(updateDay)
                        .rank(rank)
                        .isNew(IsNew.N)
                        .isPublish(IsPublish.Y)
                        .rating(rating)
                        .createdDate(LocalDateTime.now())
                        .lastModifiedDate(LocalDateTime.now())
                        .build();

                Webtoon webtoon = Webtoon.from(webtoonCreate);
                webtoonRepository.save(webtoon);

                log.info("Title: " + title);
                log.info("Author: " + author);
                log.info("url = " + url);
                log.info("Rating: " + rating);
                log.info("Poster URL: " + posterUrl);
                log.info("rank = " + rank);
                log.info("--------------------");
            }
        }

        // Close the browser
        driver.quit();
        return null;
    }

    @Override
    public Page<WebtoonResponse> search(WebtoonSearchCondition condition, Pageable pageable) {
        return webtoonRepositoryCustom.search(condition, pageable);
    }
}
