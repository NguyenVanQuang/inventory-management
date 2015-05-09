package com.camilla.tool.inventory.enums;

public enum Actions {

  IMPORT_ITEM(0), IMPORT_POSITION(1), CREATE_NEW_COMMAND(2), EXPORT_TO_FILE(3);

  private int intValue;

  private Actions(int intValue) {
    this.intValue = intValue;
  }

  public int intValue() {
    return intValue;
  }
}
