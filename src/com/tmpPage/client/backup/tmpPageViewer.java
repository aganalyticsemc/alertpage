//package com.tmpPage.client.backup;
//
//import org.gwtbootstrap3.client.ui.Pagination;
//import org.gwtbootstrap3.client.ui.constants.ButtonType;
//import org.gwtbootstrap3.client.ui.constants.IconType;
//import org.gwtbootstrap3.client.ui.gwt.ButtonCell;
//import org.gwtbootstrap3.client.ui.gwt.DataGrid;
//
//import com.google.gwt.cell.client.FieldUpdater;
//import com.google.gwt.core.client.GWT;
//import com.google.gwt.uibinder.client.UiBinder;
//import com.google.gwt.uibinder.client.UiField;
//import com.google.gwt.user.cellview.client.AbstractCellTable;
//import com.google.gwt.user.cellview.client.Column;
//import com.google.gwt.user.cellview.client.SimplePager;
//import com.google.gwt.user.cellview.client.TextColumn;
//import com.google.gwt.user.client.Window;
//import com.google.gwt.user.client.ui.Composite;
//import com.google.gwt.user.client.ui.Widget;
//import com.google.gwt.view.client.ListDataProvider;
//import com.google.gwt.view.client.RangeChangeEvent;
//
//public class tmpPageViewer extends Composite {
//
//	private static tmpPageViewerUiBinder uiBinder = GWT.create(tmpPageViewerUiBinder.class);
//
//	interface tmpPageViewerUiBinder extends UiBinder<Widget, tmpPageViewer> {
//	}
//
//	@UiField(provided = true)
//    DataGrid<TableTestPojo> dataGrid = new DataGrid<TableTestPojo>(10);
//    @UiField
//    Pagination dataGridPagination;
//	
//    private SimplePager dataGridPager = new SimplePager();
//    private ListDataProvider<TableTestPojo> dataGridProvider = new ListDataProvider<TableTestPojo>();
//    
////    Create mock data
//    private void initMockData(final Pagination pagination, final SimplePager simplePager, final ListDataProvider<TableTestPojo> dataProvider) {
//        for (int i = 0; i < 25; i++) {
//            dataProvider.getList().add(new TableTestPojo("Test " + i, "Test " + i, "Test " + i));
//        }
//        dataProvider.flush();
//        pagination.rebuild(simplePager);
//    }
//	
//    private void initTable(final AbstractCellTable<TableTestPojo> grid, final SimplePager pager, final Pagination pagination, final ListDataProvider<TableTestPojo> dataProvider) {
//    final TextColumn<TableTestPojo> col1 = new TextColumn<TableTestPojo>() {
//
//        @Override
//        public String getValue(final TableTestPojo object) {
//            return String.valueOf(object.getField1());
//        }
//    };
//    grid.addColumn(col1, "Field 1");
//
//    final TextColumn<TableTestPojo> col2 = new TextColumn<TableTestPojo>() {
//
//        @Override
//        public String getValue(final TableTestPojo object) {
//            return String.valueOf(object.getField1());
//        }
//    };
//    grid.addColumn(col2, "Field 2");
//
//    final TextColumn<TableTestPojo> col3 = new TextColumn<TableTestPojo>() {
//
//        @Override
//        public String getValue(final TableTestPojo object) {
//            return String.valueOf(object.getField1());
//        }
//    };
//    grid.addColumn(col3, "Field 3");    
//    
//	    final Column<TableTestPojo, String> col4 = new Column<TableTestPojo, String>(new ButtonCell(ButtonType.DANGER)) {
//	    @Override
//	    public String getValue(TableTestPojo object) {
//	        return "OPEN";
//	    }
//	};
//	col4.setFieldUpdater(new FieldUpdater<TableTestPojo, String>() {
//	    @Override
//	    public void update(int index, TableTestPojo object, String value) {
//	        Window.alert("Clicked!");
//	    }
//	});
//	grid.addColumn(col4, "FIELD 4");
//    
//    
//    
//    grid.addRangeChangeHandler(new RangeChangeEvent.Handler() {
//
//        @Override
//        public void onRangeChange(final RangeChangeEvent event) {
//            pagination.rebuild(pager);
//        }
//    });
//
//    pager.setDisplay(grid);
//    pagination.clear();
//    dataProvider.addDataDisplay(grid);
//    }
//    
//	public tmpPageViewer() {
//		initWidget(uiBinder.createAndBindUi(this));
//		initTable(dataGrid, dataGridPager, dataGridPagination, dataGridProvider);
//		initMockData(dataGridPagination, dataGridPager, dataGridProvider);
//		
//	}
//
//}
