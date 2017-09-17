using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace dsp086.Practica_08
{
   public class Personal
    {
        public int Id { get; set; }
        public String Email { get; set; }
        public DateTime FechaAlta { get; set; }
        public String Password { get; set; }
        public int UsuarioId { get; set; }
        public int AplicacionId { get; set; }
        public bool EstaBloqueado { get; set; }


    }
}
