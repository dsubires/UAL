using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace dsp086.Practica_05
{
    public interface IMisil
    {
        double VelocidadInicial { get; set; }
        double AnguloSalida { get; set; }
        double Alcance { get; set; }
        string TipoMisil { get; set; }

    }
}
