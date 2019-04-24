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
public class OrderMethodUtil {

	public void generatPie(String path,List<Object[]> data) {
		
		//Convert Data to Dataset
	DefaultPieDataset dataset=new DefaultPieDataset();
	for(Object[] ob:data) {
		dataset.setValue(ob[0].toString(), new Double(ob[1].toString()));
	}
	
  //Convert DataSet to JfreeChart
	JFreeChart chart=ChartFactory.createPieChart3D("OrderMethod Model", dataset, true, true, false);
	//Convert chart into image
	try {
		ChartUtils.saveChartAsJPEG(new File(path+"/resources/images/OrderMethodA.jpg"), chart, 400, 400);
	}
    catch(IOException e) {
    	e.printStackTrace();
    }
	}
	
	public void generateBar(String path,List<Object[]> data) {
		//Convert Data to Dataset
		DefaultCategoryDataset dataset=new DefaultCategoryDataset();
		for(Object[]ob:data) {
			dataset.setValue(new Double(ob[1].toString()), ob[0].toString(), " ");
		}
		
		//Convert Dataset to JfreeCharts
		JFreeChart chart=ChartFactory.createBarChart("OrderMethod Report", "Mode", "Count", dataset,PlotOrientation.HORIZONTAL,true,true,false);
		//Convert Charts into Images
		try {
			ChartUtils.saveChartAsJPEG(new File(path+"/resources/images/OrderMethodB.jpg"), chart, 400	, 400);
		}
		catch(IOException e) {
			e.printStackTrace();
			
		}
	}
}
