package com.kevinfan.coolj.rest.dropwizard.hello;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;

/**
 * Created by kevinjom on 14-9-12.
 */
public class Greeting implements Serializable {
    private long id;

    @Length(min = 1)
    private String content;

    public Greeting() {
    }

    public Greeting(long id, String content) {
        this.id = id;
        this.content = content;
    }

    @JsonProperty
    public long getId() {
        return id;
    }

    @JsonProperty
    public String getContent() {
        return content;
    }
}
