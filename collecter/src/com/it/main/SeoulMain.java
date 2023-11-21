package com.it.main;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.it.dao.DataDAO;
import com.it.dao.ImgVO;
import com.it.dao.SeoulLocationVO;
public class SeoulMain {

	private static int J =1360;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        SeoulMain sm=new SeoulMain();
        //sm.seoulNature();
        sm.update();
        
	}
	
	public void update()
	{
		DataDAO dao=new DataDAO();
		try
		{
			
		
				Document doc=Jsoup.connect("https://www.wvproject.co.kr/shop/shopdetail.html?branduid=992869&search=%25BF%25CD%25C7%25CE%2B%25C8%25C4%25B5%25E5&sort=sellcnt&xcode=042&mcode=004&scode=004&GfDT=bm17W1g%3D").get();
				
				Elements subimg1 = doc.select("div.prd-detail p img").eq(1); // 이미지
	            Elements subimg2 = doc.select("div.prd-detail p img").eq(2); // 이미지
	            Elements subimg3 = doc.select("div.prd-detail p img").eq(3); // 이미지
	            Elements subimg4 = doc.select("div.prd-detail p img").eq(4); // 이미지
				
				
//	            Elements subimg1 = doc.select("div.prd-detail p img").eq(4); // 이미지
//	            Elements subimg2 = doc.select("div.prd-detail p img").eq(5); // 이미지
//	            Elements subimg3 = doc.select("div.prd-detail p img").eq(6); // 이미지
//	            Elements subimg4 = doc.select("div.prd-detail p img").eq(7); // 이미지
	            
	              try
	              {
	               
	               
	               String url1 = subimg1.attr("src");
	               String url2 = subimg2.attr("src");
	               String url3 = subimg3.attr("src");
	               String url4 = subimg4.attr("src");
	               
	               System.out.println(url1);
	               System.out.println(url2);
	               System.out.println(url3);
	               System.out.println(url4);
					
				
	               
	               
	               
					
					
					  ImgVO vo = new ImgVO(); vo.setSubimg1(url4); vo.setSubimg2(url2);
					  vo.setSubimg3(url4); vo.setSubimg4(url4);
					  
					  dao.seoulLocationUpdate(vo);
					 
					 
					 
					 
					 
					 
					 
					 
				}catch(Exception ex) {}
			
		}catch(Exception ex){}
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	
	public void seoulNature()
	{
		DataDAO dao=new DataDAO();
		try
		{
			
			for(int i=0;i<=7;i++)
			{
				Document doc=Jsoup.connect("https://www.wvproject.co.kr/shop/shopbrand.html?search=&code=&page=38&sort=sellcnt&money1=&money2=&prize1=&company1=&content1=&brcode=").get();
				
				Elements img=doc.select("div.prdImg a img"); // 이미지
				
				Elements itemName=doc.select("div.name a"); // 상품명
				
				Elements sale=doc.select("div.list_info span.price02"); // 할인 전 금액
				
				
				try
				{
					System.out.println("번호:"+i);
					
					String name = itemName.get(i).text();
					
					name = name.replaceAll("\\[\\d{1,2}/\\d{1,2} 예약배송\\]", "");
					
					name = name.replaceAll(".{8}$", "");
					System.out.println(name);
					
					String url = img.get(i).attr("src");
					url = "https://www.wvproject.co.kr"+url;
					System.out.println(url);
					
					String salePrice = sale.get(i).text();
					int price = 					Integer.parseInt(salePrice.replaceAll("[^0-9]", ""));
					
					System.out.println(price);
					
					SeoulLocationVO vo = new SeoulLocationVO();
					vo.setItemNum(J);
					vo.setItemName(name);
					vo.setMainImg(url);
					vo.setSale(price);
					
					dao.seoulLocationInsert(vo);
					J++;
				}catch(Exception ex) {}
			}
		}catch(Exception ex){}
	}
	*/
}
