using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace dsp086.Practica_03
{
    public class Coleccion<T> : List<T>, IEnumerable<T>
    {

        public Coleccion()
        {
        }

        public Coleccion(IEnumerable<T> secuencia) :base (secuencia)
        {
        }


        public new void Add(T item)
        {
            base.Add(item);
        }

        public new bool Remove(T item)
        {
            return base.Remove(item);
        }

        public new bool Contains(T item)
        {
            return base.Contains(item);
        }

        public new void Clear()
        {
            base.Clear();
        }

        public new int Count()
        {
            return base.Count;
        }

        public new void Sort(IComparer<T> comparador)
        {
            base.Sort(comparador);
        }

        public new T this[int index]{
            get { return base[index]; }
            set { base[index] = value; }
        }




        IEnumerator<T> IEnumerable<T>.GetEnumerator()
        {
            return base.GetEnumerator();
        }

        System.Collections.IEnumerator System.Collections.IEnumerable.GetEnumerator()
        {
            return base.GetEnumerator();
        }
    }
}
