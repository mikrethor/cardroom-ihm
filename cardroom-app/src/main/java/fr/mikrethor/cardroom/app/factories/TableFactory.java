package fr.mikrethor.cardroom.app.factories;

import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

public class TableFactory {
    private static TableFactory instance;
    private int style = SWT.MULTI | SWT.FULL_SELECTION | SWT.BORDER
            | SWT.H_SCROLL | SWT.V_SCROLL;

    private TableFactory() {
        super();
    }

    public static TableFactory getInstance() {
        if (instance == null) {
            instance = new TableFactory();
        }
        return instance;
    }

    public TableViewer getTable(final Composite parent, final int style,
            String[] titles, int[] bounds, final ColumnLabelProvider[] colsLabel) {
        TableViewer tableViewer = new TableViewer(parent, style);
        TableViewerColumn col;
        for (int i = 0; i < colsLabel.length; i++) {
            col = new TableViewerColumn(tableViewer, SWT.CENTER);
            final TableColumn column = col.getColumn();
            column.setText(titles[i]);
            column.setWidth(bounds[i]);
            column.setResizable(true);
            column.setMoveable(true);
            col.setLabelProvider(colsLabel[i]);
        }

        final Table table = tableViewer.getTable();
        table.setHeaderVisible(true);
        table.setLinesVisible(true);
        return tableViewer;
    }

    public TableViewer getTable(final Composite parent, String[] titles,
            int[] bounds, final ColumnLabelProvider[] colsLabel) {

        return getTable(parent, style, titles, bounds, colsLabel);
    }
}
