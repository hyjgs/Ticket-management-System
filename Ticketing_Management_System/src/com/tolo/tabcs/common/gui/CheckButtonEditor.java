package com.tolo.tabcs.common.gui;

import java.awt.Component;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;

public class CheckButtonEditor extends DefaultCellEditor implements ItemListener {
	private static final long serialVersionUID = 198567563L;
	private JCheckBox button;

	public CheckButtonEditor(JCheckBox checkBox) {
		super(checkBox);
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
		//通知所有对此事件类型的通知感兴趣的已注册侦听器。以延迟方式创建事件实例。 
	}
}