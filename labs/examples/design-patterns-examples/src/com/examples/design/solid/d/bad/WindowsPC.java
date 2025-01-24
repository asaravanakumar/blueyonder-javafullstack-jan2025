package com.examples.design.solid.d.bad;

public class WindowsPC {

  private final StandardKeyboard keyboard;
  private final Monitor monitor;

  public WindowsPC() {

    monitor = new Monitor();
    keyboard = new StandardKeyboard();

  }

}
