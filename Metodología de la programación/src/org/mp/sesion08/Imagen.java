package org.mp.sesion08;

import java.util.ArrayList;

/**
 * Clase Imagen. Permite instanciar una imagen binaria y manipular sus datos y
 * bandas.
 * 
 * @author David Subires Parra
 * 
 */
public class Imagen {

	private String formatoImagen;
	private ArrayList<BandaInt> bandas;
	private int lineas;
	private int columnas;

	/**
	 * Instancia una nueva imagen.
	 * 
	 * @param lineas
	 *            numero de lineas de las bandas
	 * @param columnas
	 *            numero de columnas de las bandas
	 * @param formatoImagen
	 *            formato de la imagen
	 */
	public Imagen(int lineas, int columnas, String formatoImagen) {
		this.lineas = lineas;
		this.columnas = columnas;
		this.formatoImagen = formatoImagen;
		bandas = new ArrayList<BandaInt>();
	}

	/**
	 * Metodo getter de los datos de un pixel en concreto
	 * 
	 * @param x
	 *            indice columna de las bandas
	 * @param y
	 *            indice linea de las bandas
	 * @return datos de un pixel en concreto de todas las bandas
	 * @throws XYFueraImagenException
	 *             comprueba que los puntos x1,y1 no esten fuera del rango de
	 *             las bandas de la imagen
	 */
	public int[] getDatosPixel(int x, int y) throws XYFueraImagenException {
		if (x < 0 || y < 0) {
			throw new XYFueraImagenException("Pixeles fuera de la imagen");
		} else if (x >= lineas || y >= columnas) {
			throw new XYFueraImagenException("Pixeles fuera de la imagen");
		}
		int[] temp = new int[bandas.size()];
		for (int i = 0; i < temp.length; i++) {
			temp[i] = bandas.get(i).getDatoXY(x, y);
		}
		return temp;
	}

	/**
	 * Extrae los datos de las bandas de la imagen desde los puntos x1,y1 hasta
	 * x2,y2
	 * 
	 * @param x1
	 *            indice inicio de las columnas de las bandas a leer
	 * @param y1
	 *            indice inicio de las lineas de las bandas a leer
	 * @param x2
	 *            indice final de las columnas de las bandas a leer
	 * @param y2
	 *            indice final de las lineas de las bandas a leer
	 * @return imagen con todos los datos de los puntos del rango x1,y1 - x2,y2
	 *         de las bandas
	 * @throws XYFueraImagenException
	 *             comprueba que los puntos x1,y1 - x2,y2 no esten fuera del
	 *             rango de las bandas de la imagen
	 */
	public Imagen extraerImagen(int x1, int y1, int x2, int y2)
			throws XYFueraImagenException {
		if (!XYValidar(x1, y1, x2, y2)) {
			throw new XYFueraImagenException("Pixeles fuera de la imagen");
		}
		int nLineas, nColumnas;
		Imagen imagenTemp;
		BandaInt bandaTemp, bandaOrigen;
		nLineas = (y2 - y1) + 1;
		nColumnas = (x2 - x1) + 1;
		imagenTemp = new Imagen(nLineas, nColumnas, this.formatoImagen);
		for (int i = 0; i < bandas.size(); i++) {
			bandaOrigen = bandas.get(i);
			bandaTemp = new BandaInt(bandaOrigen.getNombreBanda(), nColumnas,
					nLineas);

			for (int j = x1; j < nColumnas; j++) {
				for (int k = y1; k < nLineas; k++) {
					bandaTemp.setDatoXY(bandaOrigen.getDatoXY(x1, y1), x1, y1);
				}
			}
			imagenTemp.añadirBanda(bandaTemp);
		}
		return imagenTemp;
	}

	/**
	 * Añade una banda a la imagen
	 * 
	 * @param banda
	 *            banda a añadir
	 */
	public void añadirBanda(BandaInt banda) {
		bandas.add(banda);
	}

	/**
	 * Elimina una banda de la imagen
	 * 
	 * @param i
	 *            indice de la banda a eliminar
	 */
	public void eliminarBanda(int i) {
		bandas.remove(i);
	}

	/**
	 * Metodo getter de una banda de la imagen
	 * 
	 * @param i
	 *            indice de la banda
	 * @return banda de la imagen con el indice i
	 */
	public BandaInt getBanda(int i) {
		return bandas.get(i);
	}

	/**
	 * Metodo getter de todas las bandas de la imagen
	 * 
	 * @return Todas las bandas de la imagen
	 */
	public ArrayList<BandaInt> getBandas() {
		return bandas;
	}

	/**
	 * Metodo getter del numero de bandas de la imagen
	 * 
	 * @return numero de bandas
	 */
	public int getNumeroBandas() {
		return bandas.size();
	}

	/**
	 * Metodo getter del numero de lineas de las bandas de la imagen
	 * 
	 * @return numero de lineas
	 */
	public int getLineas() {
		return lineas;
	}

	/**
	 * Metodo getter del numero de columnas de las bandas de la imagen
	 * 
	 * @return numero de columnas
	 */
	public int getColumnas() {
		return columnas;
	}

	/**
	 * Metodo getter del formato de la imagen
	 * 
	 * @return formato de la imagen
	 */
	public String getFormatoImagen() {
		return formatoImagen;
	}

	/**
	 * Metodo setter del formato de la imagen
	 * 
	 * @param formatoImagen
	 *            formato de la imagen a settear
	 */
	public void setFormatoImagen(String formatoImagen) {
		this.formatoImagen = formatoImagen;
	}

	/**
	 * Metodo setter de las bandas de la imagen
	 * 
	 * @param bandas
	 *            bandas a settear
	 */
	public void setBandas(ArrayList<BandaInt> bandas) {
		this.bandas = bandas;
	}

	/**
	 * Valida el rango de puntos x1,y1 - x2,y2 de las bandas de la imagen
	 * 
	 * @param x1
	 *            indice inicio de las columnas de las bandas
	 * @param y1
	 *            indice inicio de las lineas de las bandas
	 * @param x2
	 *            indice final de las columnas de las bandas
	 * @param y2
	 *            indice final de las lineas de las bandas
	 * 
	 * @return true en caso de ser un rango correcto, false en caso contrario
	 */
	private boolean XYValidar(int x1, int y1, int x2, int y2) {
		if (x1 < 0 || y1 < 0) {
			return false;
		} else if (x2 >= columnas || y2 >= lineas) {
			return false;
		} else if (x1 >= columnas || y2 >= lineas) {
			return false;
		} else {
			return true;
		}
	}

}
