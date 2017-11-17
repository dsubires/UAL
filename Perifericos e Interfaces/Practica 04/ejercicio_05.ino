
//Processing
//Importar e inicializar el entorno
import processing.serial.*;
Serial port;
float brillo = 0; //para el valor leído desde el potenciómetro.

void setup() {
  // put your setup code here, to run once:
  size(500,500); //Tamaño de la ventana
  port = new Serial(this, "COM3", 9600); //Configuración del Puerto serie (cambiar COM3 por el tuyo).
  port.bufferUntil('\n');
}

void draw() {
background(0,0,brillo); //Actualiza la ventana
}
void serialEvent (Serial port)
{
brillo = float(port.readStringUntil('\n'));
}
