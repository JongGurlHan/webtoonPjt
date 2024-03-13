package com.jghan.webtoonPjt.webtoon.service;


import com.jghan.webtoonPjt.webtoon.controller.port.WebtoonService;
import com.jghan.webtoonPjt.webtoon.domain.*;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
@Builder
@RequiredArgsConstructor
public class WebtoonServiceImpl implements WebtoonService {

    private final WebtoonRepository webtoonRepository;

    @Transactional
    @Override
    public Webtoon create() throws IOException, InterruptedException {

        System.setProperty("webdriver.chrome.driver", "chromedriver.exe"); // Set the path to your chromedriver executable

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));  // Use Duration

        String targetUrl = "https://comic.naver.com/webtoon?tab=mon";

        driver.get(targetUrl);

        // Wait for the content to be present
        WebElement contentListDiv = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("ContentList__content_list--q5KXY")));

        if (contentListDiv != null) {
            List<WebElement> items = contentListDiv.findElements(By.className("item"));

            System.out.println("items.size() = " + items.size());

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
                        .isNew(IsNew.N)
                        .rating(rating)
                        .isPublish(IsPublish.Y)
                        .createdDate(LocalDateTime.now())
                        .lastModifiedDate(LocalDateTime.now())
                        .build();

                Webtoon webtoon = Webtoon.from(webtoonCreate);
                webtoonRepository.save(webtoon);




                System.out.println("Title: " + title);
                System.out.println("Author: " + author);
                System.out.println("url = " + url);
                System.out.println("Rating: " + rating);
                System.out.println("Poster URL: " + posterUrl);
                System.out.println("rank = " + rank);
                System.out.println("--------------------");
            }
        }

        // Close the browser
        driver.quit();
        return null;
    }
}
