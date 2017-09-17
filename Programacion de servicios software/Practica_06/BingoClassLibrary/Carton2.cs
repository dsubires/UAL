using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace dsp086.Practica_06
{
    public class Carton2
    {
        public HashSet<Bola> bolas;


        public Carton2()
        {
            bolas = new HashSet<Bola>();
            Rellenar();
        }

        public HashSet<Bola> Bolas
        {
            get { return bolas; }
            set { bolas = value; }
        }

        private void Rellenar()
        {
            Random ramdom = new Random(DateTime.Now.Millisecond);
            do
            {
                Bola bola = new Bola();
                int numAleatorio = ramdom.Next(1, 91);
                bola.Numero = numAleatorio;
                bolas.Add(bola);
            }
            while (bolas.Count < 15);
        }


        public int NumeroBolasSinTachar(Bombo bombo)
        {
            return bombo.Bolas.Intersect(this.bolas).Count();
        }

    }
}
