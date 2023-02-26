package com.example.demo.funcional;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainInterfacesFuncionales {

	private static final Logger LOG = LoggerFactory.getLogger(MainInterfacesFuncionales.class);
    //LOGGER ES UNA Interfaz QUE ME PERMITE IMPRIMIR LOGS, me permite imprimir desde que clase se esta 
	//imprimiedo su categoria y la hora 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Mejor practica para la impresion
		// 1.SUPPLIER
//		
		//JAVA
		LOG.info("JAVA SUPLIER");
		Stream<String> lista =Stream.generate(()-> "Edison2").limit(3);
		lista.forEach(cadena -> LOG.info(cadena));
	
		Stream<String> lista1 = Stream.generate(() -> {
					return "Edison3";
					}).limit(10);
				
				// acá lo imprimo con un consumer
				lista1.forEach(cadena -> LOG.info(cadena));
		
		//imprimir con otro tipo de funcion lambda
		
		//2.CONSUMER
//		LOG.info("2.CONSUMER");
//		// JAVA
		LOG.info("JAVA CONSUMER");
		List<Integer> listaNumero = Arrays.asList(1,2,3,4,5,56,78);
		listaNumero.forEach(numero-> LOG.info("valor: " +numero));
//		 
		

		
		
		//3.PREDICATE
		
		LOG.info("JAVA PREDICATE");
		Stream<Integer>listafiltrada=listaNumero.stream().filter(numero -> numero >=3);
		listafiltrada.forEach(numero -> LOG.info("Valor:" + numero));
		
		
		
		
		//4. FUNCTION
		LOG.info("JAVA FUNCTION");
		Stream<Integer> listaCambiada=listaNumero.stream().map(numeroLista ->{
			Integer valorFinal = numeroLista+1;
			//String cadena = "Num: " +valorFinal.toString();
			return valorFinal;
		});
		listaCambiada.forEach(numero-> LOG.info("Valor Entero: " +numero));
	

		
		
		//5. UNARY OPERATOR
		
	}

}
