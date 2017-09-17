using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Exceptions
{
    public class AutentificacionExcepcion : Exception
    {
        private string p;
        private global::Principal.CodigoAutentificacion globalPrincipalCodigoAutentificacion;

        public AutentificacionExcepcion(string p, global::Principal.CodigoAutentificacion globalPrincipalCodigoAutentificacion)
        {
            // TODO: Complete member initialization
            this.p = p;
            this.globalPrincipalCodigoAutentificacion = globalPrincipalCodigoAutentificacion;
        }
    }
}
