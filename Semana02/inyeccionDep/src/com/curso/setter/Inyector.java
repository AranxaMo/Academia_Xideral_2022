//Toma la responsabilidad de inyectarle la PC a becario

package com.curso.setter;

public class Inyector {
	static void inyectarPc(Becario bec) {
		//bec.myPc = new PcWindows("Windows 10"); //Asigna PC Windows
		bec.myPc = new PcLinux("Ubuntu 18.04");  //Asigna PC Linux
	}
}
