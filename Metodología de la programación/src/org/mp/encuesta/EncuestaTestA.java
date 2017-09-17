package org.mp.encuesta;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;

import junit.framework.TestCase;

public class EncuestaTestA extends TestCase {

	String mensaje;

	Encuesta encuesta;
	ArrayList validacionMultiple;
	ArrayList validacionSINO;
	ArrayList validacionAlternativa;
	
	public EncuestaTestA(String name) {
		super(name);
		encuesta = new Encuesta();
		
		validacionSINO = new ArrayList();
		validacionSINO.add("SI");
		validacionSINO.add("NO");
		validacionSINO.add("Si");
		validacionSINO.add("No");
		validacionSINO.add("si");
		validacionSINO.add("no");
		
		validacionMultiple = new ArrayList();
		validacionMultiple.add("-1");
		validacionMultiple.add("0");
		validacionMultiple.add("1");
		validacionMultiple.add("2");
		validacionMultiple.add("3");
		validacionMultiple.add("4");
		validacionMultiple.add("5");

		validacionAlternativa = new ArrayList();
		validacionAlternativa.add("a");
		validacionAlternativa.add("b");
		validacionAlternativa.add("c");
		validacionAlternativa.add("d");
		validacionAlternativa.add("A");
		validacionAlternativa.add("B");
		validacionAlternativa.add("C");
		validacionAlternativa.add("D");
	}

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testEncuesta() throws FileNotFoundException {

		rellenarEncuesta();
		imprimirEncuesta();

		String directorio = System.getProperty("user.dir");
		directorio = directorio + File.separator + "src"
				+ File.separator + "org" + File.separator + "mp"
				+ File.separator + "encuesta" 
				+ File.separator;

		for (Iterator iterator = encuesta.getEncuesta().iterator(); iterator
				.hasNext();) {
			PreguntaContestacion pc = (PreguntaContestacion) iterator.next();

			mensaje = pc.getNumero() + "-->  " + pc.getTipo() + "-->" + pc.getContestacion();
			assertTrue(mensaje, validar(pc.getTipo(), pc.getContestacion()));

		}

		File file = new File(directorio
				+ ((PreguntaContestacion) encuesta.getEncuesta().get(0))
						.getContestacion() + ".encuesta");
		PrintStream ps = new PrintStream(file);

		for (Iterator iterator = encuesta.getEncuesta().iterator(); iterator
				.hasNext();) {

			PreguntaContestacion pc = (PreguntaContestacion) iterator.next();

			ps.print(pc.getNumero() + ";");
			ps.print(pc.getTipo() + ";");
			ps.print(pc.getPregunta() + ";");
			ps.print(pc.getContestacion() + ";");
			ps.print("\n");

		}
		ps.close();
	}

	private void rellenarEncuesta() {

		// método que debe rellenar por código
		
		// Debe rellenar todos los nulls de las contestaciones

		// Hay cuatro tipos de preguntas:

		// ABIERTA
		// en estas debe sustituir el null por un texto

		// SI/NO
		// en estas debe elegir entre SI o NO
		
		// ALTERNATIVA
		// debe contestar con la opción que más se aproxime a su opinión

		// MULTIPLE
		// debe contestar con el valor que más se aproxime a su opinión
		// -1 (No sabe/No contesta), o un valor en una escala de 0 a 5
		// 0 (nada),
		// 1 (muy poco), 
		// 2 (poco), 
		// 3 (regular), 
		// 4(bien/bastante), 
		// 5 (muy bien/mucho)

		PreguntaContestacion pc;
		String pregunta;
		String contestacion;
		String tipo;
		int numero = 0;
		
		// preguntas de Inicio de la encuesta		
		
		numero++;
		tipo = "ABIERTA";
		pregunta = "Escriba su Apellido1Apellido2Nombre \n";
		// Por ejemplo MartinezPerezJulian
		contestacion = "SubiresParraDavid";
		pc = new PreguntaContestacion(numero, tipo, pregunta, contestacion);
		encuesta.addPregunta(pc);
		
		numero++;
		tipo = "SI/NO";
		pregunta = " ¿ Ha hecho usted las prácticas ? \n";
		// Parece lógico decir algo como SI
		contestacion = "Si";
		pc = new PreguntaContestacion(numero, tipo, pregunta, contestacion);
		encuesta.addPregunta(pc);
		
		numero++;
		tipo = "ALTERNATIVA";
		pregunta = " ¿ Cuál es tu edad ? \n"
				+ "a) 18 a 20 \n"
				+ "b) 21 a 25 \n"
				+ "c) 26 a 30 \n"
				+ "d) >30 \n"
				;
		contestacion = "b)";	
		pc = new PreguntaContestacion(numero, tipo, pregunta, contestacion);
		encuesta.addPregunta(pc);
		
		numero++;
		tipo = "ALTERNATIVA";
		pregunta = " ¿ Cuántas veces te has matriculado en la asignatura Introducción a la Programación ? \n"
				  + "a) 1 \n"
				  + "b) 2 \n"
				  + "c) >2 \n"
				  ;
		contestacion = "a)";
		pc = new PreguntaContestacion(numero, tipo, pregunta, contestacion);
		encuesta.addPregunta(pc);
		
		numero++;
		tipo = "ALTERNATIVA";
		pregunta = " ¿ Cuántas veces te has matriculado en la asignatura Metodología de la Programación ? \n"
				+ "a) 1 \n"
				+ "b) 2 \n"
				+ "c) >2 \n"
				;
		contestacion = "a)";
		pc = new PreguntaContestacion(numero, tipo, pregunta, contestacion);
		encuesta.addPregunta(pc);
		
		numero++;
		tipo = "ALTERNATIVA";
		pregunta = " ¿ En qué grupo docente estas matriculado ? \n"
				+ "a) Mañana \n"
				+ "b) Tarde \n"
				;
		contestacion = "b)";
		pc = new PreguntaContestacion(numero, tipo, pregunta, contestacion);
		encuesta.addPregunta(pc);
		
		numero++;
		tipo = "ALTERNATIVA";
		pregunta = " ¿ Estudios previos ? \n"
				+ "a) Bachiller \n"
				+ "b) Modulo \n"
				+ "c) Mayor 25 años \n"
				+ "d) Otros \n"
				;
		contestacion = "b)";
		pc = new PreguntaContestacion(numero, tipo, pregunta, contestacion);
		encuesta.addPregunta(pc);
		
		numero++;
		tipo = "ALTERNATIVA";
		pregunta = " Tu conocimiento en Programación de Ordenadores antes de comenzar tus estudios en Ingeniería Informática era \n"
				+ "a) Ninguno \n"
				+ "b) Bajo \n"
				+ "c) Medio \n"
				+ "d) Alto \n"
				;
		contestacion = "b)";
		pc = new PreguntaContestacion(numero, tipo, pregunta, contestacion);
		encuesta.addPregunta(pc);
		
		numero++;
		tipo = "ALTERNATIVA";
		pregunta = " ¿ Cómo valoras el grado de dificultad de la materia Introducción a la Programación ? \n"
				+ "a) Bajo \n"
				+ "b) Medio \n"
				+ "c) Alto \n"
				+ "d) Muy Alto \n"
				;
		contestacion = "b)";
		pc = new PreguntaContestacion(numero, tipo, pregunta, contestacion);
		encuesta.addPregunta(pc);
		
		numero++;
		tipo = "ALTERNATIVA";
		pregunta = " ¿ Cómo valoras el grado de dificultad de la materia Metodología de la Programación ?\n"
				+ "a) Bajo \n"
				+ "b) Medio \n"
				+ "c) Alto \n"
				+ "d) Muy Alto \n"
				;
		contestacion = "c)";
		pc = new PreguntaContestacion(numero, tipo, pregunta, contestacion);
		encuesta.addPregunta(pc);

		// preguntas sobre los repositorios y el control de versiones Subversión

		numero++;
		tipo = "MULTIPLE";
		pregunta = "Este año hemos utilizado repositorios con un sistema de control de versiones \n"
				+ " basado en Subversion \n"
				+ "¿ Le ha resultado sencillo empezar a utilizarlo ?\n";
		contestacion = "Si";
		pc = new PreguntaContestacion(numero, tipo, pregunta, contestacion);
		encuesta.addPregunta(pc);

		numero++;
		tipo = "MULTIPLE";
		pregunta = "Este año hemos utilizado repositorios con un sistema de control de versiones \n"
				+ " basado en Subversion \n"
				+ " ¿ Le ha facilitado el control del código que iba realizando en los grupos de trabajo \n"
				+ " y en el trabajo autónomo ? \n"
				;
		contestacion = "Si, ademas de poder trabajar con varios equipos mediante commit/update";
		pc = new PreguntaContestacion(numero, tipo, pregunta, contestacion);
		encuesta.addPregunta(pc);

		numero++;
		tipo = "SI/NO";
		pregunta = " ¿ Ha necesitado recurrir a los repositorios en alguna ocasión para \n"
				+ "recuperar una copia de seguridad ? \n";
		contestacion = "No";
		pc = new PreguntaContestacion(numero, tipo, pregunta, contestacion);
		encuesta.addPregunta(pc);	
		
		numero++;
		tipo = "SI/NO";
		pregunta = " ¿ Incluirías en Introdución a la Programación \n"
				+ "la utilización de repositorios como metodología de trabajo  ? \n";
		contestacion = "Si";
		pc = new PreguntaContestacion(numero, tipo, pregunta, contestacion);
		encuesta.addPregunta(pc);

		// preguntas sobre el aprendizaje basado en pruebas (tests)
		
		numero++;
		tipo = "MULTIPLE";
		pregunta = "Teniendo como referencia la especificación de un problema basada en texto escrito, \n"
				+ " como por ejemplo los guiones de prácticas de Introducción a la Programación. \n"
				+ " ¿ En qué grado te ha ayudado la utilización de test de prueba como especificación adicional  \n"
				+ " para la resolución e implementación del código solución. ? \n"
				;
		contestacion = "Creo que ayuda mucho para implementar la solucion";
		pc = new PreguntaContestacion(numero, tipo, pregunta, contestacion);
		encuesta.addPregunta(pc);
		
		numero++;
		tipo = "ALTERNATIVA";
		pregunta = " Según tu percepción personal, ¿acelera el tiempo para generar el código de la solución ?\n"
				+ "a) Indiferente \n"
				+ "b) Me lleva más tiempo \n"
				+ "c) Me lleva menos tiempo \n"
				;
		contestacion = "c)";
		pc = new PreguntaContestacion(numero, tipo, pregunta, contestacion);
		encuesta.addPregunta(pc);

		tipo = "ALTERNATIVA";
		pregunta = " En caso de haber contestado la opción c en la pregunta anterior; \n" 
				+ "en qué grado, según tu percepción personal, la utilización de tests de prueba \n"
				+ "acelera el tiempo para generar el código de la solución ? \n"
				+ "a) 25% menos de tiempo \n"
				+ "b) 50% menos de tiempo \n"
				+ "c) 75% menos de tiempo \n"
				;
		contestacion = "a)";
		pc = new PreguntaContestacion(numero, tipo, pregunta, contestacion);
		encuesta.addPregunta(pc);
			
		numero++;
		tipo = "MULTIPLE";
		pregunta = "¿Cómo valoras el grado de dificultad que te ha supuesto entender el mecanismo de funcionamiento de los tests? \n"
				;
		contestacion = null;
		pc = new PreguntaContestacion(numero, tipo, pregunta, contestacion);
		encuesta.addPregunta(pc);
		
		numero++;
		tipo = "SI/NO";
		pregunta = " ¿ Incluirías en la Introdución a la Programación \n"
				+ "la utilización de tests de prueba como forma de metodología de aprendizaje ? \n";
		contestacion = null;
		pc = new PreguntaContestacion(numero, tipo, pregunta, contestacion);
		encuesta.addPregunta(pc);
		
		// preguntas sobre las clases

		numero++;
		tipo = "SI/NO";
		pregunta = " Este año hemos añadido como herramienta de comunicación \n"
				+ "una cuenta en twitter: ualmetodolologia. \n"
				+ " ¿Eres seguidor de esta cuenta \n";
		contestacion = "Si";
		pc = new PreguntaContestacion(numero, tipo, pregunta, contestacion);
		encuesta.addPregunta(pc);
		
		numero++;
		tipo = "MULTIPLE";
		pregunta = "¿ En qué medida valora la utilidad de los foros, del aula virtual, como herramienta para la asignatura \n"
				;
		contestacion = "El foro es de gran ayuda, para solucion de errores comunes y estar informado de las actualizaciones de test por ejemplo";
		pc = new PreguntaContestacion(numero, tipo, pregunta, contestacion);
		encuesta.addPregunta(pc);
		
		numero++;
		tipo = "SI/NO";
		pregunta = " Está usted de acuerdo con la siguiente afirmación \n"
				+ "No suelo acudir a clases porque prefiero ir por mi cuenta \n"
				+ "ya que tengo todo lo que necesito en la Web \n";
		contestacion = "No";
		pc = new PreguntaContestacion(numero, tipo, pregunta, contestacion);
		encuesta.addPregunta(pc);

		numero++;
		tipo = "SI/NO";
		pregunta = " Está usted de acuerdo con la siguiente afirmación \n"
				+ "No suelo acudir a clases porque prefiero \n"
				+ "dedicar mi tiempo a otras asignaturas y dejar esta para más adelante \n";
		contestacion = "No";
		pc = new PreguntaContestacion(numero, tipo, pregunta, contestacion);
		encuesta.addPregunta(pc);

		numero++;
		tipo = "ABIERTA";
		pregunta = "Escriba su opinión sobre,  \n"
				+ "¿ Por qué asisten pocos alumnos a las clases ? \n";
		contestacion = null;
		pc = new PreguntaContestacion(numero, tipo, pregunta, contestacion);
		encuesta.addPregunta(pc);
		
		numero++;
		tipo = "ABIERTA";
		pregunta = "Escriba su opinión sobre,  \n"
				+ "¿ Qué cosas cambiaria, o añadiría, para mejorar la asignatura  ? \n";
		contestacion = null;
		pc = new PreguntaContestacion(numero, tipo, pregunta, contestacion);
		encuesta.addPregunta(pc);
		
		numero++;
		tipo = "ABIERTA";
		pregunta = "Una última pregunta,  \n"
				+ "¿ Añada algún comentario más que quiera que leamos ? \n";
		// Si no se te ocurre nada, puede poner  "...que el exámen sea fácil..."
		contestacion = null;
		pc = new PreguntaContestacion(numero, tipo, pregunta, contestacion);
		encuesta.addPregunta(pc);

	}
	
	private void imprimirEncuesta() {
		System.out.println("Encuesta");
		System.out.println("=====================");
		System.out.println();

		for (Iterator iterator = encuesta.getEncuesta().iterator(); iterator
				.hasNext();) {
			PreguntaContestacion pc = (PreguntaContestacion) iterator.next();

			System.out.println();
			System.out.println(pc.getNumero());
			System.out.println(pc.getTipo());
			System.out.println(pc.getPregunta());
			System.out.println(pc.getContestacion());
			System.out.println();
			System.out.println("=====================");
			

		}
	}

	private boolean validar(String tipo, String contestacion) {

		if (contestacion == null) {
			return false;
		}

		if (tipo.equals("ABIERTA")) {
			return true;
		}

		if (tipo.equals("SI/NO")) {
			return validacionSINO.contains(contestacion);
		}

		if (tipo.equals("MULTIPLE")) {
			return validacionMultiple.contains(contestacion);
		}
		
		if (tipo.equals("ALTERNATIVA")) {
			return validacionAlternativa.contains(contestacion);
		}

		return false;

	}
}

