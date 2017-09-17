using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace dsp086.Practica_08
{
    public class ConsoleApp
    {
        static void Main(string[] args)
        {
            // salidas consultas
            IEnumerable<vmNombre> enumerable;
            IEnumerable<vmCategoriaNombre> enumerable2;
            IEnumerable<IGrouping<string, vmCategoriaNombre>> enumerable3;
            IEnumerable<vmNombreCantidad> enumerable4;
            
            //consulta 1
            Consultas consulta = new Consultas();
            enumerable = consulta.UsuariosEnCategoria(1);
            Console.WriteLine("Consulta 1");
            foreach(vmNombre nombre in enumerable){
                Console.WriteLine(nombre.Nombre);
            }
            Console.ReadLine();

            //consulta 2
            enumerable = consulta.UsuariosEnCategoria("Alumno");
            Console.WriteLine("Consulta 2");
            foreach (vmNombre nombre in enumerable)
            {
                Console.WriteLine(nombre.Nombre);
            }
            Console.ReadLine();

            //consulta 3
            enumerable = consulta.UsuariosConNombreComienza("Di");
            Console.WriteLine("Consulta 3");
            foreach (vmNombre nombre in enumerable)
            {
                Console.WriteLine(nombre.Nombre);
            }
            Console.ReadLine();

            //consulta 4
            enumerable = consulta.UsuariosConNombreComienzaEnCategoria("Jo","Profesor");
            Console.WriteLine("Consulta 4");
            foreach (vmNombre nombre in enumerable)
            {
                Console.WriteLine(nombre.Nombre);
            }
            Console.ReadLine();



            //consulta 5
            enumerable = consulta.UsuariosConectadosIP("192.168.134.108");
            Console.WriteLine("Consulta 5");
            foreach (vmNombre nombre in enumerable)
            {
                Console.WriteLine(nombre.Nombre);
            }
            Console.ReadLine();

            //consulta 6
            enumerable = consulta.EncontrarUsuarioAppEmail("Excel","Juan.pss-2@ual.es");
            Console.WriteLine("Consulta 6");
            foreach (vmNombre nombre in enumerable)
            {
                Console.WriteLine(nombre.Nombre);
            }
            Console.ReadLine();

            //consulta 7

            enumerable2 = consulta.ListaParCategoriaUsuarioParaApp("Word");
            Console.WriteLine("Consulta 7");
            foreach (vmCategoriaNombre nombre in enumerable2)
            {
                Console.WriteLine(nombre.Nombre);
            }
            Console.ReadLine();


            //consulta 8
            enumerable3 = consulta.AgrupacionUsuariosCategorias();
            Console.WriteLine("Consulta 8");
            foreach (IGrouping<string, vmCategoriaNombre> nombre in enumerable3)
            {
                Console.WriteLine(nombre.Key);
            }
            Console.ReadLine();

            //consulta 9
            enumerable2 = consulta.AgrupacionUsuariosCategoriasOrdenadas();
            Console.WriteLine("Consulta 9");
            foreach (vmCategoriaNombre cNombre in enumerable2)
            {
                Console.WriteLine(cNombre.Categoria + " " + cNombre.Nombre);
            }
            Console.ReadLine();

            //consulta 10
            enumerable2 = consulta.CategoriaMaximoNumeroUsuarios();
            Console.WriteLine("Consulta 10");
            foreach (vmCategoriaNombre cNombre in enumerable2)
            {
                Console.WriteLine(cNombre.Categoria + " " + cNombre.Nombre );
            }
            Console.ReadLine();

            //consulta 11
            enumerable2 = consulta.TodasCategoriasApp("Word");
            Console.WriteLine("Consulta 11");
            foreach (vmCategoriaNombre nombre in enumerable2)
            {
                Console.WriteLine(nombre.Categoria + " " + nombre.Nombre);
            }
            Console.ReadLine();

            //consulta 12
            enumerable2 = consulta.CategoriasAplicacionParaUsuario("Juan");
            Console.WriteLine("Consulta 12");
            foreach (vmCategoriaNombre nombre in enumerable2)
            {
                Console.WriteLine(nombre.Categoria + " " + nombre.Nombre);
            }
            Console.ReadLine();

            //consulta 13
            enumerable4 = consulta.IPconMasConexionesSegunCategoria("Administrador");
            Console.WriteLine("Consulta 13");
            foreach (vmNombreCantidad nombre in enumerable4)
            {
                Console.WriteLine(nombre.Nombre + " " + nombre.Cantidad);
            }
            Console.ReadLine();

            //consulta 14
            enumerable4 = consulta.UsuarioSumaDuracionConexiones();
            Console.WriteLine("Consulta 14");
            foreach (vmNombreCantidad nombre in enumerable4)
            {
                Console.WriteLine(nombre.Nombre + " " + nombre.Cantidad);
            }
            Console.ReadLine();

            //consulta 15
            enumerable4 = consulta.UsuarioSumaDuracionConexionesNulos();
            Console.WriteLine("Consulta 15");
            foreach (vmNombreCantidad nombre in enumerable4)
            {
                Console.WriteLine(nombre.Nombre + " " + nombre.Cantidad);
            }
            Console.ReadLine();

            //consulta 16
            enumerable4 = consulta.UsuariosSumaDuracionMayorMedia();
            Console.WriteLine("Consulta 16");
            foreach (vmNombreCantidad nombre in enumerable4)
            {
                Console.WriteLine(nombre.Nombre + " " + nombre.Cantidad);
            }
            Console.ReadLine();

            //consulta 17
            enumerable4 = consulta.AplicacionesMasUsadas();
            Console.WriteLine("Consulta 17");
            foreach (vmNombreCantidad nombre in enumerable4)
            {
                Console.WriteLine(nombre.Nombre + " " + nombre.Cantidad);
            }
            Console.ReadLine();

            //consulta 18
            enumerable4 = consulta.AplicacionesMasUsadasOrdenadas();
            Console.WriteLine("Consulta 18");
            foreach (vmNombreCantidad nombre in enumerable4)
            {
                Console.WriteLine(nombre.Nombre + " " + nombre.Cantidad);
            }
            Console.ReadLine();


        }
    }
}
