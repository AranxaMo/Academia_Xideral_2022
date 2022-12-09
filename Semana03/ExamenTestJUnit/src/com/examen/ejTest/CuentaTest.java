package com.examen.ejTest;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.examen.ej.Cuenta;

class CuentaTest {

	@Test
	void testNombreCuenta() {
		Cuenta cuenta = new Cuenta("Aranxa", new BigDecimal("10000.12345"));
		//cuenta.setPersona("Aranxa");
		String esperado = "Aranxa";
		String real = cuenta.getPersona();
		assertEquals(esperado, real);
		//assertTrue(real.equals("Aranxa"));
	}
	
	@Test
	void testSaldoCuenta() {
		Cuenta cuenta = new Cuenta("Pavel", new BigDecimal("2000254.36551"));
		assertEquals(2000254.36551, cuenta.getSaldo().doubleValue());;
		assertFalse(cuenta.getSaldo().compareTo(BigDecimal.ZERO) < 0);
		//assertFalse(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
	}
	
	@Test
	void testReferenciaCuenta() {
		Cuenta cuenta = new Cuenta("Nathalie Martinez", new BigDecimal("4565453.00554"));
		Cuenta cuenta2 = new Cuenta("Nathalie Martinez", new BigDecimal("4565453.00554"));
		
		//assertNotEquals(cuenta2, cuenta);
		assertEquals(cuenta2, cuenta);
	}
	
	@Test
	void testDebitoCuenta() {
		Cuenta cuenta = new Cuenta("Juan", new BigDecimal("1000.1235"));
		cuenta.debito(new BigDecimal(100));
		
		assertNotNull(cuenta.getSaldo());
		assertEquals(900, cuenta.getSaldo().intValue());
		assertEquals("900.1235", cuenta.getSaldo().toPlainString());
	}
	
	@Test
	void testCreditoCuenta() {
		Cuenta cuenta = new Cuenta("Juan", new BigDecimal("1000.1235"));
		cuenta.credito(new BigDecimal(100));
		
		assertNotNull(cuenta.getSaldo());
		assertEquals(1100, cuenta.getSaldo().intValue());
		assertEquals("1100.1235", cuenta.getSaldo().toPlainString());
	}
}
