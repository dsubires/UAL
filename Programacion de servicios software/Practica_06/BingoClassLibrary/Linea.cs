using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace dsp086.Practica_06
{
    public class Linea
    {
        private bool[] numeros;
        private int count;
        public Linea()
        {
            numeros = new bool[91];
            count = 0;
            for (int i = 0; i < numeros.Length; i++)
                numeros[i] = false;
        }

        public bool[] Numeros
        {
            get
            {
                return numeros;
            }
        }

        public int Count
        {
            get { return count; }
        }


        public void TacharBola(Bola bola)
        {
            if (numeros[bola.Numero])
            {
                numeros[bola.Numero] = false;
                count--;
            }

        }

        public void AñadirBola(Bola bola)
        {
            if (!numeros[bola.Numero])
            {
                numeros[bola.Numero] = true;
                count++;
            }
        }



        public bool Contains(Bola bola)
        {
            return numeros[bola.Numero];
        }



    }
}
