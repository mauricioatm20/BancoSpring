package es.cursogetafe.banco.main;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import es.cursogetafe.banco.config.BancoConfig;
import es.cursogetafe.banco.presentacion.BancoVista;
import es.cursogetafe.banco.presentacion.BancoVistaInterface;

public class A01_MainAplicacion {
	public static void main(String[] args) {
		
		new AnnotationConfigApplicationContext(BancoConfig.class);
		
	}
}
