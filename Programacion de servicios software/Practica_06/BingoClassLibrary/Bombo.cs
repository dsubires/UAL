using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace dsp086.Practica_06
{
    public class Bombo
    {
        HashSet<Bola> bolas;
        public Bombo()
        {
            bolas = new HashSet<Bola>();
        }

        public HashSet<Bola> Bolas
        {
            get
            {
                return bolas;
            }
            set
            {
                bolas = value;
            }
        }
        public int NumeroBolas
        {
            get
            {
                return bolas.Count;
            }
        }

        public void MeterBola(Bola b)
        {
            bolas.Add(b);
        }

        public void SacarBola(Bola b)
        {
            if (bolas.Contains(b))
                bolas.Remove(b);
            else
                throw new ArgumentOutOfRangeException();
        }

        public bool EstaBola(Bola b)
        {
            return bolas.Contains(b);
        }

        public Bola ElegirBola()
        {
            if (NumeroBolas <= 0) throw new ArgumentOutOfRangeException();
            Random ramdom = new Random(DateTime.Now.Millisecond);
            Bola bola = new Bola();
            do
            {
                int numAleatorio = ramdom.Next(1, 91);
                bola.Numero = numAleatorio;
            }
            while (!EstaBola(bola));
            return bola;
        }

        public void Rellenar()
        {
            for (int i = 0; i < 90; i++)
            {
                Bola bola = new Bola();
                bola.Numero = i + 1;
                bolas.Add(bola);
            }
        }

    }
}
