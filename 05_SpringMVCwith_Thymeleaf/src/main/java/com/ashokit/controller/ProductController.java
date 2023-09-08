package com.ashokit.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ashokit.entity.ProductEntity;
import com.ashokit.formdata.ProductForm;
import com.ashokit.repository.ProductRepository;


@Controller
public class ProductController {
	
	@Autowired
	private ProductRepository repo;

	@GetMapping("/")
	public String loadForm(Model model) {
	model.addAttribute("prod",new ProductForm());				
	return "index";
	}
	
	@PostMapping("/product")
	public String saveProduct(@ModelAttribute("prod")ProductEntity p,Model model) {
		p = repo.save(p);
		if(p.getPid()!=null) {
			model.addAttribute("msg","Product Saved.........");
		}
		return "index";
	}
	@GetMapping("/products")
	public String getAllProducts(Model model) {
		List<ProductEntity> List=repo.findAll();
		model.addAttribute("products",List);
		return "daata";
	}
	@GetMapping("/delete")
	public String delete(@RequestParam("pid") Integer pid,Model model) {
		repo.deleteById(pid);
		model.addAttribute("msg","Product Deleted............");
		model.addAttribute("products",repo.findAll());
		return "daata";
	}
}
