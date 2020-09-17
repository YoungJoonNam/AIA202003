package com.wifi.order.buyer.service;

import java.util.List;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wifi.order.dao.OrderDao;
import com.wifi.order.model.MyItemDTO;


//내 구매글 
@Service
public class MyOrderService {
	
	private OrderDao dao;
	
	@Autowired
	private SqlSessionTemplate template;

	public List<MyItemDTO> getMyOrder(int midx) {
		
		dao = template.getMapper(OrderDao.class);
		System.out.println("내 구매글 service");
		
		List<MyItemDTO> list = dao.getMyOrder(midx);
		
		
		for(int i=0; i<list.size(); i++) {
			
			// 참여상태. 결제상태 확인 ㅡ> 상태라벨 set
			int ostate = list.get(i).getOstate();   // 주문상태 : 0 참여중, 1 거절, -1 null
			int pstate = list.get(i).getPstate();	// 결제상태 : 0 미수령, 1 수령, -1 null
			
			
			// 참여중. 결제 null
			if(ostate == 0 && pstate == -1) {		
				list.get(i).setLabel("참여중");
				continue;
			
				
			// 거절. 결제 null
			} else if(ostate == 1 && pstate == -1) { 
				list.get(i).setLabel("다음기회에...");
				continue;
			
				
			// 참여중. 미수령	
			} else if(ostate == 0 && pstate == 0) {  
				list.get(i).setLabel("구매자");
				continue;
			
				
			// 참여중. 수령	
			} else if(ostate == 0 && pstate == 1) {  
				list.get(i).setLabel("구매완료");
				continue;
			};
			
			
		};
		
		
		return list;
	};



};
