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

import com.vetri.erp.ds.inventory.model.dto.ProdSectionDto;
import com.vetri.erp.ds.inventory.model.response.InventoryResponse;
import com.vetri.erp.ds.inventory.service.ProdSectionService;
import com.vetri.erp.ds.inventory.util.Constants;

@RestController
@RequestMapping("api/inventory/productSection/{orgId}/")

public class ProductSectionController {

	@Autowired
	ProdSectionService prodSectionService;

	@GetMapping
	ResponseEntity<InventoryResponse> getAllProductionSection(@PathVariable String orgId) {
		List<ProdSectionDto> response = prodSectionService.getAll(orgId);
		return ResponseEntity.ok(new InventoryResponse(Constants.SUCCESS, response));
	}

	@GetMapping("{id}")
	ResponseEntity<InventoryResponse> getByIdProductionSection(@PathVariable String orgId, @PathVariable Integer id) {
		try {
			ProdSectionDto response = prodSectionService.getbyId(orgId, id);
			return  ResponseEntity.ok(new InventoryResponse(Constants.SUCCESS, response));
		} catch (Exception e) {
			return  ResponseEntity.accepted().body(new InventoryResponse(Constants.WARN, e.getMessage()));
		}
	}

	@PutMapping
	ResponseEntity<InventoryResponse> updateProductionSection(@PathVariable String orgId, @RequestBody ProdSectionDto dto) {
		try {
			ProdSectionDto response = prodSectionService.update(orgId, dto);
			return  ResponseEntity.ok(new InventoryResponse(Constants.SUCCESS, response));
		} catch (Exception e) {
			return  ResponseEntity.accepted().body(new InventoryResponse(Constants.WARN, e.getMessage()));
		}
	}

	@PostMapping
	ResponseEntity<InventoryResponse> saveProductionSection(@PathVariable String orgId, @RequestBody ProdSectionDto dto) {
		dto.setCompanyId(orgId);
		ProdSectionDto response = prodSectionService.save(dto);
		return ResponseEntity.ok(new InventoryResponse(Constants.SUCCESS, response));
	}

	@DeleteMapping("{id}")
	ResponseEntity<InventoryResponse> deleteProductionSection(@PathVariable String orgId, @PathVariable Integer id) {
		prodSectionService.delete(orgId, id);
		return ResponseEntity.ok(new InventoryResponse(Constants.SUCCESS));
	}
}
