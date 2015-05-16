package com.camilla.tool.inventory.ui.common;

import java.awt.GridBagConstraints;
import java.awt.Insets;

public final class GridBagConstraintsHelper {

  private GridBagConstraintsHelper() {} // prevent initialize

  public static Builder getBuilder() {
    return new Builder();
  }

  public static class Builder {

    private GridBagConstraints c = new GridBagConstraints();

    public Builder gridx(int gridx) {
      c.gridx = gridx;
      return this;
    }

    public Builder gridy(int gridy) {
      c.gridy = gridy;
      return this;
    }

    public Builder gridwidth(int gridwidth) {
      c.gridwidth = gridwidth;
      return this;
    }

    public Builder gridheight(int gridheight) {
      c.gridheight = gridheight;
      return this;
    }

    public Builder weightx(double weightx) {
      c.weightx = weightx;
      return this;
    }

    public Builder weighty(double weighty) {
      c.weighty = weighty;
      return this;
    }

    public Builder anchor(int anchor) {
      c.anchor = anchor;
      return this;
    }

    public Builder fill(int fill) {
      c.fill = fill;
      return this;
    }

    public Builder insets(int inset) {
      Insets insets = new Insets(inset, inset, inset, inset);
      c.insets = insets;
      return this;
    }

    public Builder insets(int topAndBottom, int leftAndRight) {
      Insets insets = new Insets(topAndBottom, leftAndRight, topAndBottom, leftAndRight);
      c.insets = insets;
      return this;
    }

    public Builder insets(int top, int left, int bottom, int right) {
      Insets insets = new Insets(top, left, bottom, right);
      c.insets = insets;
      return this;
    }

    public Builder ipadx(int ipadx) {
      c.ipadx = ipadx;
      return this;
    }

    public Builder ipady(int ipady) {
      c.ipady = ipady;
      return this;
    }

    public GridBagConstraints build() {
      return c;
    }
  }
}
