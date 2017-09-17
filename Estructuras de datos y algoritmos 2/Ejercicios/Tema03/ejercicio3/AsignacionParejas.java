package EjerciciosTema3.Ejercicio03;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class AsignacionParejas {

	private int[][] afinidades;
	private boolean[] empleadosAsignados;
	private int numEmpleados;

	public AsignacionParejas(String rutaArchivo) {

		try {
			BufferedReader br = new BufferedReader(new FileReader(new File(
					rutaArchivo)));

			// leemos el número de empleados desde la primera linea del archivo
			numEmpleados = Integer.parseInt(br.readLine());

			// inicializamos datos
			afinidades = new int[numEmpleados][numEmpleados];
			empleadosAsignados = new boolean[numEmpleados];
			for (int i = 0; i < afinidades.length; i++)
				for (int j = 0; j < afinidades.length; j++)
					afinidades[i][j] = 0;
			for (int i = 0; i < empleadosAsignados.length; i++)
				empleadosAsignados[i] = false;

			// leemos los datos de afinidades
			String linea;
			while ((linea = br.readLine()) != null) {
				String[] datos = linea.split(" ");
				int emp1, emp2, afinidad;
				emp1 = Integer.parseInt(datos[0]);
				emp2 = Integer.parseInt(datos[1]);
				afinidad = Integer.parseInt(datos[2]);
				afinidades[emp1][emp2] = afinidad;
			}
			br.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Algoritmo greedy que genera las parejas de empleados buscando la mejor
	 * afinidad posible. Devuelve array de enteros, para el empleado 0, su
	 * compañero es array[0]. Si el empleado i se queda sin grupo, el valor almacenado en
	 * array[i] será -1.
	 * 
	 * @return
	 */
	public int[] generaAsignacionParejas() {
		int[] resultado = new int[numEmpleados];
		int[] tempMejorPareja;
		int sumaAfinidad, mejorAfinidad;
		for (int i = 0; i < numEmpleados; i++)
			resultado[i] = -1;
		for (int i = 0; i < numEmpleados; i++) {
			if (empleadosAsignados[i] == false) {
				sumaAfinidad = 0;
				mejorAfinidad = 0;
				tempMejorPareja = new int[2];
				for (int j = 0; j < numEmpleados; j++) {
					if (i != j && empleadosAsignados[j] == false) {
						sumaAfinidad = afinidades[i][j] + afinidades[j][i];
						if (mejorAfinidad < sumaAfinidad) {
							mejorAfinidad = sumaAfinidad;
							tempMejorPareja[0] = i;
							tempMejorPareja[1] = j;
						}
					}
				}
				resultado[tempMejorPareja[0]] = tempMejorPareja[1];
				resultado[tempMejorPareja[1]] = tempMejorPareja[0];
				empleadosAsignados[tempMejorPareja[0]] = true;
				empleadosAsignados[tempMejorPareja[1]] = true;
			}
		}
		return resultado;
	}
	
	public int getNumEmpleados(){
		return numEmpleados;
	}

}
