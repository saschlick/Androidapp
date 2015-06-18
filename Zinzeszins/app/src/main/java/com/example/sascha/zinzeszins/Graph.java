package com.example.sascha.zinzeszins;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.provider.SyncStateContract;
import android.util.DisplayMetrics;

import org.achartengine.ChartFactory;
import org.achartengine.chart.PointStyle;
import org.achartengine.model.TimeSeries;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;

import java.sql.Time;

/**
 * Created by Sascha on 17.06.2015.
 */
public class Graph {



    public Intent getIntent(Context context) {
        int[] x ={0,2,3,4,5,6,7,8,9,10};
        int[] y ={0,15,25,45,50,60,75,90,105,110};
        final int TEXT_SIZE_XHDPI = 24;
        final int TEXT_SIZE_HDPI = 20;
        final int TEXT_SIZE_MDPI = 18;
        final int TEXT_SIZE_LDPI = 13;

        TimeSeries series= new TimeSeries("Kapital");
        for (int i=0;i<x.length;i++){
            series.add(x[i],y[i]);
        }
        XYMultipleSeriesDataset dataset = new XYMultipleSeriesDataset();
        dataset.addSeries(series);

        XYSeriesRenderer renderer = new XYSeriesRenderer();
        XYSeriesRenderer.FillOutsideLine fill = new XYSeriesRenderer.FillOutsideLine(XYSeriesRenderer.FillOutsideLine.Type.BOUNDS_ALL);
        fill.setColor(Color.GRAY);
        renderer.addFillOutsideLine(fill);

        renderer.setPointStyle(PointStyle.CIRCLE);
        renderer.setPointStrokeWidth((float) 6.5);
        renderer.setShowLegendItem(false);
        renderer.setFillPoints(false);
        renderer.setLineWidth((float) 6.5);


        XYMultipleSeriesRenderer mRenderer = new XYMultipleSeriesRenderer();
        mRenderer.addSeriesRenderer(renderer);
        mRenderer.setPanEnabled(false, false);
        mRenderer.setZoomEnabled(false, false);
        mRenderer.setXTitle("Jahre");
        mRenderer.setChartTitle("Kapitalentwicklung");
        mRenderer.setChartTitleTextSize(50);
        mRenderer.setApplyBackgroundColor(true);
        mRenderer.setBackgroundColor(Color.BLACK);
        mRenderer.setLabelsTextSize(20);
        mRenderer.setAxisTitleTextSize(25);
        mRenderer.setXAxisMax(10);
        mRenderer.setXAxisMin(0);



        Intent intent = ChartFactory.getLineChartIntent(context,dataset,mRenderer,"Kapital");
        return intent;

    }
}
