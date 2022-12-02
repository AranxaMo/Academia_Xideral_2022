//Toma la responsabilidad de inyectarle la PC a becario

package com.curso.constructor;

public class Inyector {
	static Becario getBecario() {
		Pc pcLinux = new PcLinux("Ubuntu 18.04");
		Pc pcWindows = new PcWindows("Windows 11");
		
		return new Becario("Aranxa", pcLinux);
	}
}
