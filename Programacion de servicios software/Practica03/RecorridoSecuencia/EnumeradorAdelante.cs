using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace dsp086.Practica_03
{
    public class EnumeradorAdelante<T> : IEnumerator<T>
    {
        private Coleccion<T> coleccion;
        private int indice;

        public EnumeradorAdelante(IEnumerable<T> col){
            coleccion = new Coleccion<T>();
            foreach(T t in col){
                coleccion.Add(t);
            }
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
          //  get { return coleccion[indice]; }
            get { return Current; }
        }

        public bool MoveNext()
        {
            indice++;
            if (coleccion.Count() < indice)
            {
                return false;
            }
            return true;
        }

        public void Reset()
        {
            indice = -1;
        }
    }
}
