package org.eda1.practica01.ejercicio01;

import java.util.*;

public class Editor {
	public final static char COMMAND_START = '$';
	public final static char DELIMITER = '%';

	public final static String INSERT_COMMAND = "$Insert";

	public final static String DELETE_COMMAND = "$Delete";

	public final static String LINE_COMMAND = "$Line";

	public final static String DONE_COMMAND = "$Done";

	public final static String LAST_COMMAND = "$Last";

	public final static String GETLINES_COMMAND = "$GetLines";

	public final static String CHANGE_COMMAND = "$Change";

	public final static String BAD_LINE_MESSAGE = "Error: a command should start with "
			+ COMMAND_START + ".\n";

	public final static String BAD_COMMAND_MESSAGE = "Error: not one of the given commands.\n";

	public final static String INTEGER_NEEDED = "Error: The command should be followed by a blank space, "
			+ "\nfollowed by an integer.\n";

	public final static String TWO_INTEGERS_NEEDED = "Error: The command should be followed by a blank space, "
			+ "\nfollowed by an integer, followed by a blank space, "
			+ "followed by an integer.\n";

	public final static String FIRST_GREATER = "Error: the first line number is greater than the second.\n";

	public final static String FIRST_LESS_THAN_ZERO = "Error: the first line number given is less than 0.\n";

	public final static String SECOND_TOO_LARGE = "Error: the second line number given is greater than the "
			+ "\nnumber of the last line in the text.\n";

	public final static String M_LESS_THAN_ZERO = "Error: the number is less than 0.\n";

	public final static String M_TOO_LARGE = "Error: the number is larger than the number of lines in the text.\n";

	public final static String LINE_TOO_LONG = "Error: the line exceeds the maximum number of characters allowed, ";

	public final static String INCORRECT_DELIMITERS_NUMBER = "Error: Delimiter must occur three times. Please try again.\n";

	public final static String NO_DELIMITERS_BEGIN_END = "Error: Bad Expression format, delimiters should be at the beginning "
			+ "\nand at the end. Please try again.\n";

	public final static String TWO_CONSECUTIVE_DELIMITERS_AT_THE_BEGINNING = "Error: Bad Expression format, two consecutive delimiters "
			+ "\nat the beginning. Please try again.\n";

	public final static int MAX_LINE_LENGTH = 80;

	protected LinkedList<String> text;

	protected ListIterator<String> current;

	protected boolean inserting;

	public Editor() {
		text = new LinkedList<String>();
		current = text.listIterator();
		inserting = false;
	}

	public String interpret(String command) {
		String arg1, arg2;
		String[] args;
		int argI1;

		if (command.equals("")) {
			throw new RuntimeException(BAD_LINE_MESSAGE);
		}

		// comprobamos comandos insert,last y done
		if (command.equals(INSERT_COMMAND)) {
			inserting = true;
			return null;
		} else if (command.equals(LAST_COMMAND)) {
			return last();
		} else if (command.equals(DONE_COMMAND)) {
			return done();
		}

		// comprobamos resto de comandos

		if (command.startsWith(Character.toString(COMMAND_START))) {

			args = command.split(" ");

			if (args[0].equals(DELETE_COMMAND)) {
				try {
					arg1 = args[1];
					arg2 = args[2];
				} catch (Exception e) {
					throw new RuntimeException(TWO_INTEGERS_NEEDED);
				}
				comprueba(arg1, arg2);
				delete(Integer.parseInt(arg1), Integer.parseInt(arg2));
				return null;

			} else if (args[0].equals(LINE_COMMAND)) {
				// comprobar que hay arg1 y que es entero
				try {
					arg1 = args[1];
					argI1 = Integer.parseInt(arg1);
				} catch (Exception e) {
					throw new RuntimeException(INTEGER_NEEDED);
				}

				if ((argI1 % 1 != 0)) {
					throw new RuntimeException(INTEGER_NEEDED);
				}

				// comprobamos n < 0
				if (argI1 < 0) {
					throw new RuntimeException(FIRST_LESS_THAN_ZERO);
				}

				// comprobamos n > TAMAÑO LISTA
				if (argI1 >= text.size() && argI1 != 0) {
					throw new RuntimeException(FIRST_GREATER);
				}

				setCurrentLineNumber(argI1);
				return null;

			} else if (args[0].equals(GETLINES_COMMAND)) {
				
				try {
					arg1 = args[1];
					arg2 = args[2];
				} catch (Exception e) {
					throw new RuntimeException(TWO_INTEGERS_NEEDED);
				}
				comprueba(arg1, arg2);
				return getLines(Integer.parseInt(arg1), Integer.parseInt(arg2));

			} else if (args[0].equals(CHANGE_COMMAND)) {
				
				// example input "%c %x%"
				
				int count = 0;
				Character c;
				// comprobamos String contiene 3 delimitadores (%)

				for (int i = 0; i < command.length(); i++) {
					c = command.charAt(i);
					if (c.equals(DELIMITER)) {
						count++;
					}
				}

				if (count != 3) {
					throw new RuntimeException(INCORRECT_DELIMITERS_NUMBER);
				}

				// comprobamos que no hay dos delimitadores al principio
				arg1 = command.replace("$Change ", "");
				if (arg1.substring(0, 2).equals("%%")) {
					throw new RuntimeException(
							TWO_CONSECUTIVE_DELIMITERS_AT_THE_BEGINNING);
				}
				// comprobar que el ultimo caracter de string es un delimitador
				if (!arg1.endsWith("%")) {
					throw new RuntimeException(NO_DELIMITERS_BEGIN_END);
				}
				
				change(arg1);
				return null;
			}
		}

		// Lanza excepcion para cualquier comando fuera de los permitidos
		if(command.contains(Character.toString(COMMAND_START))){
		throw new RuntimeException(BAD_COMMAND_MESSAGE);
		}else if(command.contains("Insert") || command.contains("Delete") || command.contains("Line") || command.contains("Done") || command.contains("Last") || command.contains("GetLines") || command.contains("Change")){
			throw new RuntimeException(BAD_LINE_MESSAGE);
		}else{
			insert(command);
		}

		return null;
	}

	protected void insert(String lineIn) {
		if (inserting) {
			if (lineIn.length() > MAX_LINE_LENGTH) {
				throw new RuntimeException(LINE_TOO_LONG);
			} else {
				current.add(lineIn);
			}
		}
	}

	protected void delete(int arg1, int arg2) {

		// eliminamos los elementos de la lista del rango [arg1,arg2]
		
		int numElementos = (arg2-arg1)+1;
		for (int i = 0; i < numElementos; i++) {
			text.remove(arg1);
		}

		// apuntamos current hacia la posicion necesaria
		current = text.listIterator();
		if (!text.isEmpty()) {
			while (current.nextIndex() != arg1) {
				current.next();
			}
		}
	}

	protected void setCurrentLineNumber(int arg1) {
		if(arg1 >= text.size() && arg1 != 0){
			throw new RuntimeException(M_TOO_LARGE);
		}
		current = text.listIterator();
		while (arg1 != current.nextIndex()) {
			current.next();
		}
		

	}

	protected String getLines(int arg1, int arg2) {
		String aux = "";

		// Example output 1\tb\n2\tc\n3\td"
		
		for (int i = arg1; i <= arg2; i++) {
			if(i == arg2){
				aux += i + "\t" + text.get(i);
			}else{
				aux += i + "\t" + text.get(i) + "\n";	
			}
		}

		return aux;
	}

	protected void change(String lineIn) {
		String[] commands = lineIn.split(Character.toString(DELIMITER));
		String arg1 = "",arg2 = "";
		try{
		arg1 = commands[1];
		arg2 = commands[2];
		}catch(Exception e){
			arg2 = "";
		}
		// efectuamos la operacion Reemplazar
		String aux;
		aux = current.next();
		aux = aux.replaceAll(arg1, arg2);
		current.set(aux);
		current.previous();
	}

	protected String done() {
		// example output: "   c\n   x\n>  d\n"
		if (text.size() == 0) {
			return null;
		}
		String aux = "";
		ListIterator<String> iterador = text.listIterator();
		

			int i=0;
			while(iterador.hasNext()){
				if(i == current.nextIndex()){
					aux += ">  " + iterador.next() + "\n";	
					}else{
					aux += "   " + iterador.next() + "\n";
					}
				i++;
			}	
			// comprueba si el current es la ultima linea ficicia
			if(current.nextIndex() == text.size()){
				aux += ">  \n";
			}
	
		inserting = false;
		return aux;
	}

	protected String last() {
		return (text.size() - 1 + "");
	}

	private void comprueba(String args1, String args2) {

		// comprobar arg1 y arg2 son enteros
		int arg1, arg2;

		try {

			arg1 = Integer.parseInt(args1);
			arg2 = Integer.parseInt(args2);
		} catch (Exception e) {
			throw new RuntimeException(TWO_INTEGERS_NEEDED);
		}

		// comprobar arg1 > arg2
		if (arg1 > arg2) {
			throw new RuntimeException(FIRST_GREATER);
		}

		// arg1 < 0
		if (arg1 < 0) {
			throw new RuntimeException(FIRST_LESS_THAN_ZERO);
		}

		// arg2 > numero de elementos
		if (arg2 > (text.size() - 1)) {
			throw new RuntimeException(SECOND_TOO_LARGE);
		}
	}

}