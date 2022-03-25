package org.wcci.apimastery.Entities;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class Comment {

    private String body;
    public int rating;

    public Comment() {

    }

    public Comment(String body, int rating) {
        this.body = body;
        this.rating = rating;
    }

    public String getBody() {
        return body;
    }

    public int getRating() {
        return rating;
    }
}