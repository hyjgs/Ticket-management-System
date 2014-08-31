package com.tolo.tabcs.common.gui;

import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

//表格的渲染器
public class JTableButtonRenderer implements TableCellRenderer {

	public JTableButtonRenderer() {
	}

	public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row, int column) {
		if (value instanceof Component) {
			return (Component) value;
		}
		return null;
	}
}
