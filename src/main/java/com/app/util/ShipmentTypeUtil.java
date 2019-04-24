package com.app.util;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.springframework.stereotype.Component;

@Component
public class ShipmentTypeUtil {
public void generatePie(String path,List<Object[]> data) {
		
		//data should be converted to DataSet	
		DefaultPieDataset dataset=new DefaultPieDataset();
		for(Object[] ob:data) {
			dataset.setValue(ob[0].toString(), new Double(ob[1].toString()));
		}
		
		//dataset should be converted to JFreeChart
		// using ChartFactory
		JFreeChart chart=ChartFactory.createPieChart3D("Shipment Type Mode", dataset, true, true, false);
		
		//JFreeChart should be converted to Image
		//using ChartUtils
		try {
			ChartUtils.saveChartAsJPEG(new File(path+"/resources/images/shipmentA.jpg"), chart, 400, 400);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

public void generateBar(String path,List<Object[]> data) {
	
	//data should be converted to dataset
	DefaultCategoryDataset dataset=new DefaultCategoryDataset();
	for(Object[] ob:data) {
		dataset.setValue(new Double(ob[1].toString()),ob[0].toString()," ");
	}
	//data should be converted to JfreeCharts
	JFreeChart chart=ChartFactory.createBarChart("Shipment Type Report", "Mode", "Count", dataset, PlotOrientation.VERTICAL, true, true,false);
	
	//BarChart conversion to Image
	try {
		ChartUtils.saveChartAsJPEG(new File(path+"resources/images/shipmentB.jpg"), chart, 400, 400);
	}
	catch(IOException e){
		e.printStackTrace();
	}
}
}




