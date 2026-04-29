package com.example.tuwaiqarticle.Service;

import com.example.tuwaiqarticle.Model.Article;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class ArticleService {

    ArrayList<Article> articles = new ArrayList<>();
    ArrayList<Article> published = new ArrayList<>();


    public ArrayList<Article> getArticles(){
        return articles;
    }

    public void addArticles(Article article){
        articles.add(article);
    }
    public boolean updateArticle(String id, Article article){
        for (int i = 0; i< articles.size(); i++){

            if(articles.get(i).getId().equals(id)){
                articles.set(i,article);
                return true;
            }
        }

        return false;
    }
    public boolean deletedArticle(String id){
        for (int i = 0; i<articles.size(); i++){
            if(articles.get(i).getId().equals(id)){
                articles.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean publishArticle(String id){
        for (int i = 0; i<articles.size(); i++){
            if (articles.get(i).getId().equals(id)){
                articles.get(i).setPublished(true);
                published.add(articles.get(i));
                return true;
            }
        }
        return false;
    }
    public ArrayList<Article> getPublishedArticle(){
        return published;
    }
    public ArrayList<Article> getByCategory(String category){
        ArrayList<Article> articles1 = new ArrayList<>();
        for (int i = 0; i <articles.size(); i++){
            if (articles.get(i).getCategory().equals(category)){

                articles1.add(articles.get(i));
            }
        }

        return articles1;
    }
}
