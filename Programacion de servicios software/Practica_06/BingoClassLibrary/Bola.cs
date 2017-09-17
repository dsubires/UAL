using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace dsp086.Practica_06
{
    public class Bola : IEqualityComparer<Bola>, IEquatable<Bola>
    {
        private int numero;
        public Bola()
        {

        }

        public int Numero
        {
            get
            {
                return numero;
            }
            set
            {
                if (value < 1 || value > 90)
                    throw new ArgumentOutOfRangeException();
                numero = value;
            }

        }



        public override bool Equals(object o)
        {
            return Equals(o as Bola);
        }

        public bool Equals(Bola b)
        {
            return Equals(this, b);
        }

        public bool Equals(Bola x, Bola y)
        {
            if (ReferenceEquals(x, y))
                return true;
            if (ReferenceEquals(x, null) || ReferenceEquals(y, null))
                return false;
            return (x.Numero == y.Numero);
        }

        public static bool operator ==(Bola a, Bola b)
        {
            return a.Equals(b);
        }

        public static bool operator !=(Bola a, Bola b)
        {
            return !a.Equals(b);
        }

        public override int GetHashCode()
        {
            return this.Numero.GetHashCode();
        }
        public int GetHashCode(Bola b)
        {
            return b.Numero.GetHashCode();
        }
    }
}
