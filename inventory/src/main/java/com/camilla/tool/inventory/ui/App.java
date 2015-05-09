package com.camilla.tool.inventory.ui;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Date;
import java.util.Properties;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.WindowConstants;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import com.camilla.tool.inventory.enums.Actions;
import com.camilla.tool.inventory.ui.common.DateLabelFormatter;
import com.camilla.tool.inventory.ui.common.EnhancedCombobox;

public class App {

  private JFrame frame;
  private JPanel mainPane;

  public void createGUI() {
    frame = new JFrame("Inventory");

    mainPane = new JPanel(false);
    mainPane.setLayout(new GridBagLayout());
    mainPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

    addItemLabel();
    addItemComboBox();
    addPositionLabel();
    addPositionComboBox();
    addInputTypePane();
    addCreationDateLabel();
    addCreationDateDatePicker();
    addQuantityLabel();
    addQuantityTextField();
    addProceedButton();

    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    frame.getContentPane().add(mainPane);
    frame.setBounds(20, 20, 640, 480);

    showActionChoosingDialog();
  }

  private void showActionChoosingDialog() {
    String[] options =
        new String[] {"Thêm thông tin sản phẩm", "Thêm thông tin kho hàng", "Tạo lệnh xuất/nhập hàng",
            "Tạo file báo cáo"};
    int selectedOption =
        JOptionPane.showOptionDialog(mainPane, "Vui lòng chọn một hành động dưới đây:", "Quản lý kho hàng",
            JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[2]);

    if (selectedOption == Actions.IMPORT_ITEM.intValue()) {
      frame.setVisible(true);
    } else if (selectedOption == Actions.IMPORT_POSITION.intValue()) {
      frame.setVisible(true);
    } else if (selectedOption == Actions.CREATE_NEW_COMMAND.intValue()) {
      frame.setVisible(true);
    } else if (selectedOption == Actions.EXPORT_TO_FILE.intValue()) {
      frame.setVisible(true);
    } else if (!frame.isVisible()) {
      System.exit(0);
    }
  }

  private void addProceedButton() {
    JButton proceedButton = new JButton("OK");
    GridBagConstraints c = createNewConstraint(0, 5);
    c.gridwidth = 2;
    c.anchor = GridBagConstraints.CENTER;

    mainPane.add(proceedButton, c);
  }

  private void addQuantityTextField() {
    SpinnerModel model = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1);
    JSpinner spinner = new JSpinner(model);
    GridBagConstraints c = createNewConstraint(1, 4);
    c.anchor = GridBagConstraints.WEST;
    mainPane.add(spinner, c);
  }

  private void addQuantityLabel() {
    JLabel creationDateLabel = new JLabel("Số lượng: ");
    GridBagConstraints c = createNewConstraint(0, 4);
    c.anchor = GridBagConstraints.WEST;
    mainPane.add(creationDateLabel, c);
  }

  private void addCreationDateLabel() {
    JLabel creationDateLabel = new JLabel("Ngày tạo: ");
    GridBagConstraints c = createNewConstraint(0, 3);
    c.anchor = GridBagConstraints.WEST;
    mainPane.add(creationDateLabel, c);
  }

  private void addCreationDateDatePicker() {
    UtilDateModel model = new UtilDateModel();
    model.setValue(new Date());

    Properties p = new Properties();
    p.put("text.today", "Today");
    p.put("text.month", "Month");
    p.put("text.year", "Year");

    JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
    JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());

    GridBagConstraints c = createNewConstraint(1, 3);
    c.anchor = GridBagConstraints.WEST;

    mainPane.add(datePicker, c);
  }

  private void addInputTypePane() {

    JPanel inputPane = new JPanel(false);
    inputPane.setLayout(new FlowLayout());

    JRadioButton importRadioButton = new JRadioButton("Nhập kho");
    inputPane.add(importRadioButton);

    JRadioButton exportRadioButton = new JRadioButton("Xuất kho");
    inputPane.add(exportRadioButton);

    ButtonGroup buttonGroup = new ButtonGroup();
    buttonGroup.add(importRadioButton);
    buttonGroup.add(exportRadioButton);

    GridBagConstraints c = createNewConstraint(1, 2);
    c.anchor = GridBagConstraints.WEST;

    mainPane.add(inputPane, c);
  }

  private void addPositionComboBox() {
    String[] positions = new String[] {"POS-01", "POS-02", "AOS-00", "XDP-00"};
    JComboBox<String> positionComboBox = new JComboBox<String>(positions);
    positionComboBox.setEditable(true);
    new EnhancedCombobox(positionComboBox);
    GridBagConstraints c = createNewConstraint(1, 1, GridBagConstraints.HORIZONTAL, 0.1D);
    mainPane.add(positionComboBox, c);
  }

  private void addPositionLabel() {
    JLabel positionLabel = new JLabel("Mã kho:");
    GridBagConstraints c = createNewConstraint(0, 1);
    c.anchor = GridBagConstraints.WEST;
    mainPane.add(positionLabel, c);
  }

  private void addItemComboBox() {
    String[] items = new String[] {"Huy", "Ester", "Jordi", "Jordina", "Jorge", "Sergi"};
    JComboBox<String> itemComboBox = new JComboBox<String>(items);
    itemComboBox.setEditable(true);
    new EnhancedCombobox(itemComboBox);
    GridBagConstraints c = createNewConstraint(1, 0, GridBagConstraints.HORIZONTAL, 0.1D);
    mainPane.add(itemComboBox, c);
  }

  private void addItemLabel() {
    JLabel itemLabel = new JLabel("Mã hàng:");
    GridBagConstraints c = createNewConstraint(0, 0);
    c.anchor = GridBagConstraints.WEST;
    mainPane.add(itemLabel, c);
  }

  private GridBagConstraints createNewConstraint(int gridx, int gridy, int fill, double weightx) {
    GridBagConstraints c = createNewConstraint(gridx, gridy);
    c.fill = fill;
    c.weightx = weightx;
    return c;
  }

  private GridBagConstraints createNewConstraint(int gridx, int gridy) {
    GridBagConstraints c = new GridBagConstraints();
    c.gridx = gridx;
    c.gridy = gridy;
    c.insets = new Insets(0, 0, 5, 5);
    return c;
  }

  public static void main(String[] args) {
    App app = new App();
    app.createGUI();
  }
}
