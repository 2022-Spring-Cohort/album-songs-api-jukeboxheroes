package org.wcci.apimastery.Entities;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class Comment {

    private String body;

    public Comment() {

    }

    public Comment(String body) {
        this.body = body;
    }

    public String getBody() {
        return body;
    }


}