using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.ComponentModel;

namespace dsp086.Practica_03
{
    public class ComparadorPropiedad<T> : IComparer<T> where T : IComparable<T>
    {
        PropertyDescriptor propiedad;
        public ComparadorPropiedad(string nombrePropiedad)
        {
            propiedad = GetProperty(nombrePropiedad);
            if (propiedad == null) throw new MissingFieldException("Propiedad " + propiedad + " no existe.");
        }

        public ComparadorPropiedad()
        {
        }

        public int Compare(T x, T y)
        {
            if (ReferenceEquals(x, y)) return 0;
            if (ReferenceEquals(x, null) && ReferenceEquals(y, null)) return 0;
            if (ReferenceEquals(x, null)) return -1;
            if (ReferenceEquals(y, null)) return 1;
            return (propiedad.GetValue(x) as IComparable).CompareTo(propiedad.GetValue(y));
        }


        private PropertyDescriptor GetProperty(String name)
        {
            T item = (T)Activator.CreateInstance(typeof(T));
            PropertyDescriptor propName = null;
            foreach (PropertyDescriptor propDesc in TypeDescriptor.GetProperties(item))
            {
                if (propDesc.Name.Contains(name)) propName = propDesc;
            }
            return propName;
        }

    }
}
