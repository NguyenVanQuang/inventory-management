package com.camilla.tool.inventory.ui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.camilla.tool.inventory.ui.common.GridBagConstraintsHelper;

public class ItemImportPanelCreator {

  public static JPanel create() {
    JPanel pane = new JPanel(false);

    pane.setLayout(new GridBagLayout());
    GridBagConstraints c;

    JLabel titleLabel = new JLabel("Vui lòng chọn file chứa thông tin sản phẩm");
    c = GridBagConstraintsHelper.getBuilder().gridx(0).gridy(0).build();
    pane.add(titleLabel, c);

    JFileChooser fileChooser = new JFileChooser();
    c = GridBagConstraintsHelper.getBuilder().gridx(0).gridy(1).build();
    pane.add(fileChooser, c);

    return pane;
  }
}
