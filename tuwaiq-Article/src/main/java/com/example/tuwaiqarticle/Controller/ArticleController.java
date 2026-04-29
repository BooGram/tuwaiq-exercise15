package com.example.tuwaiqarticle.Controller;

import com.example.tuwaiqarticle.Api.ApiResponse;
import com.example.tuwaiqarticle.Model.Article;
import com.example.tuwaiqarticle.Service.ArticleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/api/v1/article")
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService articleService;

    @GetMapping("/get")
    public ResponseEntity<?> getArticle() {
        return ResponseEntity.status(200).body(articleService.getArticles());
    }

    @PostMapping("/add")
    public ResponseEntity<?> addArticle(@Valid @RequestBody Article article, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        articleService.addArticles(article);
        return ResponseEntity.status(200).body(new ApiResponse("Article added successfully"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateArticle(@PathVariable String id, @Valid @RequestBody Article article, Errors errors) {

        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isUpdated = articleService.updateArticle(id, article);

        if (isUpdated) {
            return ResponseEntity.status(200).body(new ApiResponse("Article updated successfully"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("Article not found"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteArticle(@PathVariable String id) {

        boolean isDeleted = articleService.deletedArticle(id);
        if (isDeleted) {
            return ResponseEntity.status(200).body(new ApiResponse("Article deleted successfully"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("Article not found"));
    }

    @PostMapping("/publish/{id}")
    public ResponseEntity<?> publishArticle(@PathVariable String id) {

        boolean isPublished = articleService.publishArticle(id);
        if (isPublished) {
            return ResponseEntity.status(200).body(new ApiResponse("Article published successfully."));
        }
        return ResponseEntity.status(400).body(new ApiResponse("Article not found"));


    }
    @GetMapping("/getPublishArticles")
    public ResponseEntity<?> getPublishArticle(){
        return ResponseEntity.status(200).body(articleService.getPublishedArticle());

    }
    @GetMapping("/getByCategory/{category}")
    public ResponseEntity<?> getByCategory(@PathVariable String category){
        return ResponseEntity.status(200).body(articleService.getByCategory(category));
    }
}
