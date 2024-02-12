package es.cursogetafe.banco.main;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import es.cursogetafe.banco.presentacion.BancoVista;
import es.cursogetafe.banco.presentacion.BancoVistaInterface;
import es.cursogetafe.springxml.config.BancoConfig;

public class A01_MainAplicacion {
	public static void main(String[] args) {
		
		BeanFactory ctx = new AnnotationConfigApplicationContext(BancoConfig.class);
		BancoVistaInterface bancoVista = ctx.getBean(BancoVistaInterface.class);
		bancoVista.iniciarAplicacion();
	}
}
