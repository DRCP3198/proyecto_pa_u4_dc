package com.example.demo.funcional;

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
		LOG.info("1.SUPPLIER");
		// CLASES

		IPersonaSupplier<String> supplier1 = new PersonaSupplierImpl();
		LOG.info("Supplier Clase: " + supplier1.getNombre());

		// LAMBDAS
		IPersonaSupplier<String> supplier2 = () -> "Dillan2";
		LOG.info("Supplier Lamda: " + supplier2.getNombre());
		

		// LAMBDAS
		IPersonaSupplier<Integer> supplier3 = () -> Integer.valueOf(5);
		LOG.info("Supplier Lamda: " + supplier3.getNombre());
		
		IPersonaSupplier<Persona> supplier4 =() -> {
			Persona persona = new Persona();
			persona.setApellido("Coloma");
			persona.setNombre("Dillan");
			return persona;
		};
		
		LOG.info("Supplier Lamda: " + supplier4.getNombre());
		
		IPersonaSupplier<Persona> supplier5 = new PersonaSupplier2Impl();
		LOG.info("Supplier Clases: " + supplier5.getNombre());
		
		//2.CONSUMER
		LOG.info("2.CONSUMER");
		// CLASES
		
		IPersonaConsumer< String,Integer> consumer1 = new PersonaConsumerImpl();
		consumer1.aceptar("procesa este dato", Integer.valueOf(10));
		
		//LAMBDAS
		IPersonaConsumer<String,Integer> consumer2 =(cadena,numero) ->{ 
			LOG.info("mensajeA: "+cadena);
			LOG.info("mensajeB: "+cadena);
			LOG.info("mensajeC: "+numero);
		   
		};
		consumer2.aceptar("procesa este dato2", Integer.valueOf(15));
      
		
		IPersonaConsumer<Integer, Integer> consumer3 =(valor1, valor2)->{
			Integer valor3 =valor1.intValue()+ valor2.intValue();
			LOG.info(" Valor 3= " + valor3);
		};
		consumer3.aceptar(Integer.valueOf(5), Integer.valueOf(10));
		
		
		//3.PREDICATE
		LOG.info("3.PREDICATE");
		
		//lambdas
		IPersonaPredicate<String> predicate = cadena-> cadena.contains("Z");
		LOG.info("Predicate: " + predicate.evaluar("DillanZ"));
		
		IPersonaPredicate<Integer> predicate1= numero -> {
			if(numero.intValue()>10) {
				return true;
			}else {
				return false;
			}
		
		};
		LOG.info("Predicate2: " +predicate1.evaluar(Integer.valueOf(11)));
		
		//4. FUNCTION
	
	     LOG.info("4. FUNCTION");
		//recomendacion cuando declaremos la interfaz de reclara primero el retorno y despues lo que recibe
		IPersonaFunction<String, Integer> function = numero -> "Valor: "+numero.toString();
		
		LOG.info("Function: "+function.aplicar(10));
		
		
		IPersonaFunction<Ciudadano, Persona> function1 = pers -> {
			Ciudadano ciu = new Ciudadano();
			ciu.setNombreCompleto(pers.getNombre()+ " " + pers.getApellido());
			ciu.setCiudad("Quito");
			return ciu;
		};
		Persona per1 = new Persona();
		per1.setNombre("Dillan");
		per1.setApellido("Coloma");
		LOG.info("Function2: Ciudadano Convertido " + function1.aplicar(per1));
		
		
		//5. UNARY OPERATOR
		LOG.info("5. UNARY OPERATOR");
		//Lambdas
		IPersonaUnaryOperator<String> unaryOperator = cadena ->{
			String cadenaFinal= cadena.concat("-sufijo");
			
			return cadenaFinal;
		};
		LOG.info("UnaryOperator: "+unaryOperator.aplicar("Daniel"));
	}

}
