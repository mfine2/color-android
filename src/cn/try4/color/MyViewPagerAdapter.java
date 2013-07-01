package cn.try4.color;

import java.util.List;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

public class MyViewPagerAdapter extends PagerAdapter {
    private List<View> listViews;  
    
    public MyViewPagerAdapter(List<View> listViews) {  
        this.listViews = listViews;  
    }  

    @Override  
    public void destroyItem(ViewGroup container, int position, Object object)   {     
        container.removeView(listViews.get(position));
        System.out.println("destroyItem:" + position);
    }  

    @Override  
    public Object instantiateItem(ViewGroup container, int position) {            
         container.addView(listViews.get(position), 0);  
         System.out.println("instantiateItem:" + position);
         return listViews.get(position);  
    }

    @Override  
    public int getCount() {
    	System.out.println("getCount:" + listViews.size());
        return  listViews.size();  
    }  
      
    @Override  
    public boolean isViewFromObject(View arg0, Object arg1) {             
        return arg0==arg1;  
    }  
}
