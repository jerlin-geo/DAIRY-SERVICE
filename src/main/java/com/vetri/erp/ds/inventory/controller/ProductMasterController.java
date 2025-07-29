package com.vetri.erp.ds.inventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vetri.erp.ds.inventory.entity.ProductMasterEntity;
import com.vetri.erp.ds.inventory.model.response.InventoryResponse;
import com.vetri.erp.ds.inventory.service.ProductService;
import com.vetri.erp.ds.inventory.util.Constants;

@RestController
@RequestMapping("api/inventory/product/{orgId}/")
public class ProductMasterController {

	@Autowired
	ProductService productService;

	@GetMapping
	ResponseEntity<InventoryResponse> getAllUom(@PathVariable Integer orgId) {
		List<ProductMasterEntity> response = productService.getAll(orgId);
		return ResponseEntity.ok(new InventoryResponse(Constants.SUCCESS, response));
	}
}
