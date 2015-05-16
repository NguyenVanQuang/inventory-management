package com.camilla.tool.inventory.ui;

import javax.swing.JOptionPane;

import com.camilla.tool.inventory.enums.Action;

public class App {

  public void start() {
    String[] options =
        new String[] {"Thêm thông tin sản phẩm", "Thêm thông tin kho hàng", "Tạo lệnh xuất/nhập hàng",
            "Tạo file báo cáo"};
    int selectedOption =
        JOptionPane.showOptionDialog(null, "Vui lòng chọn một hành động dưới đây:", "Quản lý kho hàng",
            JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[2]);

    if (selectedOption == Action.IMPORT_ITEM.intValue()) {
      ImportPanel importPanel = new ItemImportPanel();
      importPanel.initGUI();
    } else if (selectedOption == Action.IMPORT_POSITION.intValue()) {
      ImportPanel importPanel = new PositionImportPanel();
      importPanel.initGUI();
    } else if (selectedOption == Action.CREATE_NEW_COMMAND.intValue()) {
      CommandCreatingPanel commandCreatingPanel = new CommandCreatingPanel();
      commandCreatingPanel.initGUI();
    } else if (selectedOption == Action.EXPORT_TO_FILE.intValue()) {
      ExportPanel exportPanel = new ExportPanel();
      exportPanel.initGUI();
    }
  }

  public static void main(String[] args) {
    App app = new App();
    app.start();
  }
}
