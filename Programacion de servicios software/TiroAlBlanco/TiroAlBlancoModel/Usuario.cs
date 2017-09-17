using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace dsp086.Practica_05
{
    public class Usuario:IUsuario
    {
        public Usuario()
        {
            UsuarioId = "Humano";
        }

        public Usuario(String nombre)
        {
            UsuarioId = nombre;
        }

        public String UsuarioId{ get; set;}

    }
}
