using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace dsp086.Practica_06
{
    public class CartonLista
    {
        private List<Bola> linea1, linea2, linea3;


        public CartonLista()
        {
            linea1 = new List<Bola>();
            linea2 = new List<Bola>();
            linea3 = new List<Bola>();
            Rellenar();
        }

        public List<Bola> Linea1
        {
            get { return linea1; }
            set { linea1 = value; }
        }

        public List<Bola> Linea2
        {
            get { return linea2; }
            set { linea2 = value; }
        }
        public List<Bola> Linea3
        {
            get { return linea3; }
            set { linea3 = value; }
        }
        private void Rellenar()
        {
            Random ramdom = new Random(DateTime.Now.Millisecond);
            do
            {
                Bola bola = new Bola();
                int numAleatorio = ramdom.Next(1, 91);
                bola.Numero = numAleatorio;
                linea1.Add(bola);
            }
            while (linea1.Count < 7);

            do
            {
                Bola bola = new Bola();
                int numAleatorio = ramdom.Next(1, 91);
                bola.Numero = numAleatorio;
                if (!linea1.Contains(bola))
                    linea2.Add(bola);
            }
            while (linea2.Count < 7);

            do
            {
                Bola bola = new Bola();
                int numAleatorio = ramdom.Next(1, 91);
                bola.Numero = numAleatorio;
                if (!linea1.Contains(bola) && !linea2.Contains(bola))
                    linea3.Add(bola);
            }
            while (linea3.Count < 7);

        }

        public int NumeroBolasSinTachar(Bombo bombo)
        {
            return bombo.Bolas.Intersect(linea1).Count() + bombo.Bolas.Intersect(linea2).Count() + bombo.Bolas.Intersect(linea3).Count();
        }

        public bool CompruebaLinea(Bombo bombo)
        {
            return bombo.Bolas.Intersect(linea1).Count() == 0 || bombo.Bolas.Intersect(linea2).Count() == 0 || bombo.Bolas.Intersect(linea3).Count() == 0;
        }







    }
}
