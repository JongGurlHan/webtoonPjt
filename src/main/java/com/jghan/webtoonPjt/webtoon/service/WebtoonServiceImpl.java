package com.jghan.webtoonPjt.webtoon.service;


import com.jghan.webtoonPjt.webtoon.controller.port.WebtoonService;
import com.jghan.webtoonPjt.webtoon.domain.Webtoon;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
@Builder
@RequiredArgsConstructor
public class WebtoonServiceImpl implements WebtoonService {
    @Override
    public Webtoon create() throws IOException, InterruptedException {

        System.setProperty("webdriver.chrome.driver", "chromedriver.exe"); // Set the path to your chromedriver executable

        WebDriver driver = new ChromeDriver();
        String url = "https://comic.naver.com/webtoon?tab=mon";


        // Navigate to the URL
        driver.get(url);

        // Wait for the content to load (you might need to adjust the time)
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

// Find the div with the specified class
        WebElement contentListDiv = driver.findElement(By.className("ContentList__content_list--q5KXY"));

        // Extract information inside the div
        if (contentListDiv != null) {
            // Find all items within the div
            List<WebElement> items = contentListDiv.findElements(By.className("item"));

            System.out.println("items.size() = " + items.size());

            // Extract information for each item
            for (WebElement item : items) {
                String title = item.findElement(By.className("ContentTitle__title--e3qXt")).getText();
                String author = item.findElement(By.className("ContentAuthor__author--CTAAP")).getText();
                String rating = item.findElement(By.className("text")).getText();
                //String posterUrl = item.findElement(By.className("Poster__image--d9XTI")).getAttribute("src");
                String posterUrl = item.findElement(By.cssSelector("img[class*='Poster__image--d9XTI']")).getAttribute("src");


                // Print or process the extracted information as needed
                System.out.println("Title: " + title);
                System.out.println("Author: " + author);
                System.out.println("Rating: " + rating);
                System.out.println("Poster URL: " + posterUrl);
                System.out.println("--------------------");
            }
        }

        // Close the browser
        driver.quit();
        return null;
    }
}
