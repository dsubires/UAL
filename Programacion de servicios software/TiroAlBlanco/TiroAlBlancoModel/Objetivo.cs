using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace dsp086.Practica_05
{
    public class Objetivo:IObjetivo
    {

        public Objetivo(double distancia)
        {
            if (distancia >= 100000)
                throw new ObjetivoDistanciaException();
            this.Distancia = distancia;
        }

        public double Distancia { get; set; }
    }
}
