package com.vetri.erp.ds.inventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vetri.erp.ds.inventory.exception.InventoryException;
import com.vetri.erp.ds.inventory.model.dto.prodGroupDto;
import com.vetri.erp.ds.inventory.model.response.InventoryResponse;
import com.vetri.erp.ds.inventory.service.ProdGroupService;
import com.vetri.erp.ds.inventory.util.Constants;

@RestController
@RequestMapping("api/inventory/productGroup/{orgId}/")

public class ProductGroupController {

	@Autowired
	ProdGroupService prodGroupService;

	@GetMapping
	ResponseEntity<InventoryResponse> getAllProductGroup(@PathVariable String orgId) {
		List<prodGroupDto> response = prodGroupService.getAll(orgId);
		return ResponseEntity.ok(new InventoryResponse(Constants.SUCCESS, response));
	}

	@GetMapping("{id}")
	ResponseEntity<InventoryResponse> getByIdProductGroup(@PathVariable String orgId, @PathVariable Integer id) {
		try {
			prodGroupDto response = prodGroupService.getbyId(orgId, id);
			return  ResponseEntity.ok(new InventoryResponse(Constants.SUCCESS, response));
		} catch (InventoryException e) {
			return  ResponseEntity.accepted().body(new InventoryResponse(Constants.WARN, e.getMessage()));
		}
	}

	@PutMapping
	ResponseEntity<InventoryResponse> updateProductGroup(@PathVariable String orgId, @RequestBody prodGroupDto dto) {
		try {
			prodGroupDto response = prodGroupService.update(orgId, dto);
			return  ResponseEntity.ok(new InventoryResponse(Constants.SUCCESS, response));
		} catch (Exception e) {
			return  ResponseEntity.accepted().body(new InventoryResponse(Constants.WARN, e.getMessage()));
		}
	}

	@PostMapping
	ResponseEntity<InventoryResponse> saveProductGroup(@PathVariable String orgId, @RequestBody prodGroupDto dto) {
		dto.setCompanyId(orgId);
		prodGroupDto response = prodGroupService.save(dto);
		return ResponseEntity.ok(new InventoryResponse(Constants.SUCCESS, response));
	}

	@DeleteMapping("{id}")
	ResponseEntity<InventoryResponse> deleteProductGroup(@PathVariable String orgId, @PathVariable Integer id) {
		prodGroupService.delete(orgId, id);
		return ResponseEntity.ok(new InventoryResponse(Constants.SUCCESS));
	}
}
