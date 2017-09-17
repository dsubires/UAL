using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace dsp086.Practica_08
{
    public class vmNombre
    {
        public string Nombre { get; set; }
        public override bool Equals(object other)
        {
            vmNombre v = other as vmNombre;
            return Nombre.Equals(v.Nombre);
        }

        public override int GetHashCode()
        {
            return Nombre.GetHashCode();
        }

    }

    public class vmNombreCantidad 
    {
        public string Nombre { get; set; }
        public double Cantidad { get; set; }

        public override bool Equals(object other)
        {
            vmNombreCantidad v = other as vmNombreCantidad;
            return Nombre.Equals(v.Nombre) && Cantidad.Equals(v.Cantidad);
        }

        public override int GetHashCode()
        {
            return Nombre.GetHashCode() + Cantidad.GetHashCode();
        }

    }

    public class vmCategoriaNombre
    {
        public string Categoria { get; set; }
        public string Nombre { get; set; }

        public override bool Equals(object other)
        {
            vmCategoriaNombre v = other as vmCategoriaNombre;
            return Nombre.Equals(v.Nombre) && Categoria.Equals(v.Categoria);
        }

   


        public override int GetHashCode()
        {
            return Nombre.GetHashCode() + Categoria.GetHashCode();
        }
    }
}
