package com.itlogiclab.restaurant.order.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itlogiclab.restaurant.order.domain.dto.commands.CreateOrderAddressCommand;
import com.itlogiclab.restaurant.order.domain.dto.commands.CreateOrderCommand;
import com.itlogiclab.restaurant.order.domain.dto.commands.CreateOrderItemCommand;

public class FileFormatConverter<T> {
	
	public String getJSON(T request) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		String str = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(request);
		System.out.println(str);
		return str;
	}
	
	
	public static void main(String[] args) {
		FileFormatConverter<CreateOrderCommand> file = new FileFormatConverter<CreateOrderCommand>();
		
		List<CreateOrderItemCommand> items = new ArrayList<CreateOrderItemCommand>();
		CreateOrderItemCommand item = CreateOrderItemCommand.builder()
				.withPrice(new BigDecimal(100))
				.withProductId(100L)
				.withQuantity(10)
				.build();
		items.add(item);
		item = CreateOrderItemCommand.builder()
				.withPrice(new BigDecimal(100))
				.withProductId(100L)
				.withQuantity(10)
				.build();
		items.add(item);
		
		
		CreateOrderCommand command = CreateOrderCommand.builder()
				.withPrice(new BigDecimal(1000.95))
				.withCustomerId(100L)
				.withRestaurantId(100L)
				.withAddress(CreateOrderAddressCommand.builder()
						.withLine1("C-1804, Sethi Max Royal")
						.withLine2("Sector-76")
						.withCity("Noida")
						.withState("UP")
						.withCountry("India")
						.build())
				.withItems(items)
				.build();
		
		
		
		try {
			 file.getJSON(command);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
