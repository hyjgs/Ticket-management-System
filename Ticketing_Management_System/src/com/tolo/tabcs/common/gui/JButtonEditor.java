package com.tolo.tabcs.common.gui;

import java.awt.Component;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.*;
/* DefaultCellEditor 是表单元格和树单元格的默认编辑器*/
public class JButtonEditor extends DefaultCellEditor implements ItemListener {
	private static final long serialVersionUID = 198567563L;
	private JCheckBox button;

	public JButtonEditor(JCheckBox box) {
		super(box);
	}

	public Component getTableCellEditorComponent(JTable table, Object value,
			boolean isSelected, int row, int column) {
		if (value == null)
			return null;
		button = (JCheckBox) value;
		button.addItemListener(this);
		return (Component) value;
	}

	public Object getCellEditorValue() {
		button.removeItemListener(this);
		return button;
	}

	public void itemStateChanged(ItemEvent e) {
		super.fireEditingStopped();
	}
}