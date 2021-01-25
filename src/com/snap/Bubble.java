package com.snap;

/**
 * @author amarnath
 * @date 02-Aug-2017
 *
 */
public class Bubble {
    private Integer number;
    private String text;

    public Bubble() {
        // TODO Auto-generated constructor stub
    }

    public Bubble(Integer number) {
        this.number = number;
    }

    public Bubble(String text) {
        this.text = text;
    }

    public Bubble(Integer number, String text) {
        this(number);
        this.text = text;

    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Bubble [number=" + number + ", text=" + text + "]";
    }

}
