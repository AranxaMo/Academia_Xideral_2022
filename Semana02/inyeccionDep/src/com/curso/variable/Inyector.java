//Toma la responsabilidad de inyectarle la PC a becario

package com.curso.variable;

public class Inyector {
	static void inyectarPc(Becario bec) {
		//bec.myPc = new PcWindows("Windows 10"); //Por variable de referencia
		
		//Por setter
		//bec.setMyPc(new PcWindows("Windows 10"));
		bec.setMyPc(new PcLinux("Ubuntu 18.04"));
	}
}
