package com.vetri.erp.ds.inventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/inventory")

public class InventoryController {

	@Autowired
	InventoryService inventoryService;
	
	@GetMapping("productSection/getAll")
	List<ProdSectionDto> getAllProductionSection() {
		return inventoryService.getAllProductionSection();
	}
	
	@GetMapping("productSection/{id}")
	ProdSectionDto getByIdProductionSection(@PathVariable Integer id) {
		return inventoryService.getbyIdProductionSection(id);
	}
	
	@PutMapping("productSection")
	ProdSectionDto updateProductionSection(@RequestBody ProdSectionDto dto) {
		return inventoryService.updateProductionSection(dto);
	}
	
	@PostMapping("productSection")
	ProdSectionDto saveProductionSection(@RequestBody ProdSectionDto dto) {
		return inventoryService.saveProductionSection(dto);
	}
}
