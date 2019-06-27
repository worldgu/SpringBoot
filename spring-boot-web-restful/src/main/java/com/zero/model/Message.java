package com.zero.model;

/**
 * @author ：Zero
 * @date ：Created in 2019/6/27 21:28
 * @modified By：
 */
public class Message {

    private Long id;
    private String text;
    private String summary;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}
