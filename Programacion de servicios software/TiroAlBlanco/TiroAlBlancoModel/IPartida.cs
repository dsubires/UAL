using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace dsp086.Practica_05{
    public interface IPartida
    {
        IUsuario Usuario { get; set; }
        IObjetivo Objetivo { get; set; }
        int NumDisparos { get; set; }
        double DistanciaRelativaImpacto { get; set; }
        bool ObjetivoAlcanzado { get; set; }
        void DispararMisil(IMisil m);
    }
}
