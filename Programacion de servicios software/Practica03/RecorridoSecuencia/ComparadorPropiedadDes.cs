using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace dsp086.Practica_03
{
    class ComparadorPropiedadDes<T> : IComparer<T> where T : IComparable<T>
    {

        ComparadorPropiedad<T> comparadorAsc;
        public ComparadorPropiedadDes(string nombrePropiedad)
        {
            comparadorAsc = new ComparadorPropiedad<T>(nombrePropiedad);

        }

        public int Compare(T x, T y)
        {
            return comparadorAsc.Compare(y,x);
        }
    }
}
