package com.vetri.erp.ds.inventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vetri.erp.ds.inventory.dto.ProdSectionDto;
import com.vetri.erp.ds.inventory.service.InventoryService;

@RestController
@RequestMapping("api/{orgId}/inventory")

public class InventoryController {

	@Autowired
	InventoryService inventoryService;

	@GetMapping("productSections")
	List<ProdSectionDto> getAllProductionSection(@PathVariable Integer orgId) {
		return inventoryService.getAllProductionSection(orgId);
	}

	@GetMapping("productSection/{id}")
	ProdSectionDto getByIdProductionSection(@PathVariable Integer orgId, @PathVariable Integer id) {
		return inventoryService.getbyIdProductionSection(orgId, id);
	}

	@PutMapping("productSection")
	ProdSectionDto updateProductionSection(@PathVariable Integer orgId, @RequestBody ProdSectionDto dto) {
		return inventoryService.updateProductionSection(orgId, dto);
	}

	@PostMapping("productSection")
	ProdSectionDto saveProductionSection(@PathVariable Integer orgId, @RequestBody ProdSectionDto dto) {
		return inventoryService.saveProductionSection(dto);
	}

	@DeleteMapping("productSection{id}")
	void deleteProductionSection(@PathVariable Integer orgId, @PathVariable Integer id) {
		inventoryService.deleteProductionSection(orgId, id);
	}
}
