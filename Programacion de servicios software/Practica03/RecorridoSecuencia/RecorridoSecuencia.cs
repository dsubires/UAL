using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace dsp086.Practica_03
{
    public class RecorridoSecuencia<T> : IEnumerable<T> where T : IComparable<T>
    {

        private IEnumerable<T> secuencia;

        public RecorridoSecuencia(IEnumerable<T> coleccion)
        {
            secuencia = coleccion;
        }

        public IEnumerator<T> GetEnumerator()
        {
            return secuencia.GetEnumerator();
        }

        System.Collections.IEnumerator System.Collections.IEnumerable.GetEnumerator()
        {
            return GetEnumerator();
        }

        public IEnumerator<T> YieldAdelante()
        {
            foreach (T t in secuencia)
                yield return t;
        }

        public IEnumerator<T> YieldAtras()
        {
            for (int i = secuencia.Count() - 1; i > -1; i--)
                yield return secuencia.ElementAt(i);
        }

        public IEnumerator<T> YieldAscendente(string propiedad)
        {
            Coleccion<T> secuenciaTemp = new Coleccion<T>(secuencia);
            secuenciaTemp.Sort(new ComparadorPropiedad<T>(propiedad));
            foreach (T t in secuenciaTemp)
                yield return t;
        }

        public IEnumerator<T> YieldDescendente(string propiedad)
        {
            Coleccion<T> secuenciaTemp = new Coleccion<T>(secuencia);
            secuenciaTemp.Sort(new ComparadorPropiedadDes<T>(propiedad));
            foreach (T t in secuenciaTemp)
                yield return t;
        }
    }
}
