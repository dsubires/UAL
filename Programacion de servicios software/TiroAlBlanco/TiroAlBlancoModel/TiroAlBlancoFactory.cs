using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace dsp086.Practica_05
{
    public class TiroAlBlancoFactory
    {

        public static IMisil CrearMisil(double Velocidad, double Angulo)
        {
            return new MisilBalistico(Velocidad, Angulo);
        }


        public static IObjetivo CrearObjetivoFijo(double dist)
        {
            return new Objetivo(dist);
        }

        public static IUsuario CrearUsuario()
        {
            return new Usuario();
        }

        public static IUsuario CrearUsuario(String nombre)
        {
            return new Usuario(nombre);
        }

        public static IPartida CrearPartida()
        {
            return new Partida();
        }
    }
}
