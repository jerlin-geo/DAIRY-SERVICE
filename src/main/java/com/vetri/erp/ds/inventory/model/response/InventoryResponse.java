package com.vetri.erp.ds.inventory.model.response;

import com.vetri.erp.ds.inventory.model.ErrorDetail;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class InventoryResponse {

	
	public InventoryResponse(String message, Object body) {
		super();
		this.message = message;
		this.body = body;
	}
	
	public InventoryResponse(String message) {
		super();
		this.message = message;
	}

	private String message;
	
	private Object body;
	
	private ErrorDetail errorDetail;
	
	
}
