package com.igormenin.banco.app;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.igormenin.banco.modelo.Banco;
import com.igormenin.banco.modelo.Conta;
import com.igormenin.banco.modelo.Pessoa;

public class Principal4 {

	public static void main(String[] args) {
		Banco banco = new Banco();

		List<Pessoa> titulares = banco.getContas().stream()
				.map(Conta::getTitular)
				.distinct()
				.toList();

		BigDecimal saldoTotal = banco.getContas().stream()
				.map(Conta::getSaldo)
				.reduce(BigDecimal.ZERO, BigDecimal::add);
		System.out.println("Saldo Total do Banco: " + saldoTotal);

		banco.getContas().stream()
				.filter(conta -> conta.getSaldo().compareTo(new BigDecimal("0")) > 0)
				.filter(conta -> conta.getNumero() > 0)
				.map(Conta::getTitular)
				.distinct()
				.forEach(System.out::println);

//		banco.getContas().stream()
//				.filter(conta -> conta.getSaldo().compareTo(new BigDecimal("0")) > 0)
//				.filter(conta -> conta.getNumero() > 0)
//				.sorted(Comparator.comparingInt(Conta::getNumero))
//				.forEach(conta -> {
//					System.out.println(conta.getAgencia() + "/" + conta.getNumero() + "= " + conta.getSaldo());
//				});

	}

}
