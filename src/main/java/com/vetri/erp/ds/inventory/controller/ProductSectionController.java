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
import com.vetri.erp.ds.inventory.service.ProdSectionService;

@RestController
@RequestMapping("api/{orgId}/inventory/productSection/")

public class ProductSectionController {

	@Autowired
	ProdSectionService prodSectionService;

	@GetMapping
	List<ProdSectionDto> getAllProductionSection(@PathVariable Integer orgId) {
		return prodSectionService.getAll(orgId);
	}

	@GetMapping("{id}")
	ProdSectionDto getByIdProductionSection(@PathVariable Integer orgId, @PathVariable Integer id) {
		return prodSectionService.getbyId(orgId, id);
	}

	@PutMapping
	ProdSectionDto updateProductionSection(@PathVariable Integer orgId, @RequestBody ProdSectionDto dto) {
		return prodSectionService.update(orgId, dto);
	}

	@PostMapping
	ProdSectionDto saveProductionSection(@PathVariable Integer orgId, @RequestBody ProdSectionDto dto) {
		return prodSectionService.save(dto);
	}

	@DeleteMapping("{id}")
	void deleteProductionSection(@PathVariable Integer orgId, @PathVariable Integer id) {
		prodSectionService.delete(orgId, id);
	}
}
