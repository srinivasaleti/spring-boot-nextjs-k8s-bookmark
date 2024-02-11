package com.srinivas.bookmarkerapi;

import com.srinivas.bookmarkerapi.domain.Bookmark;
import com.srinivas.bookmarkerapi.domain.BookmarkRepository;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Testcontainers
class BookmarkerApiApplicationTests {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private BookmarkRepository bookmarkRepository;

    @Container
    private static PostgreSQLContainer postgresqlContainer = new PostgreSQLContainer("postgres:15-alpine")
            .withDatabaseName("foo")
            .withUsername("foo")
            .withPassword("secret");

    @DynamicPropertySource
    static void configureProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", postgresqlContainer::getJdbcUrl);
        registry.add("spring.datasource.username", postgresqlContainer::getUsername);
        registry.add("spring.datasource.password", postgresqlContainer::getPassword);
    }

    @BeforeEach
    void setup() {
        postgresqlContainer.start();
        bookmarkRepository.deleteAllInBatch();
        List<Bookmark> bookmarks = new ArrayList<>();

        bookmarks.add(new Bookmark(null, "SivaLabs", "https://sivalabs.in", Instant.now()));
        bookmarks.add(new Bookmark(null, "SpringBlog", "https://spring.io/blog", Instant.now()));
        bookmarks.add(new Bookmark(null, "Quarkus", "https://quarkus.io/", Instant.now()));
        bookmarks.add(new Bookmark(null, "Micronaut", "https://micronaut.io/", Instant.now()));
        bookmarks.add(new Bookmark(null, "JOOQ", "https://www.jooq.org/", Instant.now()));
        bookmarks.add(new Bookmark(null, "VladMihalcea", "https://vladmihalcea.com", Instant.now()));
        bookmarks.add(new Bookmark(null, "Thoughts On Java", "https://thorben-janssen.com/", Instant.now()));
        bookmarks.add(new Bookmark(null, "DZone", "https://dzone.com/", Instant.now()));
        bookmarks.add(new Bookmark(null, "DevOpsBookmarks", "http://www.devopsbookmarks.com/", Instant.now()));
        bookmarks.add(new Bookmark(null, "Kubernetes docs", "https://kubernetes.io/docs/home/", Instant.now()));
        bookmarks.add(new Bookmark(null, "Expressjs", "https://expressjs.com/", Instant.now()));
        bookmarks.add(new Bookmark(null, "Marcobehler", "https://www.marcobehler.com", Instant.now()));
        bookmarks.add(new Bookmark(null, "baeldung", "https://www.baeldung.com", Instant.now()));
        bookmarks.add(new Bookmark(null, "devglan", "https://www.devglan.com", Instant.now()));
        bookmarks.add(new Bookmark(null, "linuxize", "https://linuxize.com", Instant.now()));
        bookmarkRepository.saveAll(bookmarks);
    }

    @AfterAll
    static void afterAll() {
        postgresqlContainer.stop();
    }

    @ParameterizedTest
    @CsvSource({"1,15,2,1,true,false,true,false", "2,15,2,2,false,true,false,true"})
    void shouldGetBookmarks(int pageNo, int totalElements, int totalPages, int currentPage, boolean isFirst, boolean isLast, boolean hasNext, boolean hasPrevious) throws Exception {
        mvc.perform(get("/api/bookmarks?page=" + pageNo + "&pageSize=10")).andExpect(status().isOk()).andExpect(jsonPath("$.totalElements", CoreMatchers.equalTo(totalElements))).andExpect(jsonPath("$.totalPages", CoreMatchers.equalTo(totalPages))).andExpect(jsonPath("$.currentPage", CoreMatchers.equalTo(currentPage))).andExpect(jsonPath("$.isFirst", CoreMatchers.equalTo(isFirst))).andExpect(jsonPath("$.isLast", CoreMatchers.equalTo(isLast))).andExpect(jsonPath("$.hasNext", CoreMatchers.equalTo(hasNext))).andExpect(jsonPath("$.hasPrevious", CoreMatchers.equalTo(hasPrevious)));
    }
}
