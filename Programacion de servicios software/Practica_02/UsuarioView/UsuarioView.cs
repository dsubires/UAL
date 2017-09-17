using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace dsp086.Practica_02
{
    public class UsuarioView : IUsuarioView, IEquatable<UsuarioView>, IComparable<UsuarioView>
    {


        public UsuarioView() { }
        public UsuarioView(int id, string nombre, string palabraPaso, string categoria, bool esValido)
        {
            this.Id = id + "";   // representa el identificador único del objeto
            this.Nombre = nombre;
            this.PalabraPaso = palabraPaso;
            this.Categoria = categoria;
            this.EsValido = esValido;
        }


        public string Id { get; set; }
        public string Nombre { get; set; }
        public string PalabraPaso { get; set; }
        public string Categoria { get; set; }
        public bool EsValido { get; set; }


        # region IEquatable<T> Members
    
        public bool Equals(UsuarioView user)
        {
            if (user != null)
            {
                return this.Id.Equals(user.Id);
            }

            return false;
        }

        public override bool Equals(Object obj)
        {
            if (obj != null) {
                UsuarioView user = obj as UsuarioView;
                if (user != null)
                {
                    return Equals(user);
                }
            }
            return false;
        }


        public override int GetHashCode()
        {
            //return base.GetHashCode();
            //return this.Id.GetHashCode;
          return  Convert.ToInt16(Id);
        }

    
        
        # endregion


        # region IComparable<T> Members

        public int CompareTo(UsuarioView user)
        {
            if (ReferenceEquals(user, null))
                return 1;
            if (ReferenceEquals(this, user))
                return 0;
            return this.Id.CompareTo(user.Id);
        }

        public static bool operator ==(UsuarioView user1, UsuarioView user2){
            if (ReferenceEquals(user1, null) && ReferenceEquals(user2, null))
                return true;
            if (ReferenceEquals(user1, null))
                return false;
            if (ReferenceEquals(user2, null))
                return false;
            return user1.Equals(user2);
        }

        public static bool operator !=(UsuarioView user1, UsuarioView user2)
        {
            return !(user1 == user2);
        }

        public static bool operator >(UsuarioView user1, UsuarioView user2)
        {
            if (ReferenceEquals(user1, user2))
                return false;
            if (ReferenceEquals(user1, null))
                return false;
            if (ReferenceEquals(user2, null))
                return true;
            return (user1.CompareTo(user2) > 0);

        }

        public static bool operator <(UsuarioView user1, UsuarioView user2)
        {
            if (ReferenceEquals(user1, user2))
                return false;
            if (ReferenceEquals(user2, null))
                return false;
            if (ReferenceEquals(user1, null))
                return true;
            return (user1.CompareTo(user2) < 0);
        }

        public static bool operator >=(UsuarioView user1, UsuarioView user2){
            if (ReferenceEquals(user1, user2))
                return true;
            if (ReferenceEquals(user1, null))
                return false;
            if (ReferenceEquals(user2, null))
                return true;
            return (user1.CompareTo(user2) >= 0);
        }

        public static bool operator <=(UsuarioView user1, UsuarioView user2)
        {
            if (ReferenceEquals(user1, user2))
                return true;
            if (ReferenceEquals(user1, null))
                return true;
            if (ReferenceEquals(user2, null))
                return false;
            return (user1.CompareTo(user2) <= 0);
        }

        # endregion


    }
}
