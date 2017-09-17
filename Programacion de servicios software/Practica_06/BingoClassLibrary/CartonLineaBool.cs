using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace dsp086.Practica_06
{
    public class CartonLineaBool
    {
        private Linea linea1, linea2, linea3;


        public CartonLineaBool()
        {
            linea1 = new Linea();
            linea2 = new Linea();
            linea3 = new Linea();
            Rellenar();
        }

        public Linea Linea1
        {
            get { return linea1; }
            set { linea1 = value; }
        }

        public Linea Linea2
        {
            get { return linea2; }
            set { linea2 = value; }
        }
        public Linea Linea3
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
                linea1.AñadirBola(bola);
            }
            while (linea1.Count < 7);

            do
            {
                Bola bola = new Bola();
                int numAleatorio = ramdom.Next(1, 91);
                bola.Numero = numAleatorio;
                if (!linea1.Contains(bola))
                    linea2.AñadirBola(bola);
            }
            while (linea2.Count < 7);

            do
            {
                Bola bola = new Bola();
                int numAleatorio = ramdom.Next(1, 91);
                bola.Numero = numAleatorio;
                if (!linea1.Contains(bola) && !linea2.Contains(bola))
                    linea3.AñadirBola(bola);
            }
            while (linea3.Count < 7);

        }

        public void TacharBola(Bola bola)
        {
            linea1.TacharBola(bola);
            linea2.TacharBola(bola);
            linea3.TacharBola(bola);
        }


        public int NumeroBolasSinTachar()
        {
            return linea1.Count + linea2.Count + linea3.Count;
        }

        public bool CompruebaLinea()
        {
            return linea1.Count == 0 || linea2.Count == 0 || linea3.Count == 0;

        }







    }
}
