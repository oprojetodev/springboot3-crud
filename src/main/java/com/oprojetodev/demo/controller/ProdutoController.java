package com.oprojetodev.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.oprojetodev.demo.model.Produto;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

	@GetMapping
	public ResponseEntity<Object> lista() {

		List<Produto> lista = new ArrayList<>();

		Produto p1 = new Produto();
		p1.setCodigo("1");
		p1.setNome("Produto 1");

		Produto p2 = new Produto();
		p2.setCodigo("2");
		p2.setNome("Produto 2");

		lista.add(p1);
		lista.add(p2);

		return ResponseEntity.ok(lista);

	}

	@GetMapping("/{id}")
	public @ResponseBody ResponseEntity<Object> carrega(@PathVariable(name = "id") String id) {

		Produto produto = new Produto();
		produto.setId(id);
		produto.setCodigo("12345");
		produto.setNome("OPD Full Stack 3.0");

		return ResponseEntity.ok(produto);
	}

	@PostMapping
	public @ResponseBody ResponseEntity<Object> adiciona(@RequestBody ProdutoForm form) {

		// Processamento dos dados de produto, por exemplo, inserir em um banco de dados

		Produto produto = new Produto();
		produto.setCodigo(form.getCodigo());
		produto.setNome(form.getNome());

		return ResponseEntity.ok(produto);
	}

	@PutMapping("/{id}")
	public @ResponseBody ResponseEntity<Object> atualiza(@PathVariable(name = "id") String id,
			@RequestBody ProdutoForm form) {

		Produto produto = new Produto();
		produto.setId(id);
		produto.setCodigo(form.getCodigo());
		produto.setNome(form.getNome());

		return ResponseEntity.ok(produto);

	}

	@DeleteMapping("/{id}")
	public @ResponseBody ResponseEntity<Object> delete(@PathVariable(name = "id") String id) {

		return ResponseEntity.ok(id);

	}

}