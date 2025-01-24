package com.examples.design.solid.s.bad;

// single responsibility principle - bad example

public interface IEmail {
    public void setSender(String sender);
    public void setReceiver(String receiver);
    public void setContent(String content);
}
