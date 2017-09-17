using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace dsp086.Practica_06
{
    public class Carton
    {
        private HashSet<Bola> bolas;

        public Carton()
        {
            bolas = new HashSet<Bola>();
            Rellenar();
        }

        public int NumeroBolasSinTachar
        {
            get
            {
                return bolas.Count;
            }
        }

        public void Rellenar()
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

        public void TacharBola(Bola bola)
        {
            bolas.Remove(bola);
        }



    }
}
