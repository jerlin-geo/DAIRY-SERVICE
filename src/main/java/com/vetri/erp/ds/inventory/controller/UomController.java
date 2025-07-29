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

import com.vetri.erp.ds.inventory.model.dto.UomDto;
import com.vetri.erp.ds.inventory.model.response.InventoryResponse;
import com.vetri.erp.ds.inventory.service.UomService;
import com.vetri.erp.ds.inventory.util.Constants;

@RestController
@RequestMapping("api/inventory/uom/{orgId}/")
public class UomController {

	@Autowired
	UomService uomService;

	@GetMapping
	ResponseEntity<InventoryResponse> getAllUom(@PathVariable Integer orgId) {
		List<UomDto> response = uomService.getAll(orgId);
		return ResponseEntity.ok(new InventoryResponse(Constants.SUCCESS, response));
	}

	@GetMapping("{id}")
	ResponseEntity<InventoryResponse> getByIdUom(@PathVariable Integer orgId, @PathVariable Integer id) {
		try {
			UomDto response = uomService.getbyId(orgId, id);
			return  ResponseEntity.ok(new InventoryResponse(Constants.SUCCESS, response));
		} catch (Exception e) {
			return  ResponseEntity.accepted().body(new InventoryResponse(Constants.WARN, e.getMessage()));
		}
	}

	@PutMapping
	ResponseEntity<InventoryResponse> updateUom(@PathVariable Integer orgId, @RequestBody UomDto dto) {
		try {
			UomDto response = uomService.update(orgId, dto);
			return  ResponseEntity.ok(new InventoryResponse(Constants.SUCCESS, response));
		} catch (Exception e) {
			return  ResponseEntity.accepted().body(new InventoryResponse(Constants.WARN, e.getMessage()));
		}
	}

	@PostMapping
	ResponseEntity<InventoryResponse> saveUom(@PathVariable Integer orgId, @RequestBody UomDto dto) {
		dto.setCompanyId(orgId);
		UomDto response = uomService.save(dto);
		return ResponseEntity.ok(new InventoryResponse(Constants.SUCCESS, response));
	}

	@DeleteMapping("{id}")
	ResponseEntity<InventoryResponse> deleteUom(@PathVariable Integer orgId, @PathVariable Integer id) {
		uomService.delete(orgId, id);
		return ResponseEntity.ok(new InventoryResponse(Constants.SUCCESS));
	}
}
