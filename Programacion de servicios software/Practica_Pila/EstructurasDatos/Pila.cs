using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace dsp086.Practica_04
{
    public class Pila<T>
    {
        private List<T> elementos;
//        private ArrayList<T> elementos;
        public Pila()
        {
            elementos = new List<T>();
        }
        

        public bool EsVacia {
            get {
                return elementos.Count == 0;
            }
        }


        /// <summary>
        /// push
        /// </summary>
        /// <param name="o"></param>
        public void Meter(T t)
        {
            elementos.Add(t);
        }


        /// <summary>
        /// peek
        /// </summary>
        /// <returns></returns>
        public T VerUltimo()
        {
            if (EsVacia)
                throw new Exception("Error al obtener elemento: Pila Vacia");

            return elementos[elementos.Count-1];
        }


        /// <summary>
        /// peek and pop
        /// </summary>
        /// <returns></returns>
        public T Sacar()
        {
            if (EsVacia)
                throw new Exception("Error al obtener elemento: Pila Vacia");
            
            T output = elementos[elementos.Count - 1];
            elementos.RemoveAt(elementos.Count - 1);
            return output;
        }


        /// <summary>
        /// size
        /// </summary>
        /// <returns></returns>
        public int Tamaño()
        {
            return elementos.Count;
        }


        /// <summary>
        /// clear
        /// </summary>
        public void Vaciar()
        {
            elementos = new List<T>();
        }
    }
}
