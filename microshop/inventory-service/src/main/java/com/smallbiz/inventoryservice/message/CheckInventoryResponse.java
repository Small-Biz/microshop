package com.smallbiz.inventoryservice.message;

import java.util.List;

import com.smallbiz.inventoryservice.model.InventoryModel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CheckInventoryResponse{	
	private List<InventoryModel> inventoryList;
}
