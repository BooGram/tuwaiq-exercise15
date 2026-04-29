package com.example.tuwaiqarticle.Model;

import jakarta.validation.constraints.AssertFalse;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Article {
    @NotNull(message = "id Cannot be null")
    private String id;
    @NotNull(message = "title Cannot be null")
    @Size(max = 100,message = "Maximum length of 100 characters.")
    private String title;
    @NotNull(message = "author Cannot be null")
    @Size(min = 4,message = "author Must be more than 4 characters.")
    @Size(max = 20,message = "author Maximum length of 20 characters.")
    private String author;
    @NotNull(message = "content Cannot be null")
    @Size(min = 20,message = "content Must be more than 200 characters.")
    private String content;
    @NotNull(message = "category Cannot be null")
    @Pattern(regexp = "politics|sports|technology",message ="category Must be either \"politics\", \" sports\" or \" technology\" only." )
    private String category;
    @NotNull(message = "imageUrl Cannot be null")
    private String imageUrl;
    @AssertFalse
    private boolean isPublished;
    @NotNull
    private LocalDate publishDate;
}
