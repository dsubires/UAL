using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace dsp086.Practica_05
{
    public class Partida:IPartida
    {
        private Random aleatorio = new Random();

        public Partida()
        {
            Usuario = new Usuario();
            Objetivo = new Objetivo(aleatorio.Next(200, 3000));
            NumDisparos = 0;
            DistanciaRelativaImpacto = Objetivo.Distancia;
            ObjetivoAlcanzado = false;
        }

        public Partida(Usuario u)
        {
            Usuario = u;
            Objetivo = new Objetivo(aleatorio.Next(200, 3000));
            NumDisparos = 0;
            DistanciaRelativaImpacto = Objetivo.Distancia;
            ObjetivoAlcanzado = false;
        }

        public IUsuario Usuario { get; set; }
        public IObjetivo Objetivo{get; set;}
        public int NumDisparos { get; set; }
        public double DistanciaRelativaImpacto { get; set; }
        public bool ObjetivoAlcanzado { get; set; }

        public void DispararMisil(IMisil m)
        {
            NumDisparos++;
            DistanciaRelativaImpacto = m.Alcance - Objetivo.Distancia;
            DistanciaRelativaImpacto = Math.Round(DistanciaRelativaImpacto, 2);

            if (m.TipoMisil.Equals("antitanque"))               // dificultad normal
            {
                if (DistanciaRelativaImpacto < 1.0 && DistanciaRelativaImpacto > -1.0)
                    ObjetivoAlcanzado = true;                
            }
            else if (m.TipoMisil.Equals("balistico"))           // dificultad difícil
            {
                if (DistanciaRelativaImpacto < 0.5 && DistanciaRelativaImpacto > -0.5)
                    ObjetivoAlcanzado = true;  
            }
            else if (m.TipoMisil.Equals("nuclear"))             // dificultad fácil
            {
                if (DistanciaRelativaImpacto < 3.0 && DistanciaRelativaImpacto > -3.0)
                    ObjetivoAlcanzado = true;  
            }

            if(!ObjetivoAlcanzado)
                Objetivo.Distancia = Objetivo.Distancia * 1.01;         // El objetivo se desplaza un 1% por cada lanzamiento
        }
    }
}
