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

import com.vetri.erp.ds.inventory.model.dto.CrateMasterDto;
import com.vetri.erp.ds.inventory.model.response.InventoryResponse;
import com.vetri.erp.ds.inventory.service.CrateMasterService;
import com.vetri.erp.ds.inventory.util.Constants;

@RestController
@RequestMapping("api/inventory/crate/{orgId}/")
public class CrateMasterController {

	@Autowired
	CrateMasterService crateService;

	@GetMapping
	ResponseEntity<InventoryResponse> getAllCrate(@PathVariable Integer orgId) {
		List<CrateMasterDto> response = crateService.getAll(orgId);
		return ResponseEntity.ok(new InventoryResponse(Constants.SUCCESS, response));
	}

	@GetMapping("{id}")
	ResponseEntity<InventoryResponse> getByIdCrate(@PathVariable Integer orgId, @PathVariable Integer id) {
		try {
			CrateMasterDto response = crateService.getbyId(orgId, id);
			return  ResponseEntity.ok(new InventoryResponse(Constants.SUCCESS, response));
		} catch (Exception e) {
			return  ResponseEntity.accepted().body(new InventoryResponse(Constants.WARN, e.getMessage()));
		}
	}

	@PutMapping
	ResponseEntity<InventoryResponse> updateCrate(@PathVariable Integer orgId, @RequestBody CrateMasterDto dto) {
		try {
			CrateMasterDto response = crateService.update(orgId, dto);
			return  ResponseEntity.ok(new InventoryResponse(Constants.SUCCESS, response));
		} catch (Exception e) {
			return  ResponseEntity.accepted().body(new InventoryResponse(Constants.WARN, e.getMessage()));
		}
	}

	@PostMapping
	ResponseEntity<InventoryResponse> saveCrate(@PathVariable Integer orgId, @RequestBody CrateMasterDto dto) {
		dto.setCompanyId(orgId);
		CrateMasterDto response = crateService.save(dto);
		return ResponseEntity.ok(new InventoryResponse(Constants.SUCCESS, response));
	}

	@DeleteMapping("{id}")
	ResponseEntity<InventoryResponse> deleteCrate(@PathVariable Integer orgId, @PathVariable Integer id) {
		crateService.delete(orgId, id);
		return ResponseEntity.ok(new InventoryResponse(Constants.SUCCESS));
	}
}
