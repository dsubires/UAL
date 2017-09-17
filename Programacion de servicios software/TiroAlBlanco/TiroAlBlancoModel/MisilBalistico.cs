using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace dsp086.Practica_05
{
    public class MisilBalistico:IMisil
    {

        public MisilBalistico(double Velocidad, double Angulo)
        {
            if (Velocidad >= 300000)
                throw new VelocidadMisilException();
            if (Angulo < 0 || Angulo > 90)
                throw new AnguloMisilException();
            VelocidadInicial = Velocidad;
            AnguloSalida = Angulo;
            Alcance = Math.Pow(Velocidad * 0.27777777777778, 2) * ((Math.Sin(2 * ((Angulo * Math.PI) / 180))) / 9.81);
            Alcance = Math.Round(Alcance, 1);

            /// _alcance = velocidad^2 * ( sen(2*_angulo)/G )
            ///              dónde, _velocidad tiene que estar en metros por segundo, 
            ///              _angulo en Radianes, y G (Gravedad) es igual a 9.81

            TipoMisil = "antitanque";
        }

        public MisilBalistico(double Velocidad, double Angulo, string tipom)
        {
            if (Velocidad >= 300000)
                throw new VelocidadMisilException();
            if (Angulo < 0 || Angulo > 90)
                throw new AnguloMisilException();
            VelocidadInicial = Velocidad;
            AnguloSalida = Angulo;
            Alcance = Math.Pow(Velocidad * 0.27777777777778, 2) * ((Math.Sin(2 * ((Angulo * Math.PI) / 180))) / 9.81);
            Alcance = Math.Round(Alcance, 1);

            /// _alcance = velocidad^2 * ( sen(2*_angulo)/G )
            ///              dónde, _velocidad tiene que estar en metros por segundo, 
            ///              _angulo en Radianes, y G (Gravedad) es igual a 9.81

            TipoMisil = tipom;
        }

        public double VelocidadInicial { get; set; }
        public double AnguloSalida {get; set; }
        public double Alcance { get; set; }
        public string TipoMisil { get; set; }

        


    }
}
