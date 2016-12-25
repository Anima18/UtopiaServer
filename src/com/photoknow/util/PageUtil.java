package com.photoknow.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class PageUtil {
	//将页数制成List<>,用于页数跳转下拉框
	public static List<Integer> getPageList(Integer hasPage,int page){
		List<Integer> page_l = new ArrayList<Integer>();
		int start =1,end =10;
		if(hasPage <= 10){
			end = hasPage;
		}else if(hasPage-page < 5){
			start = hasPage-9;
			end = hasPage;
		}else{
			if(page>5){
				start = page-5+1;
				if(hasPage - page >5){
					end = page +5;
				}else{
					end = hasPage;
				}
			}
			
		}
		
		
	
		for(int i= start;i <= end;i++){
			page_l.add(i);
		}
		
		return page_l;
	}
	//计算总页数
	public static int findAllPages(int perFolioAmount,Long has){
		int pagenum;
		int num = has.intValue();
		pagenum = num/perFolioAmount;
		num = num%perFolioAmount;
		if(num>0){
			pagenum++;
		}
		return pagenum;
	}
	
	/**
	 * 获取当前页
	 * @param page
	 * @param pageNum
	 * @return
	 */
	public static int gainPage(int page,int pageNum){
		if (page <= 0) {
			page = 1;
		}
		if (pageNum == 0) {
			page = 0;
		} else {
			if (page <= 0) {
				page = 1;
			} else if (page > pageNum) {
				page = pageNum;
			}
		}
		return page;
	}
	
	public static String gainHql(String baseHql,Map<String,String> propertyMap,Map<String,String> orderByMap){
		boolean isOrderBy = false;
		String hql ="";
		StringBuffer hqlBuffer = new StringBuffer(baseHql);
		if(propertyMap != null && propertyMap.size()>0){
			Iterator<String> keys =propertyMap.keySet().iterator();
			while(keys.hasNext()){
				String property = keys.next();
				String propertyValue = propertyMap.get(property);
				hqlBuffer.append(" and en."+property+" = '"+propertyValue+"'");
			}
		}
		
		if(orderByMap != null && orderByMap.size()>0){
			hqlBuffer.append(" order by");
			Iterator<String> keys =orderByMap.keySet().iterator();
			while(keys.hasNext()){
				String property = keys.next();
				String propertyValue = orderByMap.get(property);
				hqlBuffer.append(" en."+property+" "+propertyValue+",");
			}
			isOrderBy = true;
			
		}
		hql = hqlBuffer.toString();
		if(isOrderBy){
			hql = hql.substring(0, hql.length()-1);
		}
		return hql;
	}
}
