using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace dsp086.Practica_03
{
    public class EnumeradorDescendente<T> : IEnumerator<T> where T : IComparable<T>
    {

        private Coleccion<T> coleccion;
        private int indice;
        private ComparadorPropiedadDes<T> comparador;

            public EnumeradorDescendente(IEnumerable<T> secuencia, string propiedad)
        {
            coleccion = new Coleccion<T>();
            comparador = new ComparadorPropiedadDes<T>(propiedad);
            foreach (T t in secuencia)
                coleccion.Add(t);
            coleccion.Sort(comparador);
           // indice = coleccion.Count();
            indice = -1;
        }

        public T Current
        {
            get { return coleccion[indice]; }
        }

        public void Dispose()
        {
            throw new NotImplementedException();
        }

        object System.Collections.IEnumerator.Current
        {
            get { return Current; }
        }

        public bool MoveNext()
        {
         //   indice--;
         //  if (indice < 0)
         //       return false;
         //   return true;
            indice++;
            if (coleccion.Count() < indice)
                return false;
            return true;
        }

        public void Reset()
        {
            indice = -1;
        }
    }
}
