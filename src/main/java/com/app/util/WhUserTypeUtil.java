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
public class WhUserTypeUtil {

	public void generatePie(String path,List<Object[]> list) {
		//Data to Datasets
		DefaultPieDataset dataset=new DefaultPieDataset();
	    for(Object[] ob:list) {
	    	dataset.setValue(ob[0].toString(), new Double(ob[1].toString()));
	    }
	
	    //Convert dataset to JfreeCharts
	    JFreeChart chart=ChartFactory.createPieChart3D("WHUSerType Model", dataset, true, true, true);
	    //Convert JfreeCharts to Jpeg images
	    
	    try {
	    	ChartUtils.saveChartAsJPEG(new File(path+"/resources/images/WHUserTypeA.jpg"), chart, 400	, 400);
	    }
	    catch(IOException e){
	    	e.printStackTrace();
	    }
	}
	
	public void generateBar(String path,List<Object[]> list) {
		//Data to Dataset
		DefaultCategoryDataset dataset=new DefaultCategoryDataset();
		for(Object[] ob:list) {
			dataset.setValue(new Double(ob[1].toString()), ob[0].toString(), " ");
		}
		//data to Jfreecharts
		JFreeChart chart=ChartFactory.createBarChart("WHUserType Report", "UserType", "count", dataset,PlotOrientation.HORIZONTAL,true,true,false);
	         

		//Convert JfreeChart into Image
		try {
			ChartUtils.saveChartAsJPEG(new File(path+"/resources/images/WHUserTypeB.jpg"), chart, 400, 400);
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
}
