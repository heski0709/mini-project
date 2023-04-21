package com.cafe.controller;

import java.util.ArrayList;
import java.util.List;

import com.cafe.dto.OptionDTO;
import com.cafe.dto.TypeDTO;

public class CafeManager {
	 private List<TypeDTO> typelist;

     public CafeManager() {
        typelist  = new ArrayList<>();
     }

     public void addType(TypeDTO type) {
        typelist.add(type);
     }

     public void printType() {
        if (typelist.size() == 0) {
            return;
        }

        int i = 1;
        System.out.println("======== 선택하신 음료 ========");
        for (TypeDTO typeDTO : typelist) {
            System.out.println(i + " : " + typeDTO.getName());
            i++;
        }
        System.out.println("==============================");
     }
}
