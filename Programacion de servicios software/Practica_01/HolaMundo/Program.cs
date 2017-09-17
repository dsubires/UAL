using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace dsp086.Practica_01
{
    class Program
    {
        static void Main(string[] args)
        {
            System.Console.Write("¿Introduce tu Nombre? ");
            string nombre = System.Console.ReadLine();
            System.Console.Write("¿Introduce tus Apellidos? ");
            string apellidos = System.Console.ReadLine();
            string nombreCompuesto = nombre + " " + apellidos;
            string mensaje = "Bienvenido " + nombreCompuesto;
            System.Console.WriteLine(mensaje);
            System.Console.ReadLine();
        }
    }
}
